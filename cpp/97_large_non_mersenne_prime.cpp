#include <iostream>
#include <algorithm>
#include <vector>

std::string add(std::string num1, std::string num2){
    std::string res;
    // using reverse iterators to add corresponding digits of numbers
    // starting from the rightmost digit of each number
    auto iter1 = num1.rbegin();
    auto iter2 = num2.rbegin();
    int carry = 0;
    while (iter1 != num1.rend() || iter2 != num2.rend() || carry){
        int total = carry;
        // add digit at current index of each number if within bounds
        if (iter1 != num1.rend()) total += *iter1++ - '0';
        if (iter2 != num2.rend()) total += *iter2++ - '0';
        res.push_back(total % 10 + '0');
        carry = total / 10;
    }
    // reverse order of digits so least significant digit is on the right
    std::reverse(res.begin(), res.end());
    return res;
}

std::string mult_mod(std::string num1, std::string num2){
    // get last 10 digits of the product of two numbers
    // digits in vector are in reverse order, least significant digit first
    std::vector<int> digits(num1.size() + num2.size(), 0);
    // perform digit multiplication for each possible
    // pair of digits from the two numbers, from right to left
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
    // remove leading zeros (trailing zeros in vector)
    while (digits[i] == 0) i--;
    // return last i or 10 digits of result, whichever is smaller
    while(res.size() < 10 && res.size() <= i){
        // push next least significant digit to result
        res.push_back(digits[res.size()] + '0');
    }
    // reverse order of digits so least significant digit is on the right
    std::reverse(res.begin(), res.end());
    return res;
}

std::string vec_exp(int base, int power){
    std::string res = "1";
    std::string curr_base = std::to_string(base);
    while (power > 0){
        if (power % 2 == 1){
            // multiply result by base if current power is odd
            res = mult_mod(res, curr_base);
        }
        // square base and halve exponent, round down if power is odd
        curr_base = mult_mod(curr_base, curr_base);
        power /= 2;
    }
    return res;
}

std::string large_non_mersenne_prime(){
    // last 10 digits of (28433 * (2 ^ 7830457) + 1)
    return add(mult_mod("28433", vec_exp(2, 7830457)), "1");
}

int main(){
    std::cout << large_non_mersenne_prime() << "\n";
}
