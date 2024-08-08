#include <iostream>
#include <cmath>
#include <set>

int get_divisor_sum(int n){
    // function is called on n > 1
    // 1 is always a proper divisor of n > 1
    int total = 1;
    double sq = std::sqrt(n);
    for (int i = 2; i <= sq; i++){
        if (n % i == 0) total += i + n / i;
    }
    // avoid double-counting sqrt(n) when n is square
    if (sq == int(sq)) total -= int(sq);
    return total;
}

int get_min(std::set<int> nums){
    // get minimum value in chain
    // numbers in chain may not exceed 1 million
    int res = 1'000'000;
    for (int num : nums){
        if (res < num) res = num;
    }
    return res;
}

int amicable_chains(){
    // keep track of longest chain and smallest number in longest chain
    int smallest = 0, longest = 0;
    // 12496 forms a chain of five numbers
    for (int i = 12496; i <= 1'000'000; i++){
        int n = i;
        std::set<int> seen;
        bool exceeded = false;
        while (seen.find(n) == seen.end()){
            // invalidate chain if number in chain exceeds 1 million
            if (n > 1'000'000){
                exceeded = true;
                break;
            }
            seen.insert(n);
            n = get_divisor_sum(n);
        }
        // chain is amicable if it returns to its starting point
        if (!exceeded && n == i && seen.size() > longest){
            longest = seen.size();
            smallest = get_min(seen);
        }
    }
    return smallest;
}

int main(){
    std::cout << amicable_chains() << "\n";
}
