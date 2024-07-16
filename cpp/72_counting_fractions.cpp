#include <iostream>
#include <vector>

long counting_fractions(){
    // reduced proper fractions n/d such that gcf(n, d) = 1
    // d = 2: n = 1
    // d = 3: n = 1, 2
    // d = 4: n = 1, 3
    // d = 5: n = 1, 2, 3, 4
    // d = 6: n = 1, 5
    // d = 7: n = 1, 2, 3, 4, 5, 6
    // d = 8: n = 1, 3, 5, 7
    
    // sum totient(d) for d <= 1,000,000
    long res = 0;
    std::vector<int> totients(1'000'001);
    for (int i = 1; i < totients.size(); i++){
        // totient(n) = n - sum of totient(d) for all of n's positive divisors
        // totient(8) = 8 - (totient(1) + totient(2) + totient(4)) = 8 - (1 + 1 + 2) = 8 - 4 = 4
        totients[i] += i;
        for (int j = 2 * i; j < totients.size(); j += i){
            totients[j] -= totients[i];
        }
        if (i >= 2) res += totients[i];
    }
    return res;
}

int main(){
    std::cout << counting_fractions() << "\n";
}
