#include <iostream>
#include <cmath>

int cuboid_route(){
    int count = 0;
    for (int a = 1; a <= 2000; a++){
        for (int b = 1; b <= a; b++){
            for (int c = 1; c <= b; c++){
                // given a cuboid with side lengths a >= b >= c,
                // minimum cuboid route is hypotenuse of triangle with legs a and (b + c)
                double path = std::sqrt(a * a + (b + c) * (b + c));
                // count shortest paths with integer length
                if (path == int(path)){
                    // return least value of M when solutions exceed 1 million
                    if (++count == 1'000'000) return a;
                }
            }
        }
    }
    return -1;
}

int main(){
    std::cout << cuboid_route() << "\n";
}
