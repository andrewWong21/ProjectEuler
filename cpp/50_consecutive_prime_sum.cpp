#include <iostream>
#include <vector>
#include <set>

int consecutive_prime_sum(){
    std::vector<int> primes;
    std::set<int> primesSet;
    bool sieved[1'000'000];
    for (int i = 2; i < 1'000'000; i++){
        if (!sieved[i]){
            for (int j = 2*i; j < 1'000'000; j += i){
                sieved[j] = true;
            }
            primes.push_back(i);
            primesSet.insert(i);
        }
    }
    // find maximum number of primes that can sum to number below 1 million
    int sum = 0, maxTerms = 0;
    for (int prime : primes){
        if (sum + prime > 1'000'000) break;
        sum += prime;
        maxTerms++;
    }
    // sums[i] is cumulative sum of first i primes, sums[0] = 0
    int sums[maxTerms + 1] = {0};
    for (int i = 1; i <= maxTerms; i++){
        sums[i] = sums[i - 1] + primes[i - 1];
    }
    // examine consecutive sum of n primes starting from (start + 1)th prime
    for (int terms = maxTerms; terms >= 0; terms--){
        for (int start = maxTerms - terms; start >= 0; start--){
            int sumA = sums[start], sumB = sums[start + terms];
            if (primesSet.find(sumB - sumA) != primesSet.end()){
                return sumB - sumA;
            }
        }
    }
    return 0;
}

int main(){
    std::cout << consecutive_prime_sum() << "\n";
}
