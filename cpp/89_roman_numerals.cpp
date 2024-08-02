#include <iostream>
#include <fstream>
#include <vector>
#include <string>

int roman_numerals(std::vector<std::string> numerals){
    // store numerals and corresponding values
    std::vector<std::string> groups = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    std::vector<int> counts = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    int saved = 0;
    for (std::string num : numerals){
        // calculate value of number written in numeral form
        int total = 0, old_len = num.size();
        for (int idx = 0; idx < groups.size(); idx++){
            // add value of found numeral group prefix to total
            while (num.find(groups[idx]) == 0){
                num = num.substr(groups[idx].size());
                total += counts[idx];
            }
        }
        // calculate length of minimal form
        int new_len = 0;
        for (int idx = 0; idx < groups.size(); idx++){
            // add size of largest applicable numeral group to length
            while (total >= counts[idx]){
                new_len += groups[idx].size();
                total -= counts[idx];
            }
            if (total == 0) break;
        }
        // add difference in lengths between original and minimal forms
        saved += old_len - new_len;
    }
    return saved;
}

int main(){
    std::ifstream file("/uploads/89_roman.txt");
    std::string s;
    std::vector<std::string> numerals;
    
    while (std::getline(file, s)){
        numerals.push_back(s);
    }
    file.close();
    std::cout << roman_numerals(numerals) << "\n";
}
