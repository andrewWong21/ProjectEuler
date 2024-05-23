#include <iostream>
#include <vector>

int maximum_path_sum_i(std::vector<std::vector<int>> triangle){
    for (int r = triangle.size() - 2; r >= 0; r--){
        for (int c = 0; c < triangle[r].size(); c++){
            int num1 = triangle[r + 1][c];
            int num2 = triangle[r + 1][c + 1];
            triangle[r][c] += num1 > num2 ? num1 : num2;
        }
    }
    return triangle[0][0];
}

int main() {
    std::vector<std::vector<int>> triangle;
    triangle.push_back(std::vector<int> {75});
    triangle.push_back(std::vector<int> {95, 64});
    triangle.push_back(std::vector<int> {17, 47, 82});
    triangle.push_back(std::vector<int> {18, 35, 87, 10});
    triangle.push_back(std::vector<int> {20, 04, 82, 47, 65});
    triangle.push_back(std::vector<int> {19, 01, 23, 75, 03, 34});
    triangle.push_back(std::vector<int> {88, 02, 77, 73, 07, 63, 67});
    triangle.push_back(std::vector<int> {99, 65, 04, 28, 06, 16, 70, 92});
    triangle.push_back(std::vector<int> {41, 41, 26, 56, 83, 40, 80, 70, 33});
    triangle.push_back(std::vector<int> {41, 48, 72, 33, 47, 32, 37, 16, 94, 29});
    triangle.push_back(std::vector<int> {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14});
    triangle.push_back(std::vector<int> {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57});
    triangle.push_back(std::vector<int> {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48});
    triangle.push_back(std::vector<int> {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31});
    triangle.push_back(std::vector<int> {04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23});
    std::cout << maximum_path_sum_i(triangle) << "\n";
}
