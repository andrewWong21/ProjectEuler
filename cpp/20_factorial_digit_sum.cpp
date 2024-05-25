#include <iostream>
#include <vector>

int factorial_digit_sum(){
    // store factorial as integer vector from least to most significant digit
    std::vector<int> product = {1};
    for (int n = 1; n <= 100; n++){
        std::vector<int> newProduct;
        int carry = 0;
        // calculate product place by place
        for (int d : product){
            int subProduct = n * d + carry;
            newProduct.push_back(subProduct % 10);
            carry = subProduct / 10;
        }
        // append carry digits to product
        // while keeping carry for next place calculation
        int carryDigits = carry;
        while (carryDigits > 0){
            newProduct.push_back(carryDigits % 10);
            carryDigits /= 10;
        }
        product = newProduct;
    }
    
    int digit_sum = 0;
    for (int d : product){
        digit_sum += d;
    }
    return digit_sum;
}

int main() {
    std::cout << factorial_digit_sum() << "\n";
}
