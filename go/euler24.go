package main
import (
    "fmt"
    "strconv"
)

func fact(n int) int {
    if n == 0 || n == 1 {
        return 1
    }
    return n * fact(n - 1)
}

func getNthPermutation(digits []int, n int) string {
    if len(digits) == 0 {
        return ""
    }
    f := fact(len(digits) - 1)
    digit := digits[n / f]
    spliced := append(digits[:(n / f)], digits[(n / f + 1):]...)
    return strconv.Itoa(digit) + getNthPermutation(spliced, n % f)
}

func main() {
    digits := []int{0,1,2,3,4,5,6,7,8,9}
    perm := getNthPermutation(digits, 999999)
    fmt.Println(perm)
}
