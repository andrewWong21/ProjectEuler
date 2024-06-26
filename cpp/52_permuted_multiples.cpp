#include <iostream>
#include <algorithm>
#include <string>

int permuted_multiples(){
    // numbers containing the same digits have equal digital sums
    // so they are congruent modulo 3 and modulo 9
    
    // first number n is congruent to some number m, mod 9
    // next multiple 2n contains the same digits as n,
    // so 2n is also congruent to m, mod 9
    
    // subtraction property of modular arithmetic:
    // (A - B) mod C === (A mod C - B mod C) mod C
    // (2n - n) mod 9 === ((2n mod 9) - (n mod 9)) mod 9
    // (2n - n) mod 9 === (m - m) mod 9
    // n mod 9 === 0 mod 9
    // n is a multiple of 9
    
    int res = 0;
    for (int n = 9; res == 0; n += 9){
        // get sorted list of digits
        std::string s = std::to_string(n);
        std::sort(s.begin(), s.end());
        bool found = true;
        for (int i = 2; i < 7; i++){
            std::string t = std::to_string(i * n);
            std::sort(t.begin(), t.end());
            // multiples up to 6*n must contain the same digits as n
            if (s != t){
                found = false;
                break;
            }
        }
        if (found) res = n;
    }
    return res;
    
}

int main(){
    std::cout << permuted_multiples() << "\n";
}
