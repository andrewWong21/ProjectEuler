#include <iostream>

int prime_summations(){
    bool sieved[101] = {false};
    int sums[101] = {0};
    sums[0] = 1;
    for (int i = 2; i < 101; i++){
        if (!sieved[i]){
            // mark multiples of i as composite
            for (int j = 2 * i; j < 101; j += i){
                sieved[j] = true;
            }
            // count summations to positive integers using i as largest prime
            for (int j = i; j < 101; j++){
                sums[j] += sums[j - i];
            }
        }
    }
    for (int i = 0; i < 101; i++){
        if (sums[i] > 5000) return i;
    }
    return -1;
}

int main(){
    std::cout << prime_summations() << "\n";
}
