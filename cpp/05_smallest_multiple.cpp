#include <iostream>

int gcd(int a, int b){
    if (a % b == 0) return b;
    return gcd(b, a % b);
}

int lcm(int a, int b){
    // prevent integer overflow by performing division first
    return a / gcd(a, b) * b;
}

int smallest_multiple(int n){
    int mult = 2520;
    for (int i = 11; i <= n; i++){
        mult = lcm(mult, i);
    }
    return mult;
}

int main() {
    std::cout << smallest_multiple(20) << "\n";
}
