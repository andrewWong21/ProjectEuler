#include <iostream>
#include <cmath>
#include <vector>
#include <set>
#include <algorithm>

std::set<int> triangles, squares, pentagons, hexagons, heptagons, octagons;

bool is_triangle(int p){
    // p = n(n + 1) / 2
    // n^2 + n - 2p = 0
    // n = (-1 + sqrt(1 + 8p))/2
    double n = (std::sqrt(8*p + 1) - 1) / 2;
    return n == int(n);
}

bool is_square(int p){
    double n = std::sqrt(p);
    return n == int(n);
}

bool is_pentagon(int p){
    // p = n(3n - 1) / 2
    // 3n^2 - n - 2p = 0
    // n = (1 + sqrt(1 + 24p)) / 6
    double n = (std::sqrt(24*p + 1) + 1) / 6;
    return n == int(n);
}

bool is_hexagon(int p){
    // p = n(2n - 1)
    // 2n^2 - n - p = 0
    // n = (1 + sqrt(1 + 8p)) / 4
    double n = (std::sqrt(8*p + 1) + 1) / 4;
    return n == int(n);
}

bool is_heptagon(int p){
    // p = n(5n - 3) / 2
    // 5n^2 - 3n - 2p = 0
    // n = (3 + sqrt(9 + 40p)) / 10
    double n = (std::sqrt(40*p + 9) + 3) / 10;
    return n == int(n);
}

bool is_octagon(int p){
    // p = n(3n - 2)
    // 3n^2 - 2n - p = 0
    // n = (2 + sqrt(4 + 12p)) / 6
    // n = (2 + 2sqrt(1 + 3p)) / 6
    // n = (1 + sqrt(1 + 3p)) / 3
    double n = (std::sqrt(3*p + 1) + 1) / 3;
    return n == int(n);
}

std::vector<int> find_cycle(std::vector<int> cycle, std::vector<std::set<int>> usedSets){
    std::set<std::set<int>> polygonSets = {heptagons, hexagons, pentagons, squares, triangles};
    // after using a set of polygons in a cycle,
    // it cannot be used for another number in the cycle
    for (std::set<int> polygonSet : usedSets){
        polygonSets.erase(polygonSet);
    }
    for (std::set<int> polygonSet : polygonSets){
        for (int polygon : polygonSet){
            // figurate number p already exists in cycle
            if (std::find(cycle.begin(), cycle.end(), polygon) != cycle.end()) continue;
            // try extending cycle with p if last 2 digits of p are the same as
            // the first 2 digits of the current last figurate number in the cycle
            if (cycle[cycle.size() - 1] % 100 == polygon / 100){
                std::vector<int> new_cycle(cycle.begin(), cycle.end());
                new_cycle.push_back(polygon);
                // end search when cycle contains 6 numbers
                // the last 2 digits of the sixth figurate number are the same as
                // the first 2 digits of the octagonal number that started the cycle
                if (new_cycle.size() == 6 and polygon % 100 == cycle[0] / 100){
                    return new_cycle;
                }
                std::vector<std::set<int>> new_usedSets(usedSets.begin(), usedSets.end());
                new_usedSets.push_back(polygonSet);
                // update used sets and continue building cycle from p
                new_cycle = find_cycle(new_cycle, new_usedSets);
                if (new_cycle.size() == 6) return new_cycle;
            }
        }
    }
    return std::vector<int>();
}

int cyclical_figurate_numbers(){
    
    for (int i = 1'000; i < 10'000; i++){
        if (is_triangle(i)) triangles.insert(i);
        if (is_square(i)) squares.insert(i);
        if (is_pentagon(i)) pentagons.insert(i);
        if (is_hexagon(i)) hexagons.insert(i);
        if (is_heptagon(i)) heptagons.insert(i);
        if (is_octagon(i)) octagons.insert(i);
    }
    std::vector<int> cycle = {};
    for (int octagon : octagons){
        std::vector<int> fig_nums = {octagon};
        cycle = find_cycle(fig_nums, std::vector<std::set<int>>());
        if (cycle.size() == 6) break;
    }
    int total = 0;
    for (int fig_num : cycle){
        total += fig_num;
    }
    return total;
}

int main(){
    std::cout << cyclical_figurate_numbers() << "\n";
}
