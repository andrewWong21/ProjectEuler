#include <iostream>
#include <set>
#include <cmath>

int right_triangles_with_integer_coordinates(){
    std::set<std::pair<std::pair<int, int>, std::pair<int, int>>> triangles;
    for (int px = 0; px <= 50; px++){
        for (int py = 0; py <= 50; py++){
            // point P may lie on axes, but cannot be at origin
            if (px == 0 && py == 0) continue;
            
            for (int qx = 0; qx <= 50; qx++){
                for (int qy = 0; qy <= 50; qy++){
                    // point Q may lie on axes, but cannot be at origin
                    if (qx == 0 && qy == 0) continue;
                    // P and Q must be distinct points
                    if (px == qx && py == qy) continue;
                    // count triangles only once
                    if (triangles.count({{qx, qy}, {px, py}})) continue;
                    
                    // calculate squares of side lengths
                    int a = px * px + py * py;
                    int b = qx * qx + qy * qy;
                    int c = std::pow(qx - px, 2) + std::pow(qy - py, 2);
                    // check if any permutation of squared lengths satisfies Pythagorean theorem
                    if (a + b == c || a + c == b || b + c == a){
                        triangles.insert({{px, py}, {qx, qy}});
                    }
                }
            }
        }
    }
    return triangles.size();
}

int main(){
    std::cout<< right_triangles_with_integer_coordinates() << "\n";
}
