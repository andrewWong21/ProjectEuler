#include <iostream>
#include <algorithm>
#include <string>
#include <set>

bool is_prime(int n){
    for (int i = 2; i * i < n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

int pandigital_prime(){
    // 9-digit pandigital numbers have a digital sum of 9 * (9 + 1) / 2 = 45
    // which is divisible by 3, therefore all 9-digit pandigital numbers are always composite
    // 8-digit pandigital numbers have a digital sum of 8 * (8 + 1) / 2 = 36
    // so all 8-digit pandigital numbers are also composite
    // 7-digit pandigital numbers have a digital sum of 7 * (7 + 1) / 2 = 28
    // so they are not divisible by 3, some may be prime
    // largest n-digit pandigital prime can have at most 7 digits
    
    // start from lexicographically last permutation of digits 1-7
    // and check previous permutations until prime is found
    std::string digits = "7654321";
    while (true){
        std::prev_permutation(digits.begin(), digits.end());
        if (is_prime(stoi(digits))) return stoi(digits);
    }
}

int main(){
    std::cout << pandigital_prime() << "\n";
}
