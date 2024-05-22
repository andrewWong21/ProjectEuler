#include <iostream>
#include <string>

int number_letter_counts(){
    int total_count = 0;
    std::string ones = "onetwothreefourfivesixseveneightnine";
    total_count += 190 * ones.length();
    std::string teens = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
    total_count += 10 * teens.length();
    std::string tens = "twentythirtyfortyfiftysixtyseventyeightyninety";
    total_count += 100 * tens.length();
    total_count += 891 * std::string("and").length();
    total_count += 900 * std::string("hundred").length();
    total_count += std::string("onethousand").length();
    
    return total_count;
}

int main() {
    std::cout << number_letter_counts() << "\n";
}
