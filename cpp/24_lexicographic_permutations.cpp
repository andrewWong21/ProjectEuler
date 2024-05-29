#include <iostream>
#include <string>

int factorial(int n){
    if (n == 1) return n;
    return n * factorial(n - 1);
}

std::string lexicographic_permutations(std::string digits, int n){
    // base cases - one digit left or permutation 0
    if (digits.length() == 1 or n == 0) return digits;
    // d! permutations of d digits, d groups of (d - 1)! permutations
    // each group shares a starting digit
    // permutation n belongs to group n / (d - 1)!
    int fact = factorial(digits.length() - 1);
    // first digit of permutation n is digits[n / (d - 1)!]
    // reduce problem to permutation (n % (d - 1)!) of remaining (d - 1) digits
    std::string rem_digits = digits.substr(0, digits.find(digits[n / fact])) + digits.substr(digits.find(digits[n / fact]) + 1);
    return digits[n / fact] + lexicographic_permutations(rem_digits, n % fact);
}

int main(){
    // first permutation: permutation 0
    // 1,000,000th permutation: permutation 999,999
    std::cout << lexicographic_permutations(std::string("0123456789"), 999'999) << "\n";
}
