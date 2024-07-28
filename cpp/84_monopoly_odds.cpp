#include <iostream>
#include <map>
#include <vector>
#include <deque>
#include <random>
#include <chrono>
#include <algorithm>

std::string get_modal_string(std::map<int, int> visited){
    // find top three visited squares
    // visited[30] = 0, squares[30] is Go to Jail
    // curr moves to 10 (Jail) if curr becomes 30 after rolling
    std::string first = "30", second = "30", third = "30";
    
    // left-pad string conversions of keys < 10 with 0 to get string of length 2
    for (std::pair<int, int> kv : visited){
        if (kv.second > visited[stoi(first)]){ // new most visited square
            third = second;
            second = first;
            first = std::to_string(kv.first);
            if (first.size() < 2) first = "0" + first;
        }
        else if (kv.second > visited[stoi(second)]){ // new second-most visited square
            third = second;
            second = std::to_string(kv.first);
            if (second.size() < 2) second = "0" + second;
        }
        else if (kv.second > visited[stoi(third)]){ // new third-most visited square
            third = std::to_string(kv.first);
            if (third.size() < 2) third = "0" + third;
        }
    }
    // concatenate square numberings to get six-digit modal string
    return first + second + third;
}

std::string most_freq_string(std::map<std::string, int> map){
    // get modal string with highest frequency from map of (string, frequency)
    std::string res = "";
    int count = 0;
    for (std::pair<std::string, int> pair : map){
        if (pair.second > count){
            res = pair.first;
            count = pair.second;
        }
    }
    return res;
}

int next_square(int curr, std::vector<int> squares){
    // get next square to move to, given list of valid squares
    for (int sq : squares){
        if (sq > curr) return sq;
    }
    // pass GO to get to next square
    return squares[0];
}

std::string simulate(int sides, int turns){
    std::vector<std::string> squares = {
        "GO", "A1",  "CC1",  "A2", "T1",  "R1", "B1",  "CH1",
        "B2", "B3",  "JAIL", "C1", "U1",  "C2", "C3",  "R2",
        "D1", "CC2", "D2",   "D3", "FP",  "E1", "CH2", "E2", 
        "E3", "R3",  "F1",   "F2", "U2",  "F3", "G2J", "G1", 
        "G2", "CC3", "G3",   "R4", "CH3", "H1", "T2",  "H2"
    };
    
    // time-based seed for RNG
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::default_random_engine rng(seed);
    std::uniform_int_distribution<int> dist(1, sides);
    
    // declare community chest and chance cards
    // -1 indicates no position change
    // n > -1: move to specified position
    // n < -1: move to position dependent on current position
    std::vector<int> cc_cards = {0, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    std::vector<int> ch_cards = {0, 10, 11, 24, 39, 5, -5, -5, -12, -3, -1, -1, -1, -1, -1, -1};
    
    // shuffle cards randomly
    std::shuffle(cc_cards.begin(), cc_cards.end(), rng);
    std::shuffle(ch_cards.begin(), ch_cards.end(), rng);
    
    // use queues for card pile FIFO behavior
    std::deque<int> ccq(cc_cards.begin(), cc_cards.end());
    std::deque<int> chq(ch_cards.begin(), ch_cards.end());
    
    // check if current position is a Community Chest or Chance square
    std::vector<int> ccs = {2, 17, 33}, chs = {7, 22, 36};
    
    // maintain count of times each square was visited
    std::map<int, int> visited;
    
    // maintain current square and number of consecutive doubles rolled
    int curr = 0, doubles = 0;
    
    for (int i = 0; i < turns; i++){
        int roll1 = dist(rng);
        int roll2 = dist(rng);
        
        if (roll1 == roll2){
            doubles++;
            // triple consecutive doubles sends player to jail
            if (doubles == 3){
                curr = 10;
                visited[10]++;
                doubles = 0;
                continue;
            }
        }
        else doubles = 0;
        
        curr = (curr + roll1 + roll2) % squares.size();
        
        // Go to Jail square moves player to Jail square
        if (curr == 30){
            curr = 10;
        }
        else if (std::find(ccs.begin(), ccs.end(), curr) != ccs.end()){
            // landed on Community Chest square
            int card = ccq.front();
            ccq.pop_front();
            if (card != -1) curr = card;
            ccq.push_back(card);
        }
        else if (std::find(chs.begin(), chs.end(), curr) != chs.end()){
            // landed on Chance square
            int card = chq.front();
            chq.pop_front();
            if (card > -1) curr = card;
            else if (card == -3) curr = (curr - 3) % squares.size();        // move back 3 spaces
            else if (card == -5) curr = next_square(curr, {5, 15, 25, 35}); // move to next railway
            else if (card == -12) curr = next_square(curr, {12, 28});       // move to next utility
            chq.push_back(card);
        }
        visited[curr]++;
    }
    return get_modal_string(visited);
}

std::string monopoly_odds(){
    // Approach: simulate a large number of games for enough turns
    // and generate the most common modal string from this sample set of games.
    
    int tests = 10, games = 200, turns = 5000;
    std::map<std::string, int> results;
    
    for (int t = 0; t < tests; t++){
        std::map<std::string, int> modalStrings;
        
        for (int g = 0; g < games; g++){
            // obtain modal string from simulation of one game
            std::string modalStr = simulate(4, turns);
            
            // add entry for new modal string if needed
            if (modalStrings.find(modalStr) == modalStrings.end()){
                modalStrings[modalStr] = 0;
            }
            modalStrings[modalStr]++;
        }
        // add most frequent modal string from test as entry in results map
        std::string testModal = most_freq_string(modalStrings);
        if (results.find(testModal) == results.end()){
            results[testModal] = 0;
        }
        results[testModal]++;
    }
    // return most frequent modal string obtained from running multiple tests
    return most_freq_string(results);
}

int main(){
    std::cout << monopoly_odds() << "\n";
}
