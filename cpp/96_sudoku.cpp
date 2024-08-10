#include <iostream>
#include <fstream>
#include <vector>
//#include <string>

bool canPlace(std::vector<std::vector<int>> board, int row, int col, int digit){
    // check if digit to place already exists in column
    for (int i = 0; i < 9; i++){
        if (board[i][col] == digit) return false;
    }
    // check if digit to place already exists in row
    for (int j = 0; j < 9; j++){
        if (board[row][j] == digit) return false;
    }
    // check if digit to place already exists in box
    // determine top row and left column of box containing cell
    int top = 3 * (row / 3), left = 3 * (col / 3);
    for (int r = top; r <= top + 2; r++){
        for (int c = left; c <= left + 2; c++){
            if (board[r][c] == digit) return false;
        }
    }
    // no conflicts in row, column, or box
    return true;
}

int solve(std::vector<std::vector<int>>& board){ // modify board in-place
    // iterate over cells in board, left to right, top to bottom
    for (int r = 0; r < 9; r++){
        for (int c = 0; c < 9; c++){
            if (board[r][c] == 0){ // empty cell
                // test each valid candidate for cell
                for (int d = 1; d <= 9; d++){
                    if (canPlace(board, r, c, d)){
                        board[r][c] = d;
                        if (solve(board)) return true;
                        // search did not lead to valid solution
                        // backtrack by resetting cell to empty
                        else board[r][c] = 0;
                    }
                }
                // invalid board configuration - no number fits in current empty cell
                return false;
            }
        }
    }
    // board is fully solved
    return true;
}

int sudoku(std::vector<std::vector<std::vector<int>>> boards){
    int total = 0;
    for (std::vector<std::vector<int>> board : boards){
        solve(board);
        // add 3-digit number in top-left corner of solved board to total
        total += board[0][0] * 100 + board[0][1] * 10 + board[0][2];
    }
    return total;
}

int main(){
    std::ifstream file("/uploads/96_sudoku.txt");
    std::string s;
    std::vector<std::vector<std::vector<int>>> boards;
    
    std::vector<std::vector<int>> board;
    while (std::getline(file, s)){
        // skip grid headers
        if (s.find("Grid") == std::string::npos){
            // create row for puzzle and populate with digits
            std::vector<int> row;
            for (auto c : s){
                row.push_back(int(c) - '0');
            }
            // add row to puzzle
            board.push_back(row);
            
            if (board.size() == 9){
                // append complete formatted board to boards
                boards.push_back(board);
                board.clear();
            }
        }
    }
    file.close();
    
    std::cout << sudoku(boards) << "\n";
}
