package main
import (
    "fmt"
    "math"
)

func getCycleLength(n int) int {
    s := math.Sqrt(float64(n))
    a0 := int(math.Floor(s))
    if a0*a0 == n {
        return 0
    }
    a, b, c := a0, 0, 1
    curr := 0
    seen := make(map[string]int)
    for {
        b = c * a - b
        c = (n - b * b) / c
        a = (a0 + b) / c
        key := fmt.Sprintf("%d,%d", b, c)
        if val, found := seen[key]; found {
            return curr - val
        }
        seen[key] = curr
        curr++
    }
}

func main() {
    res := 0
    for n := 2; n <= 10000; n++ {
        if getCycleLength(n) % 2 == 1 {
            res++
        }
    }
    fmt.Println(res)
}
