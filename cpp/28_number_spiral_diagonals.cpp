#include <iostream>

int number_spiral_diagonals(){
    int total = 1;
    // n:            3,  5,  7,  9, ...
    // n^2:          9, 25, 49, 81, ...
    // n^2 -  n + 1: 7, 21, 43, 73, ...
    // n^2 - 2n + 2: 5, 17, 37, 65, ...
    // n^2 - 3n + 3: 3, 13, 31, 57, ...
    // total of corners for each n: 4n^2 - 6n + 6
    for (int n = 3; n <= 1001; n += 2){
        total += 4*n*n - 6*n + 6;
    }
    return total;
}

int main() {
    std::cout << number_spiral_diagonals() << "\n";
}
