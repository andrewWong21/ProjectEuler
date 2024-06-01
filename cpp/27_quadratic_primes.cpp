#include <iostream>
#include <set>

bool is_prime(int n){
    for (int i = 2; i*i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

int quadratic_primes(){
    bool sieved[1000] = {};
    std::set<int> primes;
    for (int i = 2; i < 1000; i++){
        if (not sieved[i]){
            for (int j = 2*i; j < 1000; j += i){
                sieved[j] = 1;
            }
            primes.insert(i);
        }
    }
    int maxN = 0, product = 0;
    // b must be prime: if n = 0, f(n) = b
    for (int b : primes){
        // |a| < 1000
        for (int a = -999; a < 1000; a++){
            // count number of primes generated
            // by n^2 + an + b for consecutive values of n 
            int n = 0;
            while (n < b){
                int res = n*n + a*n + b;
                if ((res < 1000 and primes.find(res) == primes.end()) or not is_prime(res)) break;
                n++;
            }
            if (n > maxN){
                maxN = n;
                product = a * b;
            }
        }
    }
    return product;
}

int main() {
    std::cout << quadratic_primes() << "\n";
}
