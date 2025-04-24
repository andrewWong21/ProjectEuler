package main
import (
    "fmt"
    "strconv"
)

func isPandigital(s string) bool {
    if len(s) != 9 {
        return false
    }
    seen := [10]bool{}
    for _, c := range s {
        d, _ := strconv.Atoi(string(c))
        if d == 0 || seen[d] {
            return false
        }
        seen[d] = true
    }
    return true
}

func main() {
    res := 0
    for i := 1; i < 10000; i++ {
        str := ""
        for j := 1; len(str) < 9; j++ {
            str += strconv.Itoa(i * j)
        }
        if isPandigital(str) {
            num, _ := strconv.Atoi(str)
            res = max(res, num)
        }
    }
    fmt.Println(res)
}
