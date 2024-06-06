#include <iostream>
#include <string>
#include <set>

bool is_pandigital_product(int a, int b){
    std::string identity = std::to_string(a) + std::to_string(b) + std::to_string(a * b);
    std::set<char> seen(identity.begin(), identity.end());
    // result must be 1-9 pandigital, cannot contain 0
    return (seen.find('0') == seen.end() and seen.size() == identity.size());
}

int pandigital_product(){
    std::set<int> products;
    // 1-digit number * 4-digit number = 4-digit number
    // numbers 1000-1233, 9877-9999 contain either 0 or duplicate digits
    for (int i = 1; i <= 9; i++){
        for (int j = 1234; j <= 9876; j++){
            if (is_pandigital_product(i, j)){
                products.insert(i * j);
            }
        }
    }
    // 2-digit number * 3-digit number = 4-digit number
    // 10-11, 99, 100-122, 988-999 contain either 0 or duplicate digits
    for (int i = 12; i <= 98; i++){
        for (int j = 123; j <= 987; j++){
            if (is_pandigital_product(i, j)){
                products.insert(i * j);
            }
        }
    }
    int total = 0;
    for (int product : products){
        total += product;
    }
    return total;
}

int main(){
    std::cout << pandigital_product() << "\n";
}
