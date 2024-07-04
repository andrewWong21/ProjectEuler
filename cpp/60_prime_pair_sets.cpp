#include <iostream>
#include <vector>
#include <cstring>
#include <set>

std::set<int> primes_set;
std::vector<int> p1, p2;

// check if two primes concatenate to produce another prime
bool is_prime_concat(int p1, int p2){
    int n = stoi(std::to_string(p1) + std::to_string(p2));
    if (n < 10'000) return primes_set.find(n) != primes_set.end();
    for (int i = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

// check if all concatenations of n and every prime in primes produce another prime number
bool all_prime_concats(std::vector<int> primes, int n){
    for (int p : primes){
        if (!is_prime_concat(p, n) or !is_prime_concat(n, p)) return false;
    }
    return true;
}

std::vector<std::vector<int>> build_quintuple(std::vector<int> primes){
    std::vector<std::vector<int>> groups;
    // create prime pair set of size 2 (a, b) where a < b
    for (int i = 0; i < primes.size(); i++){
        for (int j = i + 1; j < primes.size(); j++){
            if (is_prime_concat(primes[i], primes[j]) and is_prime_concat(primes[j], primes[i])){
                std::vector<int> pair = {primes[i], primes[j]};
                groups.push_back(pair);
            }
        }
    }
    // create prime pair sets of size n, up to 5, from known prime pair sets of size (n - 1)
    for (int i = 3; i <= 5; i++){
        std::vector<std::vector<int>> new_groups;
        for (std::vector<int> group : groups){
            for (int p : primes){
                if (p <= group[group.size() - 1]) continue;
                if (all_prime_concats(group, p)){
                    std::vector<int> new_group(group.begin(), group.end());
                    new_group.push_back(p);
                    new_groups.push_back(new_group);
                }
            }
        }
        groups = new_groups;
    }
    return groups;
}

int prime_pair_sets(){
    
    // split set of primes into two subsets
    // p1 - primes congruent to 1 mod 3
    // p2 - primes congruent to 2 mod 3
    
    // concatenating digits of a prime from p1 and a prime from p2
    // creates a number with a digit sum divisible by 3
    // which is then a multiple of 3 and therefore not prime
    
    // concatenating 3 with a prime from either set does not 
    // affect the congruency of the resulting number
    int n = 10'000;
    bool sieved[n] = {};
    for (int i = 2; i < n; i++){
        if (!sieved[i]){
            for (int j = 2*i; j < n; j += i){
                sieved[j] = true;
            }
            if (i % 3 == 1){
                p1.push_back(i);
            }
            else if (i % 3 == 2){
                p2.push_back(i);
            }
            else{
                p1.push_back(i);
                p2.push_back(i);
            }
            
        }
    }
    int min_total = 100'000;
    for (std::vector<int> group : build_quintuple(p1)){
        int group_sum = 0;
        for (int n : group){
            group_sum += n;
        }
        if (group_sum < min_total) min_total = group_sum;
    }
    // following code block does not affect answer but is included for search completion
    // no set of five primes exists such that all five primes are congruent to 2 modulo 3
    // and any two primes in this set concatenate to produce another prime
    /*
    for (std::vector<int> group : build_quintuple(p2)){
        int group_sum = 0;
        for (int n : group){
            group_sum += n;
        }
        if (group_sum < min_total) min_total = group_sum;
    }
    */
    return min_total;
}

int main(){
    std::cout << prime_pair_sets() << "\n";
}
