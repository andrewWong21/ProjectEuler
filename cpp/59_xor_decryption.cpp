#include <iostream>
#include <fstream>
#include <vector>
#include <cstring>

int xor_decryption(std::vector<int> encrypted){
    // encryption key consists of 3 lowercase characters
    // ASCII codes of lowercase letters are in the range [97, 122]
    int key[3] = {97, 97, 97};
    int total = 0;
    while (key[0] < 123){
        std::string decrypted = "";
        // key is applied cyclically throughout message
        // decrypted character is XOR of encrypted character and corresponding character in key
        for (int i = 0; i < encrypted.size(); i++){
            decrypted.push_back(char(encrypted[i] ^ key[i % 3]));
        }
        // plaintext must contain common English words
        // check for presence of "the" surrounded by spaces
        if (decrypted.find(" the ") != std::string::npos){
            // std::cout << decrypted << "\n";
            for (auto chr : decrypted) total += int(chr);
            return total;
        }
        // update ASCII codes of letters in key
        if (key[2] == 122 and key[1] == 122){
            key[0] += 1;
            key[1] = 97;
            key[2] = 97;
        }
        else if (key[2] == 122){
            key[1] += 1;
            key[2] = 97;
        }
        else key[2] += 1;
    }
    return -1;
}

int main(){
    std::ifstream file("/uploads/59_cipher.txt");
    std::string s;
    std::getline(file, s);
    file.close();
    
    // tokenize string
    std::vector<int> encrypted;
    char *pch = std::strtok(&s[0], ",");
    while (pch != NULL){
        std::string num(pch);
        encrypted.push_back(stoi(num));
        pch = std::strtok(NULL, ",");
    }
    std::cout << xor_decryption(encrypted) << "\n";
}
