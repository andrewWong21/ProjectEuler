package main
import "fmt"

func sieve(n int) []int {
    primes := []int{}
    sieved := make([]bool, n)
    for i := 2; i < n; i++ {
        if !sieved[i] {
            primes = append(primes, i)
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
    sums := []int{0}
    maxSum := 0
    for _, p := range primes {
        if maxSum + p < 1000000 {
            maxSum += p
            sums = append(sums, maxSum)
        }
        primesSet[p] = true
    }
    
    // use maximum window size, shrink until prime is found with current window size
    for length := len(sums); res == 0 && length > 0; length-- {
        // use latest start index to guarantee first prime sum found is largest
        // start + length < len(sums)
        // start + length <= len(sums) - 1
        // 0 <= start <= len(sums) - 1 - length
        for start := len(sums) - 1 - length; res == 0 && start >= 0; start-- {
            sumA := sums[start]
            sumB := sums[start + length]
            total := sumB - sumA
            if primesSet[total] {
                res = total
            }
        }
    }
    fmt.Println(res)
}
