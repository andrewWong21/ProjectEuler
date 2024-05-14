#include <iostream>

int special_pythagorean_triplet(){
    // a^2 + b^2 = c^2, a + b + c = 1000
    // c = 1000 - a - b
    // a^2 + b^2 = (1000 - a - b)^2
    
    // let a be the shortest side
    // a is at most 332
    // minimal triplet with a = 333: 333 + 334 + 335 > 1000
    // b is at most 499
    // minimal triplet with b = 500: 1 + 500 + 501 > 1000
    for (int a = 1; a < 333; a++){
        for (int b = a + 1; b < 500; b++){
            int c = 1000 - a - b;
            if (a*a + b*b == c*c) return a*b*c;
        }
    }
    return -1;
}

int main() {
    std::cout << special_pythagorean_triplet() << "\n";
}
