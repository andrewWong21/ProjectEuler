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
    if (carry != 0) digits.push_back((carry + 10) % 10);
    std::string res = "";
    int i = digits.size() - 1;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

std::string subtract(std::string num1, std::string num2){
    if (num1 == num2) return "0";
    std::vector<int> digits(std::max(num1.size(), num2.size()), 0);
    std::reverse(num1.begin(), num1.end());
    std::reverse(num2.begin(), num2.end());
    int carry = 0;
    for (int i = 0; i < digits.size(); i++){
        int digit = carry;
        if (i < num1.size()) digit += num1[i] - '0';
        if (i < num2.size()) digit -= num2[i] - '0';
        digits[i] = (digit + 10) % 10;
        carry = digit < 0 ? -1 : 0;
    }
    if (carry != 0) digits.push_back((carry + 10) % 10);
    std::string res = "";
    int i = digits.size() - 1;
    while (digits[i] == 0) i--;
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

bool num_gte(std::string num1, std::string num2){
    // compare digit strings numerically
    // return whether num1 is greater than or equal to num2
    
    // check if num1 has more digits or is the same string as num2
    // if same number of digits, compare lexicographically
    if (num1.size() > num2.size() or num1 == num2 or 
        (num1.size() == num2.size() and num1 > num2)) return true;
    // num1 has fewer digits or is lexicographically smaller with the same number of digits
    return false;
}

std::string get_square_root(int n){
    // generate square root digit by digit
    // https://studylib.net/doc/7921494/square-roots-by-subtraction---jarvis--frazer
    
    // initialize a = 5*n, b = 5
    std::string a = std::to_string(5 * n), b = std::to_string(5);
    // b stores guaranteed correct digits of sqrt(n) in all but last 2 places
    while (b.size() <= 102){
        // if a >= b, subtract a from b and add 10 to b
        // if a < b, multiply a by 100 and insert 0 before final digit of b
        if (num_gte(a, b)){
            a = subtract(a, b);
            b = add(b, "10");
        }
        else{
            a += "00";
            b = b.substr(0, b.size() - 1) + "0" + b.back();
        }
        // a becomes 0 if n is a perfect square, not considered in digital expansion
        if (a == "0"){
            return a;
        }
    }
    // return first 100 digits of b
    return b.substr(0, 100);
}

int square_root_digital_expansion(){
    int res = 0;
    for (int n = 2; n <= 100; n++){
        for (char digit : get_square_root(n)){
            res += digit - '0';
        }
    }
    return res;
}

int main(){
    std::cout << square_root_digital_expansion() << "\n";
}
