#include <iostream>
#include <vector>
#include <set>

bool is_prime(int n){
    if (n == 2) return true;
    for (int i = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

int count_distinct_prime_factors(int n, std::vector<int> primes){
    std::set<int> factors;
    // iterate over ordered primes
    for (int prime : primes){
        // add prime factors to set
        while (n % prime == 0){
            factors.insert(prime);
            n /= prime;
        }
        // all prime factors found
        if (n == 1) break;
    }
    return factors.size();
}

int distinct_primes_factors(){
    // ordered list of primes for checking prime factors
    std::vector<int> primes;
    int n = 2, streak = 0;
    while (streak < 4){
        if (!is_prime(n)){
            if (count_distinct_prime_factors(n, primes) == 4){
                streak++;
            }
            else streak = 0;
        }
        else{
            primes.push_back(n);
            streak = 0;
        }
        n++;
    }
    return n - streak;
}

int main(){
    std::cout << distinct_primes_factors() << "\n";
}
