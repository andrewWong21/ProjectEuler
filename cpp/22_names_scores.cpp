#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>

int names_scores(std::vector<std::string> names){
    int total = 0;
    for (int i = 0; i < names.size(); i++){
        int score = 0;
        for (char c : names[i]){
            // A = 1, B = 2, C = 3, ..., Z = 26
            score += c - 'A' + 1;
        }
        // multiply score by alphabetical position of name in vector
        total += (i + 1) * score;
    }
    return total;
}

int main(){
    // read names from file and store in string
    std::ifstream file("/uploads/22_names.txt");
    std::string s;
    std::getline(file, s);
    file.close();
    
    // remove double quotes from string
    s.erase(std::remove(s.begin(), s.end(), '\"'), s.end());
    
    // tokenize string with comma delimiter
    std::vector<std::string> names;
    char *pch = std::strtok(&s[0], ",");
    while (pch != NULL){
        names.push_back(pch);
        pch = std::strtok(NULL, ",");
    }
    
    // sort vector of names alphabetically
    std::sort(names.begin(), names.end());
    std::cout << names_scores(names) << "\n";
}
