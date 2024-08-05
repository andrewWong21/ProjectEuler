#include <iostream>
#include <vector>

int square_digit_chains(){
    std::vector<int> squares = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    int count = 0;
    for (int i = 1; i < 10'000'000; i++){
        int n = i;
        while (true){
            if (n == 1 || n == 89) break;
            int total = 0;
            for (auto c : std::to_string(n)){
                total += squares[c - '0'];
            }
            n = total;
        }
        if (n == 89){
            count++;
        }
    }
    return count;
}

int main(){
    std::cout << square_digit_chains() << "\n";
}
