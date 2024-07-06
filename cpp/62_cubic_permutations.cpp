#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <cmath>

long cubic_permutations(){
    long res = 9223372036854775807; // 2^63 - 1, max value of signed long
    int numDigits = 8; // number of digits in cube
    while (res == 9223372036854775807){
        // evaluate cubes n^3 with numDigits digits
        // measure number of digits in n^3, roughly log10(n^3) = 3 * log10(n)
        // increment numDigits until a digit string with exactly 5 cubic permutations is found
        
        // key: string of digits, val: list of cubic permutations of digits
        std::map<std::string, std::vector<long>> permutations;
        for (long n = ceil(pow(10, (numDigits - 1) / 3.0)); 3 * log10(n) <= numDigits; n++){
            long c = n * n * n;
            std::string s = std::to_string(n * n * n);
            std::sort(s.begin(), s.end());
            // store cubic permutation of digits in permutations
            if (permutations.find(s) == permutations.end()){
                permutations[s] = std::vector<long>();
            }
            permutations[s].push_back(c);
        }
        for (auto kv : permutations){
            if (kv.second.size() != 5) continue;
            // digit string with exactly 5 cubic permutations
            // smallest cube is added to list of permutations first
            // multiple digit strings may have exactly 5 cubic permutations
            // update res to be the minimum of all these smallest cubes
            res = std::min(res, kv.second[0]);
        }
        numDigits++;
    }
    return res;
}

int main(){
    std::cout << cubic_permutations() << "\n";
}
