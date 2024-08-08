#include <iostream>
#include <cmath>
#include <set>

int gcd(int a, int b){
    while (b != 0){
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int almost_equilateral_triangles(){
    // almost equilateral triangle has side lengths of s, s, t (t = s - 1 or s + 1)
    // perimeter of almost equilateral triangle cannot exceed 1 billion
    // 2s + t <= 1e9, t = s - 1 or s + 1
    // 3t + 1 <= 1'000'000'000, a <= 333'333'333
    long long total = 0;
    int max_perim = 1'000'000'000;
    int max_side_sqrt = int(std::sqrt(max_perim / 3));
    
    // isosceles triangle is composed of two right triangles
    // build primitive integer Pythagorean triples using Euclid's formula
    std::set<std::pair<int, int>> triangles;
    
    // right triangle composed from primitive Pythagorean triples has integer area
    // triple always has one odd and one even leg, even * odd = even
    // area of triangle is (a * b) / 2, a * b is even, so triangle has integer area
    // therefore isosceles triangle composed of two of these triangles must also have integer area
    
    for (int m = 1; m <= max_side_sqrt; m++){
        for (int n = 1; n < m; n++){
            if (gcd(m, n) == 1){
                int a = m*m - n*n;
                int b = 2*m*n;
                int c = m*m + n*n;
                
                // ensure primitive triple by dividing all sides by 2 when both m and n are odd
                if (m % 2 == 1 && n % 2 == 1){
                    a /= 2;
                    b /= 2;
                    c /= 2;
                }
                // continue if perimeter of isosceles triangle exceeds 1 billion
                if (2 * (c + a) >= max_perim || 2 * (c + b) >= max_perim) break;
                
                // create isosceles triangles c-c-(2*a) and c-c-(2*b)
                for (int x : {a, b}){
                    // check if c-c-2*x constitutes a newly found almost-equilateral triangle
                    if (std::abs(c - 2*x) == 1 && triangles.find({x, c}) == triangles.end()){
                        triangles.insert({x, c});
                        // add perimeter c + c + 2*x to total
                        total += 2 * (x + c);
                    }
                }
            }
        }
    }
    return total;
}

int main(){
    std::cout << almost_equilateral_triangles() << "\n";
}
