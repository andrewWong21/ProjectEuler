#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>

int replace_digits(std::string num, std::string mask, int digit){
    std::string res = "";
    // replace digits in positions marked by *
    // keep digits in positions marked by .
    for (int i = 0; i < mask.size(); i++){
        if (mask[i] == '*'){
            res += std::to_string(digit);
        }
        else{
            res += num[i];
        }
    }
    return stoi(res);
}

int prime_digit_replacements(){
    std::vector<int> primes;
    std::set<int> primes_set;
    bool sieved[1'000'000] = {};
    for (int i = 2; i < 1'000'000; i++){
        if (!sieved[i]){
            for (int j = 2*i; j < 1'000'000; j += i){
                sieved[j] = true;
            }
            // avoid adding primes with leading zeros to family
            // by reducing set of primes to check to those with 4-6 digits only
            if (i > 1000){
                primes.push_back(i);
                primes_set.insert(i);
            }
        }
    }
    
    // number of digits being replaced must be a multiple of 3 to keep digital sum constant modulo 3
    // 4C3 = 4
    std::vector<std::string> masks4 = {"***.", "**.*", "*.**", ".***"};
    // 5C3 = 20 / 2 = 10
    std::vector<std::string> masks5 = {
        "***..", "**.*.", "**..*", "*.**.", "*.*.*",
        "*..**", ".***.", ".**.*", ".*.**", "..***"
    };
    // 6C3 = 120 / 6 = 20
    std::vector<std::string> masks6 = {
        "***...", "**.*..", "**..*.", "**...*", "*.**..",
        "*.*.*.", "*.*..*", "*..**.", "*..*.*", "*...**", 
        ".***..", ".**.*.", ".**..*", ".*.**.", ".*.*.*", 
        ".*..**", "..***.", "..**.*", "..*.**", "...***"
    };
    
    for (int prime : primes){
        std::string s = std::to_string(prime);
        std::vector<std::string> masks;
        if (s.size() == 4){
            masks = masks4;
        }
        else if (s.size() == 5){
            masks = masks5;
        }
        else{
            masks = masks6;
        }
        // solution can be improved by only testing replacements when
        // the original prime has the same digits in each position to be replaced
        for (std::string mask : masks){
            std::vector<int> family;
            for (int digit = 0; digit < 10; digit++){
                int next = replace_digits(s, mask, digit);
                if (primes_set.find(next) != primes_set.end()){
                    family.push_back(next);
                }
            }
            if (family.size() == 8){
                return family[0];
            }
        }
    }
    return 0;
}

int main(){
    std::cout << prime_digit_replacements() << "\n";
}
