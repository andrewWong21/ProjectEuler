package main
import (
    "fmt"
    "strings"
    "strconv"
)

func isPandigital(s string) bool {
    if len(s) != 9 || strings.Contains(s, "0") {
        return false
    }
    digits := make(map[rune]bool)
    for _, ch := range s {
        if digits[ch] {
            return false
        }
        digits[ch] = true
    }
    
    return len(digits) == 9
}

func main() {
    products := make(map[int]bool)
    // 2-digit * 3-digit = 4-digit
    for i := 12; i <= 98; i++ {
        for j := 123; j <= 987; j++ {
            if i * j < 10000 {
                product := i * j
                digits := strconv.Itoa(i) + strconv.Itoa(j) + strconv.Itoa(product)
                if isPandigital(digits){
                    products[product] = true
                }
            }
        }
    }
    
    // 1-digit * 4-digit = 4-digit
    for i := 1; i < 10; i++ {
        for j := 1234; j <= 9876; j++ {
            if i * j < 10000 {
                product := i * j
                digits := strconv.Itoa(i) + strconv.Itoa(j) + strconv.Itoa(product)
                if isPandigital(digits){
                    products[product] = true
                }
            }
        }
    }
    
    res := 0
    for prod := range products {
        res += prod
    }
    fmt.Println(res)
}
