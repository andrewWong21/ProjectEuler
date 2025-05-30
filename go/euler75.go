package main
import "fmt"

func gcf(a int, b int) int {
    for b > 0 {
        a, b = b, a % b
    }
    return a
}

func main() {
    maxPerim := 1500000
    perims := make([]int, maxPerim + 1)
    for m := 1; m * m <= maxPerim; m++ {
        for n := 1; n < m; n++ {
            if gcf(m, n) == 1 {
                a := m * m - n * n
                b := 2 * m * n
                if a > b {
                    continue
                }
                c := m * m + n * n
                if m % 2 == 1 && n % 2 == 1 {
                    a /= 2
                    b /= 2
                    c /= 2
                } 
                p := a + b + c
                for k := 1; k * p <= maxPerim; k++ {
                    perims[k * p]++
                }
            }
        }
    }
    res := 0
    for _, p := range perims {
        if p == 1 {
            res++
        }
    }
    fmt.Println(res)
}
