#include <iostream>

bool is_prime(int n){
    for (int i = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

int spiral_primes(){
    // 3x3: 3, 5, 7, 9
    // 5x5: 13, 17, 21, 25
    // 7x7: 31, 37, 43, 49
    // nxn: n^2 - 3n + 3, n^2 - 2n + 2, n^2 - n + 1, n^2
    
    // 2*n - 1 numbers in diagonals for square of side length n
    
    // primes / diag_nums >= 0.1
    // 10 * primes / diag_nums >= 1
    // 10 * primes >= diag_nums
    // 10 * primes >= 2*n - 1
    
    // square spiral with side length 3 has 
    // 3 primes (3, 5, 7) out of 5 numbers on diagonals (1, 3, 5, 7, 9)
    int n = 3, primes = 3;
    
    while (10 * primes >= 2 * n - 1){
        n += 2;
        for (int c = 0; c < 4; c++){
            if (is_prime(n*n - c*(n - 1))) primes++;
        }
    }
    return n;
}

int main(){
    std::cout << spiral_primes() << "\n";
}
