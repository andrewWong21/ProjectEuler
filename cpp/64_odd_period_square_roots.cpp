#include <iostream>
#include <cmath>
#include <set>
#include <tuple>

int get_root_period(int n){
    // sqrt(n) = a0 + sqrt(n) - a0
    // sqrt(n) = a0 + (sqrt(n) - a0)/1
    // sqrt(n) = a0 + (sqrt(n) - b0)/c0
    // a0 = floor(sqrt(n)), b0 = a0, c0 = 1
    
    // (sqrt(n) - b0)/c0 = 1/( c0 / (sqrt(n) - b0) )
    // = 1/( (c0 * (sqrt(n) + b0)) / (n - b0 * b0) )
    // = 1/( (sqrt(n) + b0) / ((n - b0 * b0) / c0) )
    // = 1/( a1 + (sqrt(n) - b1) / c1 )
    // c1 = (n - b0 * b0) / c0, a1 = floor((sqrt(n) + b0) / c1), b1 = a1*c1 - b0
    
    int a = floor(sqrt(n));
    if (a * a == n) return 0;
    std::set<std::tuple<int, int>> bc;
    int b = a, c = 1;
    while (true){
        c = int((n - b*b) / c);
        a = int(floor((sqrt(n) + b) / c));
        b = a*c - b;
        if (bc.find({b, c}) != bc.end()) break;
        bc.insert({b, c});
    }
    return bc.size();
}

int odd_period_square_roots(){
    int count = 0;
    for (int n = 2; n <= 10'000; n++){
        if (get_root_period(n) % 2 == 1) count++;
    }
    return count;
}

int main(){
    std::cout << odd_period_square_roots() << "\n";
}
