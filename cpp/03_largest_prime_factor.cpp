#include <iostream>
#include <cmath>

int largest_prime_factor(unsigned long long n){
    int factor = 0;
    int len = std::sqrt(n) + 1;
    bool sieved[len] = {};
    for (int i = 2; i <= len; i++){
        if (!sieved[i]){
            for (int j = 2 * i; j <= len; j += i){
                sieved[j] = true;
            }
            if (n % i == 0){
                factor = i;
            }
        }
    }
    return factor;
}

int main() {
    std::cout << largest_prime_factor(600'851'475'143) << "\n";
}
