#include <iostream>
#include <map>

int get_cycle_length(int n){
    // store previously seen remainders and digit positions
    std::map<int, int> seen;
    int rem = 1, count = 0;
    while (rem != 0){
        rem = rem * 10 % n;
        if (seen.find(rem) != seen.end()) return count - seen[rem];
        seen[rem] = count++;
    }
    // reciprocal terminates, no cycle
    return 0;
}

int reciprocal_cycles(){
    int res = 0, max_len = 0;
    for (int i = 2; i < 1000; i++){
        int len = get_cycle_length(i);
        if (len > max_len){
            max_len = len;
            res = i;
        }
    }
    return res;
}

int main() {
    std::cout << reciprocal_cycles() << "\n";
}
