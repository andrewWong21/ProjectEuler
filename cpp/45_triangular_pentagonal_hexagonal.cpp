#include <iostream>
#include <cmath>

bool is_pentagonal(long p){
    // p = n(3n - 1) / 2
    // 2p = 3n^2 - n
    // 3n^2 - n - 2p = 0
    // n = (1 + sqrt(1 - 4 * 3 * -2p)) / 6
    // n = (sqrt(24p + 1) + 1) / 6
    double n = (std::sqrt(24*p + 1) + 1) / 6;
    return n == int(n);
}

int triangular_pentagonal_hexagonal(){
    // triangular numbers: n(n+1)/2  = (n^2 + n)/2
    // pentagonal numbers: n(3n-1)/2 = (3n^2 - n)/2
    // hexagonal numbers:  n(2n-1)   = (2n^2 - n)
    
    // all hexagonal numbers are triangular numbers
    // H_n        = 2n^2 - n =  (4n^2 - 2n) / 2 = (2n - 1) * (2n) / 2
    // T_(2n - 1) = (2n - 1) * (2n - 1 + 1) / 2 = (2n - 1) * (2n) / 2
    
    // iterate over hexagonal numbers and check if they are pentagonal
    // T_285 = P_165 = H_143 = 40755
    int n = 143, tph = 40755;
    while (tph == 40755){
        n++;
        int h = n * (2*n - 1);
        if (is_pentagonal(h)) tph = h;
    }
    return tph;
}

int main(){
    std::cout << triangular_pentagonal_hexagonal() << "\n";
}
