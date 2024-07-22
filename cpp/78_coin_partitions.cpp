#include <iostream>

int coin_partitions(){
    int partitions[60001] = {0};
    // one way to partition 0 coins
    partitions[0] = 1;
    for (int i = 1; i < 60001; i++){
        for (int j = i; j < 60001; j++){
            // create new partition of j by setting aside one pile of i coins
            // add partitions[j - i] ways to partition remaining j - i coins
            partitions[j] += partitions[j - i] % 1'000'000;
            partitions[j] %= 1'000'000;
        }
        // finished counting partitions for i coins
        // after setting aside 1, 2, 3, ..., i coins
        if (partitions[i] == 0) return i;
    }
    return -1;
}

int main(){
    std::cout << coin_partitions() << "\n";
}
