#include <iostream>

int multiples_of_3_or_5(int max_num){
    int result = 0;
    
    // get number of multiples of 3, 5, and 15 below max_num
    int mults3 = int((max_num - 1) / 3);
    int mults5 = int((max_num - 1) / 5);
    int mults15 = int((max_num - 1) / 15);
    
    // sum multiples of 3 or 5
    // subtract multiples of 15 to prevent double-counting
    result += 3 * mults3 * (mults3 + 1) / 2;
    result += 5 * mults5 * (mults5 + 1) / 2;
    result -= 15 * mults15 * (mults15 + 1) / 2;
    
    return result;
}

int main() {
    std::cout << multiples_of_3_or_5(1000) << "\n";
}