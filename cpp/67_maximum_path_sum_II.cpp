#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cstring>

int maximum_path_sum_II(std::vector<std::vector<int>> triangle){
    for (int r = triangle.size() - 2; r >= 0; r--){
        for (int c = 0; c < triangle[r].size(); c++){
            // maximum path sum from given number is sum of number and
            // maximum of path sums through adjacent numbers on next row
            triangle[r][c] += std::max(triangle[r + 1][c], triangle[r + 1][c + 1]);
        }
    }
    // top of triangle contains maximum path sum
    return triangle[0][0];
}

int main(){
    std::ifstream file("/uploads/67_triangle.txt");
    std::string s;
    std::vector<std::vector<int>> triangle;
    
    // each row is a separate line in the file
    // tokenize each line into vector of ints
    while (std::getline(file, s)){
        std::vector<int> row;
        char *pch = std::strtok(&s[0], " ");
        while (pch != NULL){
            std::string num(pch);
            row.push_back(stoi(num));
            pch = std::strtok(NULL, " ");
        }
        triangle.push_back(row);
    }
    file.close();
    std::cout << maximum_path_sum_II(triangle) << "\n";
}
