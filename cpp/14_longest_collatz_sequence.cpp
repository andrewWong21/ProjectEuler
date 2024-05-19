#include <iostream>
#include <vector>
#include <unordered_set>

int longest_collatz_sequence(){
    int max_len = 0;
    int res = 0;
    // store lengths of previously seen numbers under 1 million
    std::vector<int> lengths(1'000'000, 0);
    // base case: 1 has a chain length of 1
    lengths[1] = 1;
    
    for (int i = 2; i < 1'000'000; i++){
        // terms within chain may go above one million
        long long n = i;
        std::unordered_set<long long> chain{n};
        bool cached = false;
        while (true){
            if (n < 1'000'000 && lengths[n] != 0){
                cached = true;
                break;
            }
            chain.insert(n);
            n = n % 2 ? 3*n + 1 : n / 2;
        }
        lengths[i] = chain.size();
        // if the chain length of n was already cached, 
        // add chain length of n to stored chain length for i
        if (cached){
            lengths[i] += lengths[n];
        }
        if (lengths[i] > max_len){
            max_len = lengths[i];
            res = i;
        }
    }
    return res;
}

int main() {
    std::cout << longest_collatz_sequence() << "\n";
}
