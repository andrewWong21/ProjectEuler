#include <iostream>
#include <set>
#include <string>

bool contains_composite(int n){
    std::string s = std::to_string(n);
    // primes containing 4, 6, 8, or 0
    // will truncate to a composite number at some point
    for (auto c : {'4', '6', '8', '0'}){
        if (s.find(c) != std::string::npos) return true;
    }
    return false;
}

int truncatable_primes(){
    std::set<int> primes;
    int trunc_primes;
    bool sieved[1'000'000];
    for (int i = 2; i < 1'000'000; i++){
        if (not sieved[i]){
            primes.insert(i);
            for (int j = 2*i; j < 1'000'000; j += i){
                sieved[j] = true;
            }
        }
    }
    int total = 0;
    for (int prime : primes){
        if (prime < 10 or contains_composite(prime)) continue;
        std::string prime_str = std::to_string(prime);
        
        // remove digits from the left and check
        // if resulting number is still prime
        bool is_left_trunc = true;
        std::string str_left = prime_str;
        while (str_left.size() > 1){
            str_left = str_left.substr(1);
            if (primes.find(stoi(str_left)) == primes.end()){
                is_left_trunc = false;
                break;
            }
        }
        if (not is_left_trunc) continue;
        
        // remove digits from the right and check
        // if resulting number is still prime
        bool is_right_trunc = true;
        std::string str_right = prime_str;
        while (str_right.size() > 1){
            str_right = str_right.substr(0, str_right.size() - 1);
            if (primes.find(std::stoi(str_right)) == primes.end()){
                is_right_trunc = false;
                break;
            }
        }
        if (not is_right_trunc) continue;
        total += prime;
        trunc_primes += 1;
        if (trunc_primes == 11) break;
    }
    return total;
}

int main(){
    std::cout << truncatable_primes() << "\n";
}
