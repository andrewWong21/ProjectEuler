#include <iostream>

int integer_right_triangles(){
    // a + b + c <= 1000, a^2 + b^2 = c^2
    // p = a + b + c, c = p - a - b
    // a^2 + b^2 = (p - a - b)^2
    // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
    // a^2 + b^2 = p^2 - 2ap - 2bp + 2ab + a^2 + b^2
    // 0 = p^2 - 2ap - 2bp + 2ab
    // 2bp - 2ab = b(2p - 2a) = p^2 - 2ap
    // b = (p^2 - 2ap)/(2p - 2a)
    // b is an integer, so (p^2 - 2ap) % (2p - 2a) = 0
    // p^2 - 2ap = p(p - 2a) > 0, so a < p/2
    int perim = 0, max_count = 0;
    for (int p = 1; p <= 1000; p++){
        int count = 0;
        for (int a = 1; a * 2 < p; a++){
            if ((p*p - 2*a*p) % (2*p - 2*a) == 0){
                int b = (p*p - 2*a*p) / (2*p - 2*a);
                if (a > b) continue;
                count++;
                if (max_count < count){
                    perim = p;
                    max_count = count;
                }
            }
        }
    }
    return perim;
}

int main(){
    std::cout << integer_right_triangles() << "\n";
}
