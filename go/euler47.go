package main
import "fmt"

func main() {
    isPrime := func(n int) bool {
        if n == 2 {
            return true
        }
        for i := 2; i * i <= n; i++ {
            if n % i == 0 {
                return false
            }
        }
        return true
    }
    
    curr, streak, res := 2, 0, 0
    primes := []int{}
    for res == 0 {
        if isPrime(curr) {
            primes = append(primes, curr)
            streak = 0
        } else {
            n, count := curr, 0
            factors := []int{}
            for n > 1 {
                for _, p := range primes {
                    if n % p == 0 {
                        count++
                        factors = append(factors, p)
                        for n % p == 0 {
                            n /= p
                        }
                    }
                }
            }
            if count == 4 {
                streak++
                if streak == 4 {
                    res = curr - streak + 1
                }
            } else {
                streak = 0
            }
        }
        curr++
    }
    fmt.Println(res)
}
