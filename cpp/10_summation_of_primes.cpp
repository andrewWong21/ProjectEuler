#include <iostream>
#include <cmath>

bool is_prime(int n){
    for (int i = 2; i <= std::sqrt(n) + 1; i++){
        if (n % i == 0){
            return false;
        }
    }
    return true;
}

long prime_summation(){
    long total = 2;
    for (int i = 3; i < 2'000'000; i += 2){
        if (is_prime(i)){
            total += i;
        }
    }
    return total;
}

int main(){
    std::cout << prime_summation() << "\n";
}
