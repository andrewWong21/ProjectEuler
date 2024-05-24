#include <iostream>
#include <vector>

bool is_leap_year(int year){
    return (year % 400 == 0) or (year % 4 == 0 && year % 100 != 0);
}

int counting_sundays(){
    std::vector<int> days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int weekday = 1; // Jan 1 1900 was a Monday
    int sundays = 0;
    for (int year = 1900; year <= 2000; year++){
        for (int m = 1; m <= 12; m++){
            if (year > 1900 && weekday == 0){
                sundays += 1;
            }
            // add number of days in current month to get
            // the weekday of the first day of the following month
            weekday += days[m - 1];
            // account for February 29 during leap years
            if (m == 2 && is_leap_year(year)){
                weekday += 1;
            }
            weekday %= 7;
        }
    }
    return sundays;
}

int main() {
    std::cout << counting_sundays() << "\n";
}
