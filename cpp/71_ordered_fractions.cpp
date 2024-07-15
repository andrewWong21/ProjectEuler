#include <iostream>
#include <cmath>

int ordered_fractions(int a, int b, int c, int d){
    // calculate mediant (a + c)/(b + d) of two adjacent fractions a/b and c/d
    // updating left fraction with mediant fraction
    // until next mediant has denominator exceeding 1,000,000
    
    // a/b, (a + c)/(b + d), (a + 2c)/(b + 2d), ...
    // b + n*d <= 1,000,000
    // n = floor((1,000,000 - b)/d)
    
    int n = floor((1000000 - b) / d);
    return a + n*c;
}

int main(){
    std::cout << ordered_fractions(2, 5, 3, 7) << "\n";
}
