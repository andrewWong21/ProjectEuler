package main
import "fmt"

func sieve(n int) []int {
    sieved := make([]bool, n)
    res := []int{}
    for i := 2; i < n; i++ {
        if !sieved[i] {
            res = append(res, i)
            for j := 2 * i; j < n; j += i {
                sieved[j] = true
            }
        }
    }
    return res
}

func isPrime(n int) bool {
    if n <= 1 {
        return false
    }
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            return false
        }
    }
    return true
}

func main() {
    res := 0
    max := 1000
    maxStreak := 0
    primes := sieve(max)
    primesSet := make(map[int]bool)
    for _, p := range primes{
        primesSet[p] = true
    }
    
    for _, b := range primes {
        for a := -999; a <= 999; a++ {
            for n := 0; ; n++ {
                curr := n * n + a * n + b
                if curr <= 0 {
                    break
                }
                
                _, found := primesSet[curr]
                if found || (curr > max && isPrime(curr)) {
                    primesSet[curr] = true
                } else {
                    break
                }
                if n > maxStreak {
                    maxStreak = n
                    res = a * b
                }
            }
        }
    }
    fmt.Println(res)
}
