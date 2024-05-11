#include <iostream>

int sum_square_difference(int n) {
    
    // summation formula
    int sum = n * (n + 1) / 2;
    
    // calculate sum of squares
    int sum_squares = 0;
    for (int i = 1; i <= n; i++){
        sum_squares += i*i;
    }
    
    return sum*sum - sum_squares;
}

int main() {
    std::cout << sum_square_difference(100) << "\n";
}
