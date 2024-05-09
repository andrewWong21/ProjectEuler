#include <iostream>
#include <algorithm>

bool is_palindrome(int n) {
    std::string n_str = std::to_string(n);
    std::reverse(n_str.begin(), n_str.end());
    return std::to_string(n) == n_str;
}

int largest_palindrome_product() {
    int max_product = 0;
    for (int i = 999; i >= 100; i--){
        for (int j = 999; j >= 100; j--){
            if (is_palindrome(i*j) && i*j > max_product){
                max_product = i*j;
            }
        }
    }
    return max_product;
}

int main() {
    std::cout << largest_palindrome_product() << "\n";
}
