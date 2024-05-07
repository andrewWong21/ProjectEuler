#include <iostream>

int even_fibonacci_numbers(int max_num){
    int sum_nums = 0;
    int fib[2] = {0, 1};
    
    while (fib[1] < max_num){
        int temp = fib[0];
        fib[0] = fib[1];
        fib[1] += temp;
        if (fib[1] % 2 == 0){
            sum_nums += fib[1];
        }
    }
    return sum_nums;
}

int main(){
    std::cout << even_fibonacci_numbers(4'000'000) << "\n";
}