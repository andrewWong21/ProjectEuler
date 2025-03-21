package main
import "fmt"

func isPalindrome (n int) bool {
    num := n
    rev := 0
    for num > 0 {
        rev = rev * 10 + num % 10
        num /= 10
    }
    return n == rev
}

func main() {
    res := 0
    for a := 999; a >= 1; a-- {
        for b := a; b >= 1; b-- {
            if (a * b > res && isPalindrome(a * b)){
                res = a * b
            }
        }
    }
    fmt.Println(res)
}
