package main
import (
    "fmt"
    "strconv"
    "strings"
)

func sieve(n int) []int {
    sieved := make([]bool, n + 1)
    primes := []int{}
    for i := 2; i < n; i++ {
        if !sieved[i] {
            for j := 2 * i; j < n; j += i {
                sieved[j] = true
            }
            primes = append(primes, i)
        }
    }
    return primes
}

func isLeftTruncatable(p int, primes map[int]bool) bool {
    str := strconv.Itoa(p)
    for len(str) > 0 {
        left, _ := strconv.Atoi(str)
        _, found := primes[left]
        if !found {
            return false
        }
        str = str[1:]
    }
    return true
}

func isRightTruncatable(p int, primes map[int]bool) bool {
    for p > 0 {
        _, found := primes[p]
        if !found {
            return false
        }
        p /= 10
    }
    return true
}

func main() {
    res, count := 0, 0
    sieved := sieve(1000000)
    primes := make(map[int]bool)
    for _, p := range sieved {
        primes[p] = true
    }
    
    nonTruncDigits := []string{"4", "6", "8", "0"}
    for _, p := range sieved {
        if p < 10 {
            continue
        }
        
        str := strconv.Itoa(p)
        hasCompTrunc := false
        for _, d := range nonTruncDigits {
            if strings.Contains(str, d) {
                hasCompTrunc = true
                break
            }
        }
        if hasCompTrunc {
            continue
        }
        
        if isLeftTruncatable(p, primes) && isRightTruncatable(p, primes) {
            res += p
            count += 1
            if count == 11 {
                break
            }
        }
    }
    fmt.Println(res)
}
