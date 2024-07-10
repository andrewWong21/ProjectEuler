#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstring>

std::string add(std::string num1, std::string num2){
    std::vector<int> digits(std::max(num1.size(), num2.size()), 0);
    std::reverse(num1.begin(), num1.end());
    std::reverse(num2.begin(), num2.end());
    int carry = 0;
    for (int i = 0; i < digits.size(); i++){
        int digit = carry;
        if (i < num1.size()) digit += num1[i] - '0';
        if (i < num2.size()) digit += num2[i] - '0';
        digits[i] = digit % 10;
        carry = digit / 10;
    }
    if (carry > 0) digits.push_back(carry);
    std::string res = "";
    int i = digits.size() - 1;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

std::string multiply(std::string num1, std::string num2){
    std::vector<int> digits(num1.size() + num2.size(), 0);
    std::reverse(num1.begin(), num1.end());
    std::reverse(num2.begin(), num2.end());
    int idx1 = 0;
    for (int i = 0; i < num1.size(); i++){
        int carry = 0;
        int idx2 = 0;
        int d1 = num1[i] - '0';
        for (int j = 0; j < num2.size(); j++){
            int d2 = num2[j] - '0';
            int digit = d1 * d2 + digits[idx1 + idx2] + carry;
            digits[idx1 + idx2] = digit % 10;
            carry = digit / 10;
            idx2++;
        }
        if (carry > 0) digits[idx1 + idx2] += carry;
        idx1++;
    }
    std::string res = "";
    int i = digits.size() - 1;
    while (digits[i] == 0) i--;
    while (i >= 0) res += std::to_string(digits[i--]);
    return res;
}

std::vector<int> get_convergent_cycle(int d){
    int a0 = int(sqrt(d));
    int a = a0;
    int b = a;
    int c = 1;
    
    // c_(n+1) = (n - b_n^2) / c_n
    // a_(n+1) = floor(sqrt(n) + c_(n + 1)) / c_(n + 1)
    // b_(n+1) = a_(n + 1) * c_(n + 1) - b_n
    
    std::vector<int> res;
    while (true){
        c = (d - b*b) / c;
        a = (int) floor((sqrt(d) + b)/c);
        b = a*c - b;
        res.push_back(a);
        if (a == 2*a0) break;
    }
    return res;
}

std::string get_min_solution(int d){
    // use cycle of convergents to calculate fundamental solution for Pell's equation
    std::vector<int> cycle = get_convergent_cycle(d);
    
    std::string n_prev = "1";
    std::string d_prev = "0";
    std::string n_curr = std::to_string(int(floor(sqrt(d))));
    std::string d_curr = "1";
    
    // x_(k+1) = a_k * x_k + x_(k-1)
    // y_(k+1) = a_k * y_k + y_(k-1)
    
    int count = 0;
    while (true){
        std::string k = std::to_string(cycle[count % cycle.size()]);
        std::string num = add(n_prev, multiply(n_curr, k));
        std::string den = add(d_prev, multiply(d_curr, k));
        n_prev = n_curr;
        d_prev = d_curr;
        n_curr = num;
        d_curr = den;
        
        // n^2 - D*d^2 = 1
        // D * d^2 + 1 = n^2
        if (add(multiply(std::to_string(d), multiply(den, den)), "1") == multiply(num, num)){
            return num;
        }
        count++;
    }
}

// compare strings numerically
bool num_greater(std::string num1, std::string num2){
    // larger number has more digits
    if (num1.size() > num2.size()) return true;
    // same number of digits, larger number is lexicographically greater
    if (num1.size() == num2.size() and num1 > num2) return true;
    // num1 has fewer digits or is lexicographically smaller with the same number of digits
    return false;
}

int diophantine_equation(){
    std::string max_x = "0";
    int max_d = 0;
    for (int d = 2; d <= 1'000; d++){
        // no solutions in positive integers for square D
        if (sqrt(d) == int(sqrt(d))) continue;
        std::string min_solution = get_min_solution(d);
        // check if numeric representation of min_solution
        // is greater than that of max_x
        if (num_greater(min_solution, max_x)){
            max_x = min_solution;
            max_d = d;
        }
    }
    return max_d;
}

int main(){
    std::cout << diophantine_equation() << "\n";
}
