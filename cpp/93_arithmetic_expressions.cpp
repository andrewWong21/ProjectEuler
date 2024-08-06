#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <set>

int evaluate(std::vector<int> digits, std::vector<std::string> ops, std::string group){
    // stack containing intermediate results
    std::stack<double> s;
    int d = 0, opIdx = 0;
    for (char c : group){
        // apply operation to top two elements in stack
        if (c == '.'){
            double num2 = s.top();
            s.pop();
            double num1 = s.top();
            s.pop();
            // exit if division by zero
            std::string op = ops[opIdx++];
            if (op == "/" && num2 == 0){
                return 0;
            }
            // push evaluated intermediate expression to stack
            if (op == "/") s.push(num1 / num2);
            else if (op == "*") s.push(num1 * num2);
            else if (op == "+") s.push(num1 + num2);
            else s.push(num1 - num2);
        }
        else{ // push operand to stack
            s.push(double(digits[d++]));
        }
    }
    // return result if it is a positive integer
    if (s.top() > 0 && s.top() == int(s.top())) return s.top();
    // return dummy if result is not positive or not an integer
    return 0;
}

int get_streak(std::vector<int> digits){
    std::vector<std::string> ops = {"+", "-", "/", "*"};
    // five possible groupings of three binary operators
    // a b c d x y z = a z (b y (c x d))
    // a b c x d y z = a z ((b x c) x d)
    // a b c x y d z = (a x (b x c)) x d
    // a b x c d y z = (a x b) x (c x d)
    // a b x c y d z = (a x b) x c x d
    std::vector<std::string> groups = {
        "xxxx...", "xxx.x..", "xxx..x.", "xx.xx..", "xx.x.x."
    };
    std::set<int> resultSet;
    
    // calculate possible results for each permutation of digits
    // with a given list of operations and grouping of parentheses
    do{
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                for (int z = 0; z < 4; z++){
                    std::vector<std::string> operations = {ops[x], ops[y], ops[z]};
                    for (std::string group : groups){
                        int result = evaluate(digits, operations, group);
                        // insert positive integer results into result set
                        if (result) resultSet.insert(result);
                    }
                }
            }
        }
    }
    while (std::next_permutation(digits.begin(), digits.end())); // permute digits after each loop
    
    // copy result set into vector and sort vector
    std::vector<int> results(resultSet.begin(), resultSet.end());
    std::sort(results.begin(), results.end());
    
    // get length of streak of consecutive positive integers starting from 1
    for (int i = 0; i < results.size(); i++){
        if (results[i] != i + 1) return i;
    }
    return -1;
}

std::string arithmetic_expressions(){
    std::string digits = "";
    int max_streak = 0;
    // generate tuple of digits (a, b, c, d) such that a < b < c < d
    for (int a = 0; a < 10; a++){
        for (int b = a + 1; b < 10; b++){
            for (int c = b + 1; c < 10; c++){
                for (int d = c + 1; d < 10; d++){
                    int streak = get_streak({a, b, c, d});
                    if (streak > max_streak){
                        max_streak = streak;
                        digits = std::to_string(1000 * a + 100 * b + 10 * c + d);
                        // handle string edge case
                        if (a == 0){
                            digits = "0" + digits;
                        }
                    }
                }
            }
        }
    }
    return digits;
}

int main(){
    std::cout << arithmetic_expressions() << "\n";
}
