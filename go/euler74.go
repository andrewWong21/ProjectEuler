package main
import "fmt"

func getDigitFactorialSum(n int) int {
    facts := []int{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}
    sum := 0
    for n > 0 {
        sum += facts[n % 10]
        n /= 10
    }
    return sum
}

func main() {
    res := 0
    for i := 1; i < 1000000; i++ {
        seen := make(map[int]bool)
        n := i
        for {
            if seen[n] {
                break
            }
            seen[n] = true
            n = getDigitFactorialSum(n)
        }
        if len(seen) == 60 {
           res++
        }
    }
    fmt.Println(res)
}
