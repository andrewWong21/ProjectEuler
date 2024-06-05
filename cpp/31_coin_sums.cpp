#include <iostream>
#include <vector>

int coin_sums(){
    std::vector<int> sums(201);
    int coins[] = {1, 2, 5, 10, 20, 50, 100, 200};
    sums[0] = 1 // one way to sum to 0, using 0 coins
    // build sums using current greatest coin value
    for (int coin : coins){
        // update possible sums to target using current coin value
        // add ways to sum to difference of target and current coin value
        for (int i = coin; i < sums.size(); i++){
            sums[i] += sums[i - coin];
        }
    }
    return sums[200];
}

int main() {
    std::cout << coin_sums() << "\n";
}
