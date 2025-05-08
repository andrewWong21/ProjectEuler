package main
import (
    "fmt"
    "math"
)

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

func replace(n int, primes map[int]bool) int {
    num := n
    digits := []int{}
    for num > 0 {
        digits = append(digits, num % 10)
        num /= 10
    }
    // generate mask based on occurrences of digit d
    // only create masks for 0, 1, 2 so at least 8 numbers can be made
    // and guarantee that n is smallest prime in family of digit replacements
    for d := 0; d < 3; d++ {
        mask := 0
        for i := 0; i < len(digits); i++ {
            if digits[i] == d {
                mask += int(math.Pow(float64(10), float64(i)))
            }
        }
        if mask == 0 {
            continue
        }
        size := 1
        for t := 1; t < 10 - d; t++ {
            if primes[n + mask * t] {
                size++
            }
        }
        if size == 8 {
            return n
        }
    }
    return 0
}

func main() {
    res := 0
    primes := sieve(1000000)
    primesSet := make(map[int]bool)
    for _, p := range primes {
        primesSet[p] = true
        
    }
    
    for _, p := range primes {
        res = replace(p, primesSet)
        if res != 0 {
            break
        }
    }
    
    fmt.Println(res)
}
