#include <iostream>
#include <cmath>

int get_pentagon(int n){
    return (3 * n * n - n) / 2;   
}

bool is_pentagonal(int p){
    // p = (3n^2 - n)/2
    // 2p = 3n^2 - n
    // 3n^2 - n - 2p = 0
    // n = (sqrt(1 - 4 * 3 * -2p) + 1) / 6
    // n = (sqrt(1 + 24p) + 1) / 6
    double n = (std::sqrt(24*p + 1) + 1) / 6;
    return n == int(n);
}

int pentagonal_numbers(){
    // let P_j and P_k be pentagonal numbers 
    // where k > j, k = j + x
    // D = P_k - P_j = (3k^2 -+ k) / 2 - (3j^2 - j) / 2
    // D = (3(j + x)^2 - j - x - 3j^2 + j) / 2
    // D = (3j^2 + 6jx + 3x^2 - j - x - 3j^2 + j) / 2
    // D = (6jx + 3x^2 - x) / 2 = 3jx + (3x^2 - x) / 2
    // D = 3jx + P_x, j = (D - P_x) / (3x)
    
    // P_4 + P_7 = P_8 (22 + 70 = 92)
    int diff = 0, n = 4;
    while (diff == 0){
        int pent_d = get_pentagon(n);
        // P_x must be strictly less than P_d for j to be positive
        for (int x = 1; x < n; x++){
            int pent_x = get_pentagon(x);
            // generate P_j and P_k such that their difference is P_d
            if ((pent_d - pent_x) % (3 * x) == 0){
                int j = (pent_d - pent_x) / (3 * x);
                int pent_j = get_pentagon(j), pent_k = get_pentagon(j + x);
                // check if sum of P_j and P_k is pentagonal
                if (is_pentagonal(pent_j + pent_k)){
                    diff = pent_d;
                    break;
                }
            }
        }
        n += 1;
    }
    return diff;
}

int main(){
    std::cout << pentagonal_numbers() << "\n";
}
