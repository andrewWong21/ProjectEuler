#include <iostream>

long self_powers(){
    long MOD = (long) 1e10, lastDigits = 0;
    
    for (int i = 1; i <= 1000; i++){
        // use properties of modular arithmetic
        // (a * b) mod m === ((a mod m) * (b mod m)) mod m
        // (a + b) mod m === ((a mod m) + (b mod m)) mod m
        long power = 1;
        for (int j = 1; j <= i; j++){
            // i <= 1000, so i mod 1e10 = i
            power = ((power % MOD) * i) % MOD;
        }
        // power is already modulo 1e10 after loop
        lastDigits = ((lastDigits % MOD) + power) % MOD;
    }
    return lastDigits;
}

int main(){
    std::cout << self_powers() << "\n";
}
