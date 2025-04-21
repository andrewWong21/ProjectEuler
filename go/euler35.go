package main
import (
    "fmt"
    "strings"
    "strconv"
)

func sieve(n int) []int {
    sieved := make([]bool, n + 1)
    primes := []int{}
    for i := 2; i < n; i++ {
        if !sieved[i] {
            for j := 2 * i; j < len(sieved); j += i {
                sieved[j] = true
            }
            primes = append(primes, i)
        }
    }
    return primes
}

func isPrime(n int) bool {
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            return false
        }
    }
    return true
}

func isCircularPrime(n int) bool {
    str := strconv.Itoa(n)
    compDigits := []string{"0", "2", "4", "5", "6", "8"}
    for _, d := range compDigits {
        if strings.Contains(str, d) {
            return false
        }
    }
    for i := 0; i < len(str); i++ {
        rotated := str[i:] + str[:i]
        num, _ := strconv.Atoi(rotated)
        if !isPrime(num) {
            return false
        }
    }
    return true
}

func main() {
    res := 0
    primes := sieve(1000000)
    for _, p := range primes {
        if p < 10 || isCircularPrime(p) {
            res++
        }
    }
    fmt.Println(res)
}
