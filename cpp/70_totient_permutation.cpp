#include <iostream>
#include <vector>
#include <algorithm>

bool is_permutation(int i, int j){
    std::string s1 = std::to_string(i);
    std::string s2 = std::to_string(j);
    if (s1.size() != s2.size()) return false;
    std::sort(s1.begin(), s1.end());
    std::sort(s2.begin(), s2.end());
    return s1 == s2;
}

int totient_permutation(){
    std::vector<double> totients(10'000'001);
    for (int i = 2; i < totients.size(); i++) totients[i] = i;
    std::vector<bool> sieved(10'000'001, false);
    for (int i = 2; i < sieved.size(); i++){
        if (!sieved[i]){
            for (int j = 2 * i; j < sieved.size(); j += i){
                sieved[j] = true;
                // totient(n) = n * P(p - 1/p)
                // n * product of (p - 1/p) for all distinct prime factors p of n
                // n / totient(n) = 1 / P(p - 1/p)
                totients[j] *= (i - 1.0) / i;
            }
        }
    }
    int res = 0;
    double minVal = 2;
    for (int i = totients.size() - 1; i >= 2; i--){
        // if n is prime, totient(n) = n - 1, cannot be a permutation of n
        if (!sieved[i]) continue;
        double val = i / totients[i];
        if (is_permutation(i, int(totients[i])) and val < minVal){
            res = i;
            minVal = val;
        }
    }
    return res;
}

int main(){
    std::cout << totient_permutation() << "\n";
}
