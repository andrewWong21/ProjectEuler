#include <iostream>
#include <algorithm>

bool is_palindrome(std::string num){
    std::string rev = std::string(num.begin(), num.end());
    std::reverse(rev.begin(), rev.end());
    return num == rev;
}

int lychrel_numbers(){
    int count = 0;
    for (int n = 1; n < 10'000; n++){
        bool is_lychrel = true;
        std::string num = std::to_string(n);
        
        for (int i = 0; i < 50; i++){
            std::string rev = std::string(num);
            std::reverse(rev.begin(), rev.end());
            
            int carry = 0;
            std::string digits = "";
            for (int i = 0; i < num.size(); i++){
                int digitSum = carry;
                digitSum += (int(num[i]) - '0') + (int(rev[i]) - '0');
                digits += std::to_string(digitSum % 10);
                carry = digitSum / 10;
            }
            num = digits;
            if (carry > 0) num += std::to_string(carry);
            
            if (is_palindrome(num)){
                is_lychrel = false;
                break;
            }
        }
        if (is_lychrel){
            count++;
        }
    }
    return count;
}

int main(){
    std::cout << lychrel_numbers() << "\n";
}
