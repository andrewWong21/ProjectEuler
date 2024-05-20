#include <iostream>

long lattice_paths(int n){
    // number of routes = (2*n)! / (n! * n!)
    // = ((n + 1) * (n + 2) * (n + 3) * ... * (2*n)) / n!
    // = (n + 1) * (n + 2)/2 * (n + 3)/3 * ... * (2n)/n
    long num = 1;
    for (int i = n + 1; i <= 2*n; i++){
        // avoid overflow and floating point errors
        // by alternating multiplication and division
        num *= i;
        num /= (i - n);
    }
    return num;
}

int main() {
    std::cout << lattice_paths(20) << "\n";
}
