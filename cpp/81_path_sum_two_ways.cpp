#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cstring>

int path_sum_two_ways(std::vector<std::vector<int>> matrix){
    for (int r = matrix.size() - 1; r >= 0; r--){
        for (int c = matrix[0].size() - 1; c >= 0; c--){
            if (r == matrix.size() - 1 and c == matrix[0].size() - 1) continue;
            // only one subsequent cell possible for cells in bottom row or rightmost column
            if (r == matrix.size() - 1){
                matrix[r][c] += matrix[r][c + 1];
            }
            else if (c == matrix[0].size() - 1){
                matrix[r][c] += matrix[r + 1][c];
            }
            // add minimum of cells immediately right and below current cell
            else {
                matrix[r][c] += std::min(matrix[r + 1][c], matrix[r][c + 1]);
            }
        }
    }
    // top left cell contains minimal path sum
    return matrix[0][0];
}

int main(){
    std::ifstream file("/uploads/81_matrix.txt");
    std::string s;
    std::vector<std::vector<int>> matrix;
    
    // tokenize each line into vector of ints
    while (std::getline(file, s)){
        std::vector<int> row;
        char *pch = std::strtok(&s[0], ",");
        while (pch != NULL){
            std::string num(pch);
            row.push_back(stoi(num));
            pch = std::strtok(NULL, ",");
        }
        matrix.push_back(row);
    }
    file.close();
    
    std::cout << path_sum_two_ways(matrix) << "\n";
}
