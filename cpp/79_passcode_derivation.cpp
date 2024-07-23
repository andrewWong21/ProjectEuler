#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <set>
#include <algorithm>

std::string passcode_derivation(std::vector<std::string> codes){
    // key: digit, val: set of subsequent digits
    std::map<char, std::set<char>> graph;
    for (std::string code : codes){
        for (int i = 0; i < 3; i++){
            // create entry in graph for digit if does not exist
            if (graph.find(code[i]) == graph.end()){
                graph[code[i]] = std::set<char>();
            }
            // populate subsequent digit sets
            for (int j = i + 1; j < 3; j++){
                graph[code[i]].insert(code[j]);
            }
        }
    }
    // store (out-degree, digit) pairs
    std::vector<std::pair<int, char>> pairs;
    for (std::pair kv: graph){
        // size of subsequent digit set is out-degree of digit
        pairs.push_back( {kv.second.size(), kv.first} );
    }
    // sort digits by out-degree, descending
    std::sort(pairs.begin(), pairs.end(), std::greater<>());
    std::string res = "";
    for (std::pair kv : pairs) res += kv.second;
    return res;
}

int main(){
    std::ifstream file("/uploads/79_keylog.txt");
    std::string s;
    std::vector<std::string> codes;
    
    while (std::getline(file, s)){
        codes.push_back(s);
    }
    file.close();
    std::cout << passcode_derivation(codes) << "\n";
}
