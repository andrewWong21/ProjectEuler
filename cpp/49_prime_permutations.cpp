#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>

std::string find_sequence(std::vector<int> nums){
    for (int i = 0; i < nums.size() - 2; i++){
        for (int j = i + 1; j < nums.size() - 1; j++){
            int first = nums[i], second = nums[j], diff = second - first;
            // if second + diff exists in nums then arithmetic sequence can be created
            if (std::find(nums.begin(), nums.end(), second + diff) != nums.end()){
                // concatenate three terms of sequence
                return std::to_string(nums[i]) + std::to_string(nums[j]) + std::to_string(nums[j] + diff);
            }
        }
    }
    return "";
}

long prime_permutations(){
    // key: sorted digits of prime
    // val: list of primes using digits
    std::map<std::string, std::vector<int>> primes;
    bool sieved[10000];
    for (int i = 2; i < 10000; i++){
        if (!sieved[i]){
            for (int j = 2*i; j < 10000; j += i) sieved[j] = true;
            // store 4-digit primes in map
            if (i >= 1000){
                std::string s = std::to_string(i);
                std::sort(s.begin(), s.end());
                // find other sequence than 1487, 4817, 8147
                if (s == "1478") continue;
                if (primes.find(s) == primes.end()){
                    primes[s] = {};
                }
                primes[s].push_back(i);
            }
        }
    }
    for (auto digits : primes){
        // sequence requires at least 3 primes with the same digits
        if (digits.second.size() < 3) continue;
        std::string res = find_sequence(digits.second);
        if (res.size() > 0) return stol(res);
    }
    return 0;
}

int main(){
    std::cout << prime_permutations() << "\n";
}
