package main
import "fmt"

func isPrime(n int) bool{
    for i := 2; i * i <= n; i++ {
        if (n % i == 0){
            return false
        }
    }
    return true
}

func main() {
    count := 2 // 2, 3, ...
    res := 0
    // all primes greater than 3 are of the form 6k +/- 1
    for k := 1; res == 0; k++ {
        if (isPrime(6 * k - 1)){
            count++
            if (count == 10001){
                res = 6 * k - 1
            }
        }
        if (isPrime(6 * k + 1)){
            count++
            if (count == 10001){
                res = 6 * k + 1
            }
        }
    }
    fmt.Println(res)
}
