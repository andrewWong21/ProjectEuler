package main
import "fmt"

func getProperDivisorSum(n int) int {
    res := 1
    for i := 2; i * i < n; i++ {
        if n % i == 0 {
            res += i
            if i != n / i {
                res += n / i
            }
        }
    }
    return res
}

func main() {
    lim := 1000000
    res, maxLen := 0, 0
    for n := 220; n < lim; n++ {
        seen := make(map[int]bool)
        seen[n] = true
        curr := getProperDivisorSum(n)
        for curr != n {
            // element in chain exceeds limit, chain not applicable
            if curr > lim {
                break
            }
            if _, found := seen[curr]; found {
                break
            }
            seen[curr] = true
            curr = getProperDivisorSum(curr)
        }
        // new longest chain found that returns to starting point n
        if curr == n && len(seen) > maxLen {
            maxLen = len(seen)
            // start with n and update if values smaller than n are found
            res = n
            for num := range seen {
                if num < res {
                    res = num
                }
            }
        }
    }
    fmt.Println(res)
}
