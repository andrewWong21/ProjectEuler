#include <iostream>

long long arranged_probability(){
    // let B = # of blue discs, T = # of total discs
    // B, T are positive integers
   
    // P(BB) = B / T * (B - 1) / (T - 1) = 1/2
    // 2(B^2 - B) = T^2 - T
    // 2B^2 - 2B - T^2 + T = 0
   
    // a = 2, b = -2, c = - T^2 + T
    // B = (2 +/- sqrt(4 + 8T^2 - 8T)) / 4
    // B = (2 +/- 2 * sqrt(2T^2 - 2T + 1)) / 4
    // B = (1 +/- sqrt(2T^2 - 2T + 1)) / 2
    // 2T^2 - 2T + 1 is always at least 1
    // discard solutions with subtracted square root due to initial constraints
    // B = (1 + sqrt(2T^2 - 2T + 1)) / 2
   
    // sqrt(2T^2 - 2T + 1) must be an odd positive integer x
    // x^2 = 2T^2 - 2T + 1
    // 2T^2 - 2T + 1 - x^2 = 0
   
    // a = 2, b = -2, c = 1 - x^2
    // T = (2 +/- sqrt(4 - 8 + 8x^2)) / 4
    // T = (2 +/- 2 * sqrt(2x^2 - 1)) / 4
    // T = (1 +/- sqrt(2x^2 - 1)) / 2
    // discard solutions with subtracted square root due to initial constraints
    // T = (1 + sqrt(2x^2 - 1)) / 2
   
    // sqrt(2x^2 - 1) must be an odd positive integer y
    // y^2 = 2x^2 - 1, y^2 - 2x^2 = -1
    // fundamental solution  (x, y) = (1, 1)
    // subsequent solutions (5, 7) and (29, 41)
   
    // recurrence relation for integer solutions
    // x_(n + 1) = 3 * x_n + 2 * y_n
    // y_(n + 1) = 4 * x_n + 3 * y_n
   
    // T = (1 + sqrt(2x^2 - 1)) / 2
    // T = (1 + y) / 2, y = 2*T - 1
    // iteratively generate solutions until y exceeds 2e12 - 1
   
    // B = (1 + sqrt(2T^2 - 2T + 1)) / 2
    // B = (1 + x) / 2
    // return (x + 1) / 2 (number of blue discs)
    // when y exceeds 2e12 - 1 (number of total discs exceeds 1 trillion)
   
    long long x = 1, y = 1;
    int count = 0;
    while (y < 2e12 + 1){
        long long x_n = 3 * x + 2 * y;
        long long y_n = 4 * x + 3 * y;
        x = x_n, y = y_n;
    }
    return (x + 1) / 2;
}

int main(){
    std::cout << arranged_probability() << "\n";
}
