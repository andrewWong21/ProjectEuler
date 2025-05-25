package main
import "fmt"

func main() {
    totients := []float64{}
    for i := 0; i < 1000000; i++ {
        totients = append(totients, float64(i + 1))
    }
    res := 0
    sieved := [1000000]bool{}
    primes := []int{}
    for i := 2; i <= 1000000; i++ {
        if !sieved[i] {
            primes = append(primes, i)
            for j := 2 * i; j <= 1000000; j += i {
                sieved[j] = true
            }
        }
    }
    fmt.Println(res)
}
