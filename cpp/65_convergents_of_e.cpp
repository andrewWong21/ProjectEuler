#include <iostream>
#include <vector>
#include <algorithm>

std::string add(std::string num1, std::string num2){
    // digits holds place values in reverse order
    std::vector<int> digits(std::max(num1.size(), num2.size()), 0);
    // reverse operands for easier iteration
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
    // format digits into string after removing leading zeros
    std::string res = "";
    int i = digits.size() - 1;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

std::string multiply(std::string num1, std::string num2){
    // digits holds place values in reverse order
    std::vector<int> digits(num1.size() + num2.size(), 0);
    // reverse operands for easier iteration
    std::reverse(num1.begin(), num1.end());
    std::reverse(num2.begin(), num2.end());
    int idx1 = 0;
    for (int i = 0; i < num1.size(); i++){
        int carry = 0;
        int idx2 = 0;
        int d1 = num1[i] - '0';
        for (int j = 0; j < num2.size(); j++){
            int d2 = num2[j] - '0';
            int digit = d1 * d2 + digits[idx1 + idx2] + carry;
            digits[idx1 + idx2] = digit % 10;
            carry = digit / 10;
            idx2++;
        }
        if (carry > 0) digits[idx1 + idx2] += carry;
        idx1++;
    }
    // format digits into string after removing leading zeros
    std::string res = "";
    int i = digits.size() - 1;
    while (digits[i] == 0) i--;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

int convergents_of_e(){
    // 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, ...
    //  3 =  2(1) + 1
    //  8 =  3(2) + 2
    // 11 =  8(1) + 3
    // 19 = 11(1) + 8
    // 87 = 19(4) + 19
    
    std::string prev = "1", curr = "2";
    int k = 1;
    for (int i = 2; i <= 100; i++){
        int r = 1;
        if (i % 3 == 0){
            r = 2 * k++;
        }
        std::string temp = prev;
        prev = curr;
        curr = add(multiply(curr, std::to_string(r)), temp);
    }
    int total = 0;
    for (auto c : curr){
        total += int(c) - '0';
    }
    return total;
}

int main(){
    std::cout << convergents_of_e() << "\n";
}
