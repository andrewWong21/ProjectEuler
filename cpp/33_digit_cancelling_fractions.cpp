#include <iostream>

int gcf(int a, int b){
    if (a % b == 0) return b;
    return gcf(b, a % b);
}

int digit_cancelling_fractions(){
    int numProduct = 1;
    int denProduct = 1;
    for (int num = 11; num < 99; num++){
        for (int den = num + 1; den <= 99; den++){
            // if numerator or denominator are multiples of 10, 
            // digit cancelling will result in division by 0
            if (num % 10 == 0 or den % 10 == 0) continue;
            if (num % 10 == den / 10){
                int newNum = num / 10;
                int newDen = den % 10;
                if (1.0 * num / den == 1.0 * newNum / newDen){
                    numProduct *= newNum;
                    denProduct *= newDen;
                }
            }
        }
    }
    // return simplified denominator of product of fractions
    return denProduct / gcf(denProduct, numProduct);
}

int main(){
    std::cout << digit_cancelling_fractions() << "\n";
}
