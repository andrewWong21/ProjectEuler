#include <iostream>
#include <vector>
#include <algorithm>

bool check_sums(std::vector<int> outer, std::vector<int> inner){
    int sum = outer[4] + inner[4] + inner[0];
    for (int i = 0; i < 4; i++){
        if (outer[i] + inner[i] + inner[i + 1] != sum) return false;
    }
    return true;
}

std::string stringify(std::vector<int> outer, std::vector<int> inner){
    std::string res = "";
    for (int i = 0; i < 4; i++){
        res += std::to_string(outer[i]) + std::to_string(inner[i]) + std::to_string(inner[i + 1]);
    }
    res += std::to_string(outer[4]) + std::to_string(inner[4]) + std::to_string(inner[0]);
    return res;
}

std::string magic_5gon_ring(){
    std::string res = "";
    // for string representation to have 16 digits, 10 must be an external node
    std::vector<int> outer = {6, 7, 8, 9, 10};
    // only consider string representations starting with numerically lowest external node
    // permute outer ring until outer[0] becomes 7
    while (outer[0] == 6){
        std::vector<int> inner = {1, 2, 3, 4, 5};
        // consider each permutation of inner ring
        while(std::next_permutation(inner.begin(), inner.end())){
            // check that each line of nodes has the same sum
            if (check_sums(outer, inner)){
                // all valid string representations are 16 digits
                // lexicographically last and numerically greatest are equivalent here
                res = max(res, stringify(outer, inner));
            }
        }
        std::next_permutation(outer.begin(), outer.end());
    }
    return res;
}

int main(){
    std::cout << magic_5gon_ring() << "\n";
}
