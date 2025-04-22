package main
import (
    "fmt"
    "strconv"
)

func isPalindrome(s string) bool {
    for i := 0; i < len(s) / 2; i++ {
        if s[i] != s[len(s) - i - 1] {
            return false
        }
    }
    return true
}

func main() {
    res := 0
    for i := 1; i < 1000000; i++ {
        if isPalindrome(strconv.Itoa(i)) && isPalindrome(strconv.FormatInt(int64(i), 2)) {
            res += i
        }
    }
    fmt.Println(res)
}
