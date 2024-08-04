#include <iostream>
#include <vector>
#include <set>

bool displays_all(std::vector<int> comb1, std::vector<int> comb2){
    std::vector<std::pair<int, int>> squares = {
        {0, 1}, {0, 4}, {0, 9}, {1, 6}, 
        {2, 5}, {3, 6}, {4, 9}, {8, 1}
    };
    std::set<int> s1(comb1.begin(), comb1.end());
    std::set<int> s2(comb2.begin(), comb2.end());
    // allow presence of 6 or 9 to represent both values
    if (s1.count(6) || s1.count(9)){
        s1.insert(6);
        s1.insert(9);
    }
    if (s2.count(6) || s2.count(9)){
        s2.insert(6);
        s2.insert(9);
    }
    for (std::pair square : squares){
        // if first in s1 and second in s2
        // or second in s1 and first in s2
        // then square can be displayed
        if (
            (s1.count(square.first) && s2.count(square.second)) ||
            (s2.count(square.first) && s1.count(square.second))
        ) continue;
        return false;
    }
    return true;
}

int cube_digit_pairs(){
    std::vector<int> nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = nums.size(), k = 6;
    // combinations are in increasing order
    std::vector<int> comb(nums.begin(), nums.begin() + k);
    
    std::vector<std::vector<int>> combs;
    while (true){
        combs.push_back(std::vector<int>(comb.begin(), comb.end()));
        int i;
        // find rightmost index i such that comb[i] can be incremented
        for (i = k - 1; i >= 0 && comb[i] == n - k + i; i--){}
        if (i < 0) break; // last combination found
        
        comb[i]++; // set first different digit of next combination
        // update elements at indices i+1 until end to be next largest digit
        for (int j = i + 1; j < k; j++){
            comb[j] = comb[j - 1] + 1;
        }
    }
    int count = 0;
    // assign combinations to two cubes
    // check if all square numbers can be displayed using them
    for (int i = 0; i + 1 < combs.size(); i++){
        for (int j = i + 1; j < combs.size(); j++){
            if (displays_all(combs[i], combs[j])) count++;
        }
    }
    return count;
}

int main(){
    std::cout << cube_digit_pairs() << "\n";
}
