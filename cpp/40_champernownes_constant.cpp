#include <iostream>
#include <cmath>
#include <string>

int champernownes_constant(){
    // groups of numbers covering first 1 million digits
    //      1-9      starts at digit 1,      digits 1-9            (9 * 1 = 9 digits)
    //     10-99     starts at digit 10,     digits 10-189         (90 * 2 = 180 digits)
    //    100-999    starts at digit 190,    digits 190-2889       (900 * 3 = 2700 digits)
    //   1000-9999   starts at digit 2890,   digits 2890-38889     (9000 * 4 = 36000 digits)
    //  10000-99999  starts at digit 38890,  digits 38890-488889   (90000 * 5 = 450000 digits)
    // 100000-999999 starts at digit 488890, digits 488890-5888889 (900000 * 6 = 540000 digits)
    int product = 1;
    int starts[] = {1, 10, 190, 2890, 38890, 488890, 5888890};
    for (int pos = 1; pos <= 1'000'000; pos *= 10){
        // get digit count of numbers in group containing pos
        int digits = 0;
        while (pos >= starts[digits]){
            digits++;
        }
        // get starting position of group containing pos
        int start_pos = starts[digits - 1];
        // get number in group containing pos 
        int k = int((pos - start_pos) / digits); 
        std::string num = std::to_string(int(std::pow(10, digits - 1) + k));
        // get position in number corresponding to pos
        int digit_pos = pos - start_pos - digits * k;
        product *= stoi(num.substr(digit_pos, 1));
    }
    return product;
}

int main(){
    std::cout << champernownes_constant() << "\n";
}
