#include <iostream>
#include <vector>
#include <algorithm>

int power_digit_sum(){
    // 2^1000 = 4 ^ 500 = 16^250 = 256^125
    // store result as vector of digits from least to most significant
    std::vector<int> digits = {1};
    for (int n = 1; n <= 125; n++){
        std::vector<int> newDigits;
        int carry = 0;
        // multiply each digit by base and store intermediate results
        for (int i = 0; i < digits.size(); i++){
            int product = 256 * digits[i] + carry;
            newDigits.push_back(product % 10);
            carry = product / 10;
        }
        // handle multiple carry digits using a copy of carry
        // so further calculations are not affected
        int carryDigits = carry;
        while (carryDigits > 0){
            newDigits.push_back(carryDigits % 10);
            carryDigits /= 10;
        }
        digits = newDigits;
    }
    int digitSum;
    for (const int& digit : digits){
        digitSum += digit;
    }
    return digitSum;
}

int main() {
    std::cout << power_digit_sum() << "\n";
}
