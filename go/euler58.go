package main
import "fmt"

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

func main() {
    res := 0
    // square spiral with side length 7
    // has 13 numbers along both diagonals, 8 are prime
    primes, count:= 8, 13
    // adding another layer increases side length by 2
    // and adds 4 numbers to diagonals, corners of square
    for n := 9; res == 0; n += 2 {
        // check primality of corner numbers
        // n^2, n^2 - n + 1, n^2 - 2n + 2, n^2 - 3n + 3
        for k := 0; k < 4; k++ {
            corner := n * n - k * (n - 1)
            if isPrime(corner) {
                primes++
            }
            count++
        }
        // return 
        if primes * 10 < count {
            res = n
        }
    }
    fmt.Println(res)
}
