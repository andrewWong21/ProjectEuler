package main
import (
    "fmt"
    "time"
)

func main() {
    date := time.Date(1901, 1, 1, 0, 0, 0, 0, time.UTC) 
    res := 0
    // check all months in years from 1901 to 2000, inclusive
    for date.Year() < 2001 {
        // increment count if first day of month was a Sunday
        if int(date.Weekday()) == 0 {
            res++
        }
        // add one month to date
        date = date.AddDate(0, 1, 0)
    }
    fmt.Println(res)
}
