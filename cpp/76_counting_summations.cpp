#include <iostream>

int counting_summations(){
    int summations[101] = {0};
    summations[0] = 1;
    // summing with integers i [1, 99]
    for (int i = 1; i < 100; i++){
        // summing to i integers j [1, 100]
        for (int j = i; j <= 100; j++){
            // count sums to j using i as largest integer in sum
            summations[j] += summations[j - i];
        }
    }
    return summations[100];
}

int main(){
    std::cout << counting_summations() << "\n";
}
