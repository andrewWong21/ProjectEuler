#include <iostream>
#include <vector>
#include <set>
#include <deque>
#include <cmath>
#include <numeric>

int product_sum_numbers(int maxK){
    // minimal product-sum number for a set of size k is at most 2*k
    std::vector<int> min_prod_sums(maxK + 1, 0);
    // store possible factorizations for product-sum number N
    // each factorization is stored as a deque due to prepending of factors
    // and requirement for non-contiguous memory as containers are updated
    
    // note: this approach uses an extreme amount of memory
    // better alternative would be a dynamic programming approach
    std::vector<std::set<std::deque<int>>> factorizationsList(2 * maxK + 1);
    
    // iterate over possible product-sum numbers N in range [2, 2*k]
    for (int n = 2; n < factorizationsList.size(); n++){
        // build list of factorizations for n
        std::set<std::deque<int>> factorizations;
        // starting with single-number factorization
        factorizations.insert({n});
        
        // build factorization using factors f
        // if f is a factor of n, then n is a multiple of f
        for (int f = 2; f <= std::sqrt(n); f++){
            if (n % f == 0){
                for (const std::deque<int>& fact : factorizationsList[n / f]){
                    bool prependable = true;
                    for (int num : fact){
                        if (num < f){
                            // f cannot be prepended as smallest factor in factorization of n
                            prependable = false;
                            break;
                        }
                    }
                    if (prependable){ 
                        // f is new smallest factor in factorization of n
                        // create copy of factorization of n
                        std::deque<int> new_fact(fact.begin(), fact.end());
                        // prepend f as smallest factor
                        new_fact.insert(new_fact.begin(), f);
                        factorizations.insert(new_fact);
                    }
                }
            }
        }
        factorizationsList[n] = factorizations;
    }
    // iterate over factorizations for each possible value of n
    for (int n = 2; n < factorizationsList.size(); n++){
        for (const std::deque<int>& fact : factorizationsList[n]){
            // only consider factorizations with at least two numbers
            if (fact.size() < 2) continue;
            int factSum = std::reduce(fact.begin(), fact.end());
            if (factSum <= n){
                // number of terms in product-sum set:
                // number of factors in factorization, plus difference of n and its factor sum
                // difference is number of ones added to sum
                int k = fact.size() + n - factSum;
                // first value of n found for a set of k numbers is guaranteed to be minimal
                if (k <= maxK && min_prod_sums[k] == 0){
                    min_prod_sums[k] = n;
                }
            }
        }
    }
    // get sum of unique minimum product-sum numbers
    std::set<int> sums(min_prod_sums.begin(), min_prod_sums.end());
    return std::accumulate(sums.begin(), sums.end(), 0);
}

int main(){
    std::cout << product_sum_numbers(12'000) << "\n";
}
