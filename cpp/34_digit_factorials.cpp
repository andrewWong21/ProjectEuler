#include <iostream>
#include <vector>

int digit_factorials(){
    std::vector<int> factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    // when 9! * d < 10^(d - 1), d-digit number n will always be 
    // greater than the sum of the factorials of its digits
    // 362880 * d < 10^(d - 1) when d > 7, so n can have at most 7 digits
    int total = 0;
    for (int i = 3; i < 7 * 362880; i++){
        int factSum = 0, n = i;
        while (n > 0){
            factSum += factorials[n % 10];
            n /= 10;
        }
        if (factSum == i) total += i;
    }
    return total;
}

int main() {
    std::cout << digit_factorials() << "\n";
}
