#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <cmath>

int largest_exponential(std::vector<std::pair<int, int>> pairs){
    // store maximum value seen and corresponding line number (1-indexed)
    int res = 0;
    double max_val = 0;
    for (int i = 0; i < pairs.size(); i++){
        // extract base and exponent from pair
        int base = pairs[i].first, power = pairs[i].second;
        // calculate exponent * log(base)
        // comparing logarithms of base-exponent pairs
        // uses smaller values while still maintaining ordering
        double val = power * std::log10(base);
        // update maximum value and line number
        if (val > max_val){
            max_val = val;
            res = i + 1;
        }
    }
    return res;
}

int main(){
    // store base-exponent pairs in ordered vector
    std::vector<std::pair<int, int>> pairs;
    std::ifstream file("/uploads/99_base_exp.txt");
    
    std::string line;
    while (std::getline(file, line)) {
        // extract base and exponent from string of 2 comma-separated values
        std::istringstream stream(line);
        std::string base_str, power_str;

        std::getline(stream, base_str, ',');
        std::getline(stream, power_str, ',');

        int base = std::stoi(base_str);
        int power = std::stoi(power_str);

        pairs.emplace_back(base, power);
    }
    file.close();
    
    std::cout << largest_exponential(pairs) << "\n";
}
