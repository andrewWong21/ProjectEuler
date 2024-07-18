#include <iostream>
#include <set>

int get_chain(int n){
    int fact[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    std::set<int> seen;
    while (seen.find(n) == seen.end()){
        seen.insert(n);
        int total = 0;
        for (auto c : std::to_string(n)) total += fact[c - '0'];
        n = total;
    }
    return seen.size();
}

int digit_factorial_chains(){
    int count = 0;
    for (int i = 1; i < 1'000'000; i++){
        if (get_chain(i) == 60) count++;
    }
    return count;
}

int main(){
    std::cout << digit_factorial_chains() << "\n";
}
