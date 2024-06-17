#include <iostream>
#include <string>

long substring_divisibility(){
    // 0-9 pandigital number abcdefghij with the following properties:
    // bcd % 2 = 0, cde % 3 = 0, def % 5 = 0, efg % 7 = 0
    // fgh % 11 = 0, ghi % 13 = 0, hij % 17 = 0
    
    // def % 5 = 0, so f = 0, 5
    // if f = 0, 0gh % 11 = 0 requires g = h, not allowed
    // f = 5, 5gh could be 506, 517, 528, 539, 561, 572, 583, 594
    
    // ghi % 13 = 0:
    // 06i: i = 5, not allowed since f = 5
    // 17i: no solution (13 * 13 = 169, 13 * 14 = 182)
    // 61i: i = 1, repeated digit
    // 94i: i = 9, repeated digit
    // fghi could be 5286, 5390, 5728, 5832
    
    // hij % 17 = 0:
    // 32j = 0: j = 3, repeated digit
    // fghij could be 52867, 53901, 57289
    
    // efg % 7 = 0:
    // e53: i = 5, repeated digit
    // e52: i = 9 (i = 2: 252 has repeated digit)
    // e57: i = 3
    // efghij could be 952867, 357289
    
    // cde % 3 = 0:
    // (cd9)52867: cd = 03, 30 (available digits 0, 1, 3, 4)
    // (cd3)57289: cd = 06, 60 (available digits 0, 1, 4, 6)
    // cdefghij could be 03952867, 30952867, 06357289, 60357289
    
    // bcd % 2 = 0
    // abcd % 2 = 0
    // ab03952867: no solution (3 % 2 = 1)
    // ab30952867: ab = 14, 41
    // ab06357289: ab = 14, 41
    // ab60357289: ab = 14, 41
    
    // all valid pandigital numbers with specified properties
    // start with 14 or 41 and end with 30952867, 06357289, or 60357289
    
    long total = 0;
    std::string starts[] = {"14", "41"};
    std::string ends[] = {"30952867", "06357289", "60357289"};
    for (std::string start : starts){
        for (std::string end : ends){
            total += stol(start + end);
        }
    }
    return total;
}

int main(){
    std::cout << substring_divisibility() << "\n";
}
