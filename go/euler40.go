package main
import (
    "fmt"
    "math"
    "strconv"
)

func main() {
    res, pos := 1, 1
    // 1-digit: 1-9 (9 digits, start index 1)
    // 2-digit: 10-99 (180 digits, start index 10)
    // 3-digit: 100-999 (2700 digits, start index 190)
    // 4-digit: 1000-9999 (3600 digits, start index 2890)
    // 5-digit: 10000-99999 (45000 digits, start index 38890)
    // 6-digit: 100000-999999 (540000 digits, start index 488890)
    groups := []int{0, 1, 10, 190, 2890, 38890, 488890, 5888890}
    for pos <= 1000000 {
        // pos is in group of d-digit numbers
        d := len(groups) - 1
        for pos < groups[d] {
            d--
        }
        // k values after first number in group with d digits
        k := (pos - groups[d]) / d
        n := int(math.Pow(10, float64(d - 1))) + k
        // get corresponding digit of n
        str := strconv.Itoa(n)
        digitPos := (pos - groups[d]) % d
        digit, _ := strconv.Atoi(string(str[digitPos]))
        res *= digit
        pos *= 10
    }
    fmt.Println(res)
}
