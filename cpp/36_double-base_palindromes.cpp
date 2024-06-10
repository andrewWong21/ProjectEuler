#include <iostream>
#include <bitset>
#include <string>
#include <algorithm>

bool is_palindrome(std::string s){
    // check if reversed copy of string is equal to original string
    std::string p = s;
    std::reverse(p.begin(), p.end());
    return s == p;
}

int double_base_palindromes(){
    int total = 0;
    for (int i = 1; i < 1'000'000; i++){
        // get binary representation of decimal number
        // 21 bits required to store numbers up to 1 million
        // 2^20 = 1,048,576
        std::string bin = std::bitset<21>(i).to_string();
        // remove leading zeros
        bin = bin.substr(bin.find('1'));
        if (is_palindrome(std::to_string(i)) and is_palindrome(bin)){
            total += i;
        }
    }
    return total;
}

int main(){
    std::cout << double_base_palindromes() << "\n";
}
