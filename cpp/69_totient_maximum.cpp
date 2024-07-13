#include <iostream>
#include <vector>

int totient_maximum(){
    std::vector<double> totients(1'000'001, 0);
    for (int i = 0; i < totients.size(); i++) totients[i] = i;
    std::vector<bool> sieved(1'000'001, false);
    for (int i = 2; i < sieved.size(); i++){
        if (!sieved[i]){
            // totient(n) = n - 1 if n is prime
            totients[i]--;
            for (int j = 2 * i; j < sieved.size(); j += i){
                sieved[j] = true;
                // totient(n) = n * P(p - 1/p)
                // n * product of (p - 1/p) for all distinct prime factors p of n
                
                // find prime factors p of n
                // multiply current stored totient value of n by (p - 1) / p
                totients[j] *= (i - 1.0) / i;
            }
        }
    }
    int res = 0;
    double maxVal = 0;
    for (int i = 2; i < totients.size(); i++){
        double val = i / totients[i];
        if (val > maxVal){
            res = i;
            maxVal = val;
        }
    }
    return res;
}

int main(){
    std::cout << totient_maximum() << "\n";
}
