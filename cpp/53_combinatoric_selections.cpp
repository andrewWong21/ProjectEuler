#include <iostream>

int combinatoric_selections(){
    int count = 0;
    for (int n = 23; n <= 100; n++){
        int ncr = n;
        for (int r = 2; r <= n; r++){
            // nC1 = n
            // nC2 = n * (n - 1) / 2
            // nC3 = n * (n - 1) * (n - 2) / (2  * 3)
            // nCr = nC(r - 1) * (n - r + 1) / r
            ncr = ncr * (n - r + 1) / r;
            
            // nCr = nC(n - r) e.g. 23C10 = 23C13 > 1000000
            // r, (r + 1), (r + 2), ..., (n - r)
            // total of n - r - r + 1 = n - 2r + 1 values of r where nCr exceeds 100
            if (ncr > 1'000'000){
                count += n - 2*r + 1;
                break;
            }
        }
    }
    return count;
}

int main(){
    std::cout << combinatoric_selections() << "\n";
}
