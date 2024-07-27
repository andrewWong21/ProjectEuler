#include <iostream>
#include <fstream>
#include <cstring>
#include <sstream>
#include <vector>
#include <queue>
#include <limits>

// minheap ordering of priority queue
struct ComparePath{
    bool operator()(const std::pair<int, std::pair<int, int>>& p1, const std::pair<int, std::pair<int, int>>& p2) {
        return p1.first > p2.first;
    }
};

int path_sum_four_ways(std::vector<std::vector<int>> matrix){
    int rows = matrix.size(), cols = matrix[0].size();
    // store minimum path sums to reach each cell
    std::vector<std::vector<int>> pathSums;
    for (int r = 0; r < rows; r++){
        std::vector<int> row;
        for (int c = 0; c < cols; c++){
            // initialize sum as maximum integer value
            row.push_back(std::numeric_limits<int>::max());
        }
        pathSums.push_back(row);
    }
    // starting at top left cell, ending at bottom right cell
    pathSums[0][0] = matrix[0][0];
    
    // store (path_sum, (r, c)) in priority queue, ordered by smallest path sum first
    std::priority_queue<std::pair<int, std::pair<int, int>>,
                        std::vector<std::pair<int, std::pair<int, int>>>,
                        ComparePath> pq;
    pq.push({pathSums[0][0], {0, 0}});
    
    while (!pq.empty()){
        // top does not pop from queue, pop does not return value
        int r = pq.top().second.first, c = pq.top().second.second;
        pq.pop();
        
        // check neighboring cells
        int dirs[] = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++){
            int newR = r + dirs[k], newC = c + dirs[k + 1];
            if (0 <= newR and newR < rows and 0 <= newC and newC < cols){
                // continue path from neighboring cell if better path found
                int path = pathSums[r][c] + matrix[newR][newC];
                if (path < pathSums[newR][newC]){
                    pathSums[newR][newC] = path;
                    pq.push({pathSums[newR][newC], {newR, newC}});
                }
            }
        }
    }
    // return minimum path sum from top left to bottom right
    return pathSums[rows - 1][cols - 1];
}

int main(){
    std::ifstream file("/uploads/83_matrix.txt");
    std::string s;
    std::vector<std::vector<int>> matrix;
    
    // parse text file and extract matrix entries
    while (std::getline(file, s)){
        std::vector<int> row;
        std::stringstream ss(s);
        std::string num;
        while (std::getline(ss, num, ',')){
            row.push_back(std::stoi(num));
        }
        matrix.push_back(row);
    }
    file.close();
    
    std::cout << path_sum_four_ways(matrix) << "\n";
}
