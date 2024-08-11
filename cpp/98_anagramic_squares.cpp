#include <iostream>
#include <fstream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <unordered_set>
#include <unordered_map>

int get_max_square(std::vector<std::string> words, std::unordered_set<int> squares){
    int max_square = 0;
    for (int square : squares){
        std::string sq = std::to_string(square);
        
        for (int i = 0; i < words.size() - 1; i++){
            std::string word1 = words[i];
            // check if word1 corresponds to a valid letter mapping of current square
            std::unordered_map<char, char> charMap;
            std::unordered_map<char, char> digitMap;
            bool valid = true;
            for (int i = 0; i < word1.size(); i++){
                // character is already assigned to a different digit or
                // digit is already assigned to a different character
                if ((charMap.find(word1[i]) != charMap.end() && charMap[word1[i]] != sq[i]) ||
                    (digitMap.find(sq[i]) != digitMap.end() && digitMap[sq[i]] != word1[i])){
                    valid = false;
                    break;
                }
                charMap[word1[i]] = sq[i];
                digitMap[sq[i]] = word1[i];
            }
            if (!valid) continue;
            
            std::string digits1;
            for (char d : word1){
                digits1.push_back(charMap[d]);
            }
            
            for (int j = i + 1; j < words.size(); j++){
                std::string word2 = words[j];
                std::string digits;
                for (char c : word2){
                    digits.push_back(charMap[c]);
                }
                // if word2 also corresponds to a letter mapping of a different square
                // then word1 and word2 form a square anagram word pair
                // update max_square if either square formed is larger
                if (squares.find(std::stoi(digits)) != squares.end()){
                    max_square = std::max({max_square, std::stoi(digits), std::stoi(digits1)});
                }
            }
            
        }
    }
    return max_square;
}

int anagramic_squares(std::vector<std::string> words){
    // group words by used letters
    std::unordered_map<std::string, std::vector<std::string>> anagram_lists;
    int max_len = 0;
    for (std::string& word : words){
        std::string letters = word;
        std::sort(letters.begin(), letters.end());
        anagram_lists[letters].push_back(word);
        // update maximum length of letter string with at least 2 anagrams
        if (anagram_lists[letters].size() > 1){
            max_len = std::max(max_len, int(word.size()));
        }
    }
    // group squares by number of digits
    std::unordered_map<int, std::unordered_set<int>> squares;
    for (int i = 1; i < max_len; i++){
        squares[i] = {};
    }
    // generate squares with up to max_len digits
    int i = 1;
    while (true){
        std::string s = std::to_string(i * i);
        if (s.size() > max_len) break;
        squares[s.size()].insert(i * i);
        i++;
    }
    // get maximum square number that can be formed from
    // digital substitutions of a pair of anagrams
    int max_square = 0;
    for (auto& pair : anagram_lists){
        // consider anagram lists containing at least two anagrams that have at least as many letters
        // as digits in the current largest square shown to be formed from a square anagram word pair
        if (pair.second.size() > 1 && pair.first.size() >= std::to_string(max_square).size()){
            max_square = std::max(max_square, get_max_square(pair.second, squares[pair.first.size()]));
        }
    }
    return max_square;
}

int main(){
    // words are written on a single line
    // surrounded by quotes and delimited by commas
    std::ifstream file("/uploads/98_words.txt");
    std::string s;
    std::getline(file, s);
    file.close();
    
    // remove double quotes from string
    s.erase(std::remove(s.begin(), s.end(), '\"'), s.end());
    
    // tokenize formatted string with comma delimiter
    std::vector<std::string> words;
    char *pch = std::strtok(&s[0], ",");
    while (pch != NULL){
        words.push_back(pch);
        pch = std::strtok(NULL, ",");
    }
    std::cout << anagramic_squares(words) << "\n";
}
