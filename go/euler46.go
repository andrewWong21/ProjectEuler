package main
import "fmt"

func isPrime(n int) bool {
    if n < 2 {
        return false
    }
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
    // 33 can be written as 2 * (1)^2 + 31
    res, n := 0, 35
    for res == 0 {
        // check subsequent odd composite numbers only
        if !isPrime(n) {
            foundSum := false
            for i := 1; i * i < n; i++ {
                s := i * i
                p := n - 2 * s
                // n can be written as the sum of a prime and twice a square
                if isPrime(p) {
                    foundSum = true
                    break
                }
            }
            // if no sum was found, n is a counterexample to the conjecture
            if !foundSum {
                res = n
            }
        }
        n += 2
    }
  fmt.Println(res)
}
