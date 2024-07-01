#include <iostream>
#include <vector>
#include <algorithm>

std::string add(std::string num1, std::string num2){
    std::vector<int> digits(std::max(num1.size(), num2.size()), 0);
    std::reverse(num1.begin(), num1.end());
    std::reverse(num2.begin(), num2.end());
    int carry = 0;
    for (int i = 0; i < digits.size(); i++){
        int digit = carry;
        if (i < num1.size()) digit += num1[i] - '0';
        if (i < num2.size()) digit += num2[i] - '0';
        digits[i] = digit % 10;
        carry = digit / 10;
    }
    if (carry > 0) digits.push_back(carry);
    std::string res = "";
    int i = digits.size() - 1;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

std::string multiply(std::string num1, std::string num2){
    std::vector<int> digits(num1.size() + num2.size(), 0);
    int idx1 = 0;
    for (int i = num1.size() - 1; i >= 0; i--){
        int carry = 0;
        int idx2 = 0;
        int d1 = num1[i] - '0';
        for (int j = num2.size() - 1; j >= 0; j--){
            int d2 = num2[j] - '0';
            int digit = d1 * d2 + digits[idx1 + idx2] + carry;
            digits[idx1 + idx2] = digit % 10;
            carry = digit / 10;
            idx2++;
        }
        if (carry > 0) digits[idx1 + idx2] += carry;
        idx1++;
    }
    std::string res = "";
    int i = digits.size() - 1;
    while (digits[i] == 0) i--;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

int square_root_convergents(){
    // c_x = n / d
    // c_(x+1) = 1 + (1 / (1 + n/d))
    // c_(x+1) = (2 + n/d) / (1 + n/d)
    // c_(x+1) = (2 * d + n) / (d + n)
    
    // c_1 = (2 * (1) + (1)) / (1 + 1) = 3/2
    // c_2 = (2 * (2) + (3)) / (3 + 2) = 7/5
    // c_3 = (2 * (5) + (7)) / (7 + 5) = 17/12
    int count = 0;
    
    std::string num = "1", den = "1";
    for (int i = 2; i <= 1000; i++){
        std::string new_num = add(num, multiply("2", den));
        std::string new_den = add(num, den);
        num = new_num;
        den = new_den;
        if (num.size() > den.size()) count++;
    }
    return count;
}

int main(){
    std::cout << square_root_convergents() << "\n";
}
