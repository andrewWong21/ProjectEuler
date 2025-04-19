package main
import (
    "fmt"
    "math"
)

func main() {
    res := 0
    fact := []int{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}
    max := 1
    for {
        if int(math.Pow(10, float64(max))) > fact[9] * max {
            break
        }
        max++
    }
    for i := 3; i < max * fact[9]; i++{
        n, sum := i, 0
        for n > 0 {
            sum += fact[n % 10]
            n /= 10
        }
        if sum == i {
            res += i
        }
    }
    fmt.Println(res)
}
