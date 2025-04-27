package main
import (
    "fmt"
    "sort"
)

func generatePerms(n int) []int {
    used := make([]bool, n)
    perms := []int{}
    perm := 0
    var backtrack func(int)
    backtrack = func(idx int) {
        if idx == n {
            perms = append(perms, perm)
            return
        }
        for i := 0; i < n; i++ {
            if !used[i] {
                used[i] = true
                perm = perm * 10 + (i + 1)
                backtrack(idx + 1)
                perm /= 10
                used[i] = false
            }
        }
    }
    backtrack(0)
    return perms
}

func isPrime(n int) bool {
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

func main() {
    // pandigital 9-digit numbers cannot be prime
    // digit sum is 45, which is a multiple of 3
    // pandigital 8-digit numbers have a digit sum of 36
    // numbers with a digit sum that is a multiple of 3 are also divisible by 3
    
    // largest pandigital prime can have at most 7 digits
    // digit sum of 1-7 pandigital number is 28
    
    res := 0
    perms := generatePerms(7)
    // convert to intSlice and sort in reverse order
    sort.Sort(sort.Reverse(sort.IntSlice(perms)))
    for _, perm := range perms {
        if isPrime(perm) {
            res = perm
            break
        }
    }
    fmt.Println(res)
}
