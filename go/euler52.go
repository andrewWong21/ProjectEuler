package main
import (
    "fmt"
    "strconv"
    "strings"
    "sort"
)

func sortDigits(n int) string {
    str := strconv.Itoa(n)
    digits := strings.Split(str, "")
    sort.Strings(digits)
    return strings.Join(digits, "")
}

func main() {
    res := 0
    for n := 1; res == 0; n++ {
        digits := sortDigits(n)
        permuted := true
        for k := 2; k <= 6; k++ {
            if digits != sortDigits(k * n) {
                permuted = false
                break
            }
        }
        if permuted {
            res = n
        }
    }
    
    
    fmt.Println(res)
}
