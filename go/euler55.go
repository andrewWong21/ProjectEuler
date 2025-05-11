package main
import "fmt"

func reverse(n int) int {
    rev := 0
    for n > 0 {
        rev = rev * 10 + n % 10
        n /= 10
    }
    return rev
}

func isPalindrome(n int) bool {
    return n == reverse(n)
}

func isLychrel(n int) bool {
    for i := 1; i <= 50; i++ {
        n += reverse(n)
        if isPalindrome(n) {
            return false
        }
    }
    return true
}

func main() {
    res := 0
    for n := 1; n < 10000; n++ {
        if isLychrel(n) {
            res++
        }
    }
    fmt.Println(res)
}
