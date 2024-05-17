#include <iostream>
#include <cmath>

int count_divisors(int n){
    int divisors = 0;
    for (int i = 1; i < std::sqrt(n) + 1; i++){
        if (n % i == 0){
            divisors += 2;
        }
    }
    if (std::sqrt(n) == int(std::sqrt(n))){
        divisors -= 1;
    }
    return divisors;
}

int highly_divisible_triangular_number(int d){
    int n = 1, tri = 1, divs = 1;
    while (divs < d){
        tri = n * (n + 1) / 2;
        divs = count_divisors(tri);
        n += 1;
    }
    return tri;
}

int main() {
    std::cout << highly_divisible_triangular_number(500) << "\n";
}
