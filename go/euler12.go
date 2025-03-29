package main
import "fmt"

func countDivisors(n int) int {
    if n == 1 {
        return 1
    }
    res := 1
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            res += 2
            if i * i == n {
                res -= 1
            }
        }
    }
    return res
}

func main() {
    res := 0
    n := 1
    for res == 0 {
        t := n * (n + 1) / 2
        if countDivisors(t) >= 500 {
            res = t
        }
        n++
    }
    fmt.Println(res)
}
