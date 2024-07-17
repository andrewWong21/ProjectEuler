#include <iostream>

int counting_fractions_in_a_range(int a, int b, int c, int d){
    // a/b and c/d are adjacent fractions in the set of reduced proper fractions with denominator <= 12000
    if (b + d > 12'000) return 0;
    // otherwise, mediant (a + c)/(b + d) exists between a/b and c/d with denominator <= 12000
    // count fractions between a/b and (a + c)/(b + d)
    // and fractions between (a + c)/(b + d) and c/d
    return 1 + counting_fractions_in_a_range(a, b, a + c, b + d) + counting_fractions_in_a_range(a + c, b + d, c, d);
}

int main(){
    std::cout << counting_fractions_in_a_range(1, 3, 1, 2) << "\n";
}
