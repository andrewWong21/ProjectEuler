#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>

unsigned long long largest_product_in_series(){
    std::string digits = 
    "73167176531330624919225119674426574742355349194934"
    "96983520312774506326239578318016984801869478851843"
    "85861560789112949495459501737958331952853208805511"
    "12540698747158523863050715693290963295227443043557"
    "66896648950445244523161731856403098711121722383113"
    "62229893423380308135336276614282806444486645238749"
    "30358907296290491560440772390713810515859307960866"
    "70172427121883998797908792274921901699720888093776"
    "65727333001053367881220235421809751254540594752243"
    "52584907711670556013604839586446706324415722155397"
    "53697817977846174064955149290862569321978468622482"
    "83972241375657056057490261407972968652414535100474"
    "82166370484403199890008895243450658541227588666881"
    "16427171479924442928230863465674813919123162824586"
    "17866458359124566529476545682848912883142607690042"
    "24219022671055626321111109370544217506941658960408"
    "07198403850962455444362981230987879927244284909188"
    "84580156166097919133875499200524063689912560717606"
    "05886116467109405077541002256983155200055935729725"
    "71636269561882670428252483600823257530420752963450";
    
    // Approach: split string into tokens with delimiter "0"
    // for each token, if its length is at least 13,
    // calculate digit products from each valid starting index
    // and update max_product when applicable
    
    // https://cplusplus.com/reference/cstring/strtok/
    std::vector<std::string> tokens;
    int pos = 0;
    char* pch = std::strtok(&digits[0], "0");
    while (pch != NULL){
        tokens.push_back(pch);
        pch = std::strtok(NULL, "0");
    }
    
    unsigned long long max_product = 0;
    for (std::string token : tokens){
        if (token.length() >= 13){
            for (int i = 0; i + 12 < token.length(); i++){
                unsigned long long product = 1;
                for (int j = i; j <= i + 12; j++){
                    product *= (token[j] - '0');
                }
                max_product = std::max(max_product, product);
            }
        }
    }
    
    return max_product;
}

int main() {
    std::cout << largest_product_in_series() << "\n";
}
