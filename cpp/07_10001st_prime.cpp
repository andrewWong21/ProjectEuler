#include <iostream>
#include <cmath>

bool is_prime(int n){
    for (int i = 2; i <= int(std::sqrt(n)) + 1; i++){
        if (n % i == 0) return false;
    }
    return true;
}

int get_10001st_prime(){
    int numPrimes = 1;
    int currPrime = 2;
    for (int i = 3; numPrimes < 10001; i += 2){
        if (is_prime(i)){
            numPrimes++;
            currPrime = i;
        }
    }
    return currPrime;
}

int main() {
    std::cout << get_10001st_prime() << "\n";
}
