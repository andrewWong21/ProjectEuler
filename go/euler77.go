package main
import "fmt"

func sieve(n int) []int {
    primes := []int{}
    sieved := make([]bool, n + 1)
    for i := 2; i <= n; i++ {
        if !sieved[i] {
            primes = append(primes, i)
            for j := 2 * i; j <= n; j += i {
                sieved[j] = true
            }
        }
    }
    return primes
}

func main() {
    primes := sieve(100)
    sums := [101]int{}
    sums[0] = 1
    for _, i := range primes {
        for j := i; j < len(sums); j++ {
            sums[j] += sums[j - i]
        }
    }
    for i := 0; i < len(sums); i++ {
        if sums[i] > 5000 {
            fmt.Println(i)
            break
        }
    }
}
