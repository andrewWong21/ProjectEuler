#include <iostream>

bool is_prime(int n){
    for (int i = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

bool is_goldbach_sum(int n){
    // a composite number n is a Goldbach sum
    // if it can be written as n = p + 2*s*s,
    // the sum of a prime p and twice a square (s^2)
    for (int s = 1; 2 * s * s < n; s++){
        int p = n - 2 * s * s;
        if (is_prime(p)) return true;
    }
    return false;
}

int goldbachs_other_conjecture(){
    int res = 0, n = 35;
    while (res == 0){
        // check if current composite n is a Goldbach sum
        if (!is_prime(n) and !is_goldbach_sum(n)) res = n;
        n += 2;
    }
    return res;
}

int main(){
    std::cout << goldbachs_other_conjecture() << "\n";
}
