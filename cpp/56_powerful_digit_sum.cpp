#include <iostream>
#include <vector>
#include <algorithm>

int digit_sum(std::string num){
    int total = 0;
    for (int i = 0; i < num.size(); i++) total += num[i] - '0';
    return total;
}

std::string multiply(std::string num1, std::string num2){
    // initialize vector<int> with enough capacity to hold product of num1 and num2
    // vector contains digits of result in reverse order
    // least significant digit is at position 0
    std::vector<int> digits(num1.size() + num2.size(), 0);
    int idx1 = 0;
    // start from least significant digits of factors and multiply digit by digit
    for (int i = num1.size() - 1; i >= 0; i--){
        int carry = 0;
        int idx2 = 0;
        int d1 = num1[i] - '0';
        for (int j = num2.size() - 1; j >= 0; j--){
            int d2 = num2[j] - '0';
            // add product and carry to current value at position idx1 + idx2
            int digit = d1 * d2 + digits[idx1 + idx2] + carry;
            // handle carry if resulting value is 10 or more
            digits[idx1 + idx2] = digit % 10;
            carry = digit / 10;
            idx2++;
        }
        // add nonzero carry to next place
        if (carry > 0) digits[idx1 + idx2] += carry;
        idx1++;
    }
    std::string res = "";
    // move pointer past leading zeros until most significant digit is reached
    int i = digits.size() - 1;
    while (digits[i] == 0) i--;
    // append digits to result from most to least significant
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

int powerful_digit_sum(){
    int max_digit_sum = 0;
    for (int a = 2; a < 100; a++){
        std::string a_str = std::to_string(a);
        std::string power = "1";
        for (int b = 1; b < 100; b++){
            power = multiply(power, a_str);
            max_digit_sum = std::max(max_digit_sum, digit_sum(power));
        }
    }
    return max_digit_sum;
}

int main(){
    std::cout << powerful_digit_sum() << "\n";
}
