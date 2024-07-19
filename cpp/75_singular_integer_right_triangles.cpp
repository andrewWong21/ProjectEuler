#include <iostream>
#include <vector>

int gcd(int a, int b){
    if (a % b == 0) return b;
    return gcd(b, a % b);
}

int singular_integer_right_triangles(){
    // Euclid's formula for generating Pythagorean triples
    // given two integers m > n > 0
    // a = m^2 - n^2, b = 2*m*n, c = m^2 + n^2 satisfies a^2 + b^2 = c^2
    // if gcf(m, n) == 1 and exactly one of m, n are odd
    // then (a, b, c) constitutes a primitive Pythagorean triple
    std::vector<int> triangles(1'500'001, 0);
    
    // generate triples with perimeters up to and including 1,500,000
    for (int m = 1; m*m <= 1'500'000; m++){
        for (int n = 1; n < m; n++){
            if (gcd(m, n) == 1){
                int a = m*m - n*n;
                int b = 2 * m * n;
                int c = m*m + n*n;
                
                // avoid double-counting triples by defining a valid triple (a, b, c) as having a < b < c
                if (a > b) continue;
                
                int p = a + b + c;
                // if m and n are odd, primitive triple is (a/2, b/2, c/2) with perimeter p/2
                if (m % 2 == 1 and n % 2 == 1) p /= 2;
                
                for (int k = 1; k*p <= 1'500'000; k++){
                    triangles[k*p]++;
                }
            }
        }
    }
    int count = 0;
    for (int perimeter : triangles){
        if (perimeter == 1) count++;
    }
    return count;
}

int main(){
    std::cout << singular_integer_right_triangles() << "\n";
}
