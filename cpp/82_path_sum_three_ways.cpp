#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cstring>

int path_sum_three_ways(std::vector<std::vector<int>> matrix){
    int rows = matrix.size(), cols = matrix[0].size();
    
    // make copy of first column of matrix
    std::vector<int> min_sums;
    for (int r = 0; r < rows; r++){
        min_sums.push_back(matrix[r][0]);
    }
    
    for (int c = 0; c < cols; c++){
        for (int r = 0; r < rows; r++){
            // minimum path sum after moving right from left neighbor
            min_sums[r] += matrix[r][c];
            
            // check if approaching matrix[r][c] from above has smaller path sum
            if (r > 0){
                min_sums[r] = std::min(min_sums[r], min_sums[r - 1] + matrix[r][c]);
            }
        }
        
        // check if approaching matrix[r][c] from below has smaller path sum
        for (int r = rows - 2; r >= 0; r--){
            min_sums[r] = std::min(min_sums[r], min_sums[r + 1] + matrix[r][c]);
        }
    }
    int min_path = min_sums[0];
    for (int sum : min_sums){
        min_path = std::min(min_path, sum);
    }
    return min_path;
}

int main(){
    std::ifstream file("/uploads/82_matrix.txt");
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
    
    std::cout << path_sum_three_ways(matrix) << "\n";
}
