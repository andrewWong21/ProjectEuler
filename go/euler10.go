package main
import "fmt"

func isPrime(n int) bool {
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            return false
        }
    }
    return true
}

func main() {
    res := 5 // 2 + 3
    max := 2000000
    // all primes greater than 3 are of the form 6k +/- 1
    for k := 1; 6 * k - 1 < max; k++ {
        n1 := 6 * k - 1
        if isPrime(n1) {
            res += 6 * k - 1
        }
        
        n2 := 6 * k + 1
        if n2 >= max {
            break
        }
        if isPrime(n2) {
            res += n2
        }
    }
    
    fmt.Println(res)
}
