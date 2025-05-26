package main
import (
    "fmt"
    "math"
)

func getDigits(n int) []int {
    digits := make([]int, 10)
    for n > 0 {
        digits[n % 10]++
        n /= 10
    }
    return digits
}

func isPermutation(a int, b int) bool {
    digits1 := getDigits(a)
    digits2 := getDigits(b)
    for i := 0; i < 10; i++ {
        if digits1[i] != digits2[i] {
            return false
        }
    }
    return true
}

func main() {
    n := 10000000
    totients := make([]float64, n)
    for i := 0; i < n; i++ {
        totients[i] = float64(i + 1)
    }
    res, minTotient := 0, math.MaxFloat64
    sieved := make([]bool, n + 1)
    primes := []int{}
    for i := 2; i < n; i++ {
        if !sieved[i] {
            primes = append(primes, i)
            for j := 2 * i; j < n; j += i {
                sieved[j] = true
                totients[j] *= float64(float64(i) - 1) / float64(i)
            }
        }
        val := float64(i) / totients[i]
        if isPermutation(int(totients[i]), i) && val < minTotient {
            minTotient = val
            res = i
        }
    }
    fmt.Println(res)
}
