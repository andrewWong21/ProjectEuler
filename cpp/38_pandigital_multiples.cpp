#include <iostream>
#include <string>
#include <set>
#include <algorithm>

bool is_pandigital(std::string s){
    std::set<char> seen(s.begin(), s.end());
    return seen.find('0') == seen.end() and seen.size() == 9;
}

int pandigital_multiples(){
    int res = 918273645; // (9, 18, 27, 36, 45)
    // n can have 4 digits maximum, then next multiple must have 5 digits
    // cannot concatenate more than 2 multiples of a 4-digit number without exceeding 9 digits
    for (int i = 9876; i > 0; i--){
        std::string s = std::to_string(i);
        if (s[0] != '9') continue;
        // concatenate subsequent multiples until s has at least 9 digits
        for (int n = 2; s.size() < 9; n++){
            s += std::to_string(i * n);
        }
        if (s.size() == 9 and is_pandigital(s)){
            res = std::max(res, stoi(s));
        }
    }
    return res;
}

int main(){
    std::cout << pandigital_multiples() << "\n";
}
