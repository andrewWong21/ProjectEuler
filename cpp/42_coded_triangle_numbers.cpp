#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
#include <cmath>

bool is_triangle_number(int t){
    // t = n * (n + 1) / 2
    // 2t = n^2 + n
    // n^2 + n - 2t = 0
    // n = (-1 + sqrt(1 - 4*1*(-2t))) / 2
    // n = (-1 + sqrt(1 + 8t)) / 2
    double n = (std::sqrt(8*t + 1) - 1) / 2;
    return n == int(n);
}

int coded_triangle_numbers(std::vector<std::string> words){
    int count = 0;
    for (std::string word : words){
        int sum = 0;
        // convert letters to numbers and calculate sum
        for (char c : word){
            sum += c - 'A' + 1;
        }
        if (is_triangle_number(sum)) count++;
    }
    return count;
}

int main(){
    // words are surrounded by quotes and separated by commas
    // full list of words is written on a single line
    std::ifstream file("/uploads/42_words.txt");
    std::string s;
    // read line of file into string
    std::getline(file, s);
    // remove double quotes
    s.erase(std::remove(s.begin(), s.end(), '\"'), s.end());
    file.close();
    
    // tokenize string
    std::vector<std::string> words;
    char *pch = std::strtok(&s[0], ",");
    while (pch != NULL){
        words.push_back(pch);
        pch = std::strtok(NULL, ",");
    }
    
    std::cout << coded_triangle_numbers(words) << "\n";
}
