#include <iostream>
#include <cmath>

int powerful_digit_counts(){
    // 10^(n - 1) <= x^n < 10^n
    // x^n < 10^n, x < 10
    // 1 <= x <= 9
    
    // 10^(n - 1) <= x^n
    // (n - 1) <= n*log10(x)
    int powers = 0;
    for (int x = 1; x < 10; x++){
        int n = 1;
        // increment n until 10^(n - 1) > x^n
        // while 10^(n - 1) <= x^n
        // while (n - 1) * log10(10) <= n * log10(x)
        // while (n - 1) * 1 <= n * log10(x)
        while (n - 1 <= n * log10(x)){
            powers++;
            n++;
        }
    }
    return powers;
}

int main(){
    std::cout << powerful_digit_counts() << "\n";
}
