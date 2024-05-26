#include <iostream>
#include <cmath>

int get_divisor_sum(int n){
    int divSum = 1;
    int s = int(std::sqrt(n));
    for (int i = 2; i <= s; i++){
        if (n % i == 0){
            divSum += i + (n / i);
        }
    }
    if (s * s == n) divSum -= s;
    return divSum;
}

int amicable_numbers(){
    int amSum = 0;
    for (int n = 2; n < 10'000; n++){
        int divSum = get_divisor_sum(n);
        // count amicable numbers  once
        // a != b so either a > b or b > a
        if (divSum > n && get_divisor_sum(divSum) == n){
            amSum += n + divSum;
        }
    }
    return amSum;
}

int main() {
    std::cout << amicable_numbers() << "\n";
}
