#include <iostream>
#include <cmath>
#include <vector>

int digit_fifth_powers(){
    std::vector<int> powers = {0};
    for (int i = 1; i < 10; i++){
        powers.push_back(pow(i, 5));
    }
    // 9^5 = 59049, maximum fifth-power digit sum of d-digit number is 59049*d
    // d-digit number is too big to be written as a digit fifth power sum when
    // maximum fifth power digit sum d*9^5 < minimum d-digit number 10^(d-1)
    // 59049*d < 10^(d-1) when d > 6, so numbers that can be written as a
    // sum of fifth powers of their digits can have at most 6 digits
    int total = 0;
    for (int i = 2; i < 1'000'000; i++){
        int n = i, sum = 0;
        while (n > 0){
            sum += powers[n % 10];
            n /= 10;
        }
        if (sum == i) total += i;
    }
    return total;
}

int main() {
    std::cout << digit_fifth_powers() << "\n";
}
