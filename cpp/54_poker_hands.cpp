#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstring>
#include <array>
#include <algorithm>

std::array<int, 2> evaluate(std::string hand[5]){
    int values[13] = {};
    int suits[4] = {};
    
    for (int i = 0; i < 5; i++){
        std::string card = hand[i];
        switch(card[0]){
            case 'T': values[8]++; break;
            case 'J': values[9]++; break;
            case 'Q': values[10]++; break;
            case 'K': values[11]++; break;
            case 'A': values[12]++; break;
            default: values[card[0] - '0' - 2]++;
        }
        switch(card[1]){
            case 'C': suits[0]++; break;
            case 'D': suits[1]++; break;
            case 'H': suits[2]++; break;
            case 'S': suits[3]++; break;
        }
    }
    std::string streaks = "";
    for (int i = 0; i < 13; i++){
        streaks += std::to_string(values[i]);
    }
    bool straight = (streaks.find("11111") != std::string::npos) or (streaks.find("1111") == 0 and values[12] == 1);
    bool flush = std::count(std::begin(suits), std::end(suits), 5) == 1;
    if (straight and flush){
        // royal flush
        if (values[8] and values[12]) return {9, 0};
        // five-high straight flush
        if (values[3] and values[12]) return {8, 3};
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] != 0){
                kicker = i; 
                break;
            }
        }
        return {8, kicker};
    }
    if (flush){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] != 0){
                kicker = i; 
                break;
            }
        }
        return {5, kicker};
    }
    if (straight){
        if (values[3] and values[12]) return {4, 3};
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] != 0){
                kicker = i; 
                break;
            }
        }
        return {4, kicker};
    }
    
    bool four = std::find(std::begin(values), std::end(values), 4) != std::end(values);
    if (four){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] == 4){
                kicker = i; 
                break;
            }
        }
        return {7, kicker};
    }
    
    bool three = std::count(std::begin(values), std::end(values), 3) == 1;
    bool two_pair = std::count(std::begin(values), std::end(values), 2) == 2;
    bool pair = std::count(std::begin(values), std::end(values), 2) == 1;
    
    if (three and pair){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] == 3){
                kicker = i; 
                break;
            }
        }
        return {6, kicker};
    }
    if (three){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] == 3){
                kicker = i; 
                break;
            }
        }
        return {3, kicker};
    }
    if (two_pair){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] == 2){
                kicker = i; 
                break;
            }
        }
        return {2, kicker};
    }
    if (pair){
        int kicker = 0;
        for (int i = 12; i >= 0; i--){
            if (values[i] == 2){
                kicker = i; 
                break;
            }
        }
        return {1, kicker};
    }
    int kicker = 0;
    for (int i = 12; i >= 0; i--){
        if (values[i] != 0){
            kicker = i; 
            break;
        }
    }
    return {0, kicker};
}

int poker_hands(std::vector<std::string> hands){
    int count = 0;
    for (std::string hand : hands){
        std::string h1[5] = {};
        std::string h2[5] = {};
        for (int i = 0; i < 5; i++){
            h1[i] = hand.substr(3*i, 2);
            h2[i] = hand.substr(3*i + 15, 2);
        }
        std::array<int, 2> score1 = evaluate(h1);
        std::array<int, 2> score2 = evaluate(h2);
        if (score1[0] > score2[0] || (score1[0] == score2[0] && score1[1] > score2[1])){
            count++;
        }
    }
    return count;
}

int main(){
    std::ifstream file("/uploads/54_poker.txt");
    std::string s;
    std::vector<std::string> hands;
    
    while (std::getline(file, s)){
        hands.push_back(s);
    }
    file.close();
    //std::string test[5] = {"AD", "KD", "JD", "QD", "TD"}; // royal flush (9, 0)
    //std::string test[5] = {"9D", "KD", "JD", "QD", "TD"}; // straight flush (8, 11)
    //std::string test[5] = {"AD", "AH", "AC", "AS", "5C"}; // four of a kind (7, 12)
    //std::string test[5] = {"9D", "9H", "9C", "8S", "8C"}; // full house (6, 7)
    //std::string test[5] = {"2D", "5D", "JD", "QD", "7D"}; // flush (5, 10)
    //std::string test[5] = {"AD", "KH", "JC", "QS", "TC"}; // royal straight (4, 12)
    //std::string test[5] = {"2D", "3H", "4C", "5S", "AC"}; // five-high straight (4, 3)
    //std::string test[5] = {"7D", "3H", "4C", "5S", "6C"}; // straight (4, 5)
    //std::string test[5] = {"7D", "7H", "7C", "5S", "6C"}; // three (3, 5)
    //std::string test[5] = {"7D", "7H", "6C", "5S", "6H"}; // two (2, 5)
    //std::string test[5] = {"2D", "6H", "6C", "5S", "4H"}; // pair (1, 4)
    //std::string test[5] = {"AD", "6H", "9C", "5S", "4H"}; // high (0, 12)
    //std::array<int, 2> score = evaluate(test);
    //std::cout << score[0] << " " << score[1] << "\n";
    
    //hands = std::vector<std::string>(hands.begin(), hands.begin() + 5);
    std::cout << poker_hands(hands) << "\n";
}
