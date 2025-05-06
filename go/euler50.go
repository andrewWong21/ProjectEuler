package main
import "fmt"

func sieve(n int) []int {
    primes := []int{}
    primeSum := 0
    sieved := make([]bool, n)
    for i := 2; i < n; i++ {
        if !sieved[i] {
            primes = append(primes, i)
            primeSum += i
            for j := 2 * i; j < n; j += i {
                sieved[j] = true
            }
        }
    }
    return primes
}

func main() {
    res := 0
    primes := sieve(1000000)
    primesSet := make(map[int]bool)
    for _, p := range primes {
        primesSet[p] = true
    }
    sums := make([]int, len(primes) + 1)
    for i := 1; i <= len(primes); i++ {
        sums[i] = sums[i - 1] + primes[i - 1]
    }
    
    for length := len(sums); res == 0 && length > 0; length-- {
        for start := len(sums) - length - 1; res == 0 && start >= 0; start-- {
            sumA := sums[start]
            sumB := sums[start + length]
            total := sumB - sumA
            _, found := primesSet[total]
            if found {
                res = total
            }
        }
    }
    fmt.Println(res)
}
