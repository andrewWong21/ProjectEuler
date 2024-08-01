#include <iostream>
#include <vector>
#include <set>
#include <cmath>

long prime_power_triples(){
    std::vector<int> squares;
    std::vector<int> cubes;
    std::vector<int> fourths;
    
    // calculate bases of maximum powers that can be used in sum
    int maxSqrt = int(std::sqrt(50'000'000));
    int maxCbrt = int(std::cbrt(50'000'000));
    int maxFtrt = int(std::sqrt(std::sqrt(50'000'000)));
    
    // primes can be at most maxSqrt
    std::vector<bool> sieved(maxSqrt + 1, false);
    for (int i = 2; i < sieved.size(); i++){
        if (!sieved[i]){
            for (int j = 2 * i; j < sieved.size(); j += i){
                sieved[j] = true;
            }
            // store prime squares, cubes, and fourth powers
            squares.push_back(i * i);
            if (i <= maxCbrt){
                cubes.push_back(i * i * i);
                if (i <= maxFtrt){
                    fourths.push_back(i * i * i * i);
                }
            }
        }
    }
    // store possible sums of power triples
    std::set<int> triples;
    for (int fourth : fourths){
        for (int cube : cubes){
            for (int square : squares){
                int total = square + cube + fourth;
                if (total < 50'000'000) triples.insert(total);
                else break;
            }
        }
    }
    return triples.size();
}

int main(){
    std::cout << prime_power_triples() << "\n";
}
