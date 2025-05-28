package main
import "fmt"

func getTotients(n int) []int {
    res := make([]int, n + 1)
    for i := 0; i <= n; i++ {
        res[i] = i
    }
    for i := 1; i <= n; i++ {
        phi := res[i]
        for j := 2 * i; j <= n; j += i {
            res[j] -= phi
        }
    }
    return res
}

func main() {
    res, n := int64(0), 1000000
    totients := getTotients(n)
    for i := 2; i <= n; i++ {
        res += int64(totients[i])
    }
    fmt.Println(res)
}
