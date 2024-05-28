#include <iostream>
#include <set>

bool is_abundant(int n){
    int total = 1;
    for (int i = 2; i*i <= n; i++){
        if (n % i == 0) total += i + (n / i);
        if (i * i == n) total -= i;
    }
    return total > n;
}

int non_abundant_sums(){
    std::set<int> nums;
    int total = 0;
    for (int i = 1; i <= 28123; i++){
        if (is_abundant(i)) nums.insert(i);
        bool isSum = false;
        for (int num : nums){
            if (nums.find(i - num) != nums.end()){
                isSum = true;
                break;
            }
        }
        if (not isSum) total += i;
    }
    return total;
}

int main(){
    std::cout << non_abundant_sums() << "\n";
}
