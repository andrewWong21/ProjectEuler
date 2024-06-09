#include <iostream>
#include <set>
#include <string>

bool has_composite_rotation(int prime){
    std::string prime_str = std::to_string(prime);
    // all circular primes greater than 10 may only contain the digits 1, 3, 7, 9
    for (auto c : {'2', '4', '5', '6', '8', '0'}){
        // primes greater than 10 that contain even digits or 5
        // will have a composite rotation of digits
        if (prime_str.find(c) != std::string::npos){
            return true;
        }
    }
    return false;
}

int circular_primes(){
    // store primes in set for faster member search
    std::set<int> primes;
    bool sieved[1'000'000] = {};
    for (int i = 2; i < 1'000'000; i++){
        if (!sieved[i]){
            for (int j = 2*i; j < 1'000'000; j += i){
                sieved[j] = 1;
            }
            if (i < 10 or !has_composite_rotation(i)){
                primes.insert(i);
            }
        }
    }
    int count = 0;
    for (int prime : primes){
        bool is_circular_prime = true;
        std::string prime_str = std::to_string(prime);
        // check if all of prime's digit rotations are also prime
        for (int i = 0; i < prime_str.size(); i++){
            prime_str = prime_str.substr(1, prime_str.size() - 1) + prime_str.substr(0, 1);
            if (primes.find(stoi(prime_str)) == primes.end()){
                is_circular_prime = false;
                break;
            }
        }
        if (is_circular_prime){
            count += 1;
        }
    }
    return count;
}

int main(){
    std::cout << circular_primes() << "\n";
}
