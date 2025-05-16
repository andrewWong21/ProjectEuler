package main
import (
    "fmt"
    "strconv"
)

func sieve(n int) []int {
    sieved := make([]bool, n + 1)
    primes := []int{}
    
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

func isPrime(n int) bool {
    if n < 2 {
        return false
    }
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            return false
        }
    }
    return true
}

func isConcatPrime(a int, b int) bool {
    aStr := strconv.Itoa(a)
    bStr := strconv.Itoa(b)
    ab, _ := strconv.Atoi(aStr + bStr)
    ba, _ := strconv.Atoi(bStr + aStr)
    return isPrime(ab) && isPrime(ba)
}

func main() {
    res := 5 * 10000 // looking for minsum
    primes := sieve(9000)
    p1 := []int{}
    p2 := []int{}
    // separate primes into two categories of congruency mod 3
    // concatenating primes from different sets result in
    // guaranteed composite, digital sum will be a multiple of 3
    for _, p := range primes {
        if p == 3 {
            // append 3 to both groups, will not affect modulo of concatenation
            p1 = append(p1, p)
            p2 = append(p2, p)
        } else if p % 3 == 1 {
            // primes congruent to 1 mod 3
            p1 = append(p1, p)
        } else if p % 3 == 2 {
            // primes congruent to 2 mod 3
            p2 = append(p2, p)
        } 
    }
    
    groups := [][]int{}
    for i := 0; i < len(p1); i++ {
        for j := i + 1; j < len(p1); j++ {
            if isConcatPrime(p1[i], p1[j]) {
                groups = append(groups, []int{p1[i], p1[j]})
            }
        }
    }
    
    for size := 3; size <= 5; size++ {
        newGroups := [][]int{}
        for _, group := range groups {
            last := group[len(group) - 1]
            for _, q := range p1 {
                if q <= last {
                    continue
                }
                canAppend := true
                for _, p := range group {
                    if !isConcatPrime(p, q) {
                        canAppend = false
                        break
                    }
                }
                if canAppend {
                    newGroup := append([]int{}, group...)
                    newGroups = append(newGroups, append(newGroup, q))
                }
            }
        }
        groups = newGroups
    }
    
    for _, g := range groups {
        sum := 0
        for _, p := range g {
            sum += p
        }
        if sum < res {
            res = sum
        }
    }
    
    fmt.Println(res)
}
