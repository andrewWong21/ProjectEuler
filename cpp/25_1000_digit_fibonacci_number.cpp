#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

int fib_1000_digits(){
    // store numbers as vectors of ints
    // from least to most significant digits
    std::vector<int> num1 = {1};
    std::vector<int> num2 = {1};
    int n = 2;
    while (num2.size() < 1000){
        std::vector<int> sum;
        int carry = 0;
        for (int i = 0; i < num2.size(); i++){
            int d1 = 0, d2 = num2[i];
            if (i < num1.size()) d1 = num1[i];
            
            int intSum = d1 + d2 + carry;
            sum.push_back(intSum % 10);
            carry = intSum / 10;
            
        }
        if (carry > 0){
            sum.push_back(carry);
        }
        num1 = num2;
        num2 = sum;
        n += 1;
    }
    return n;
}

int main() {
    std::cout << fib_1000_digits() << "\n";
}
