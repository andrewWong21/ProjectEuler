package main
import "fmt"

func main() {
    totients := []float64{}
    for i := 0; i <= 1000000; i++ {
        totients = append(totients, float64(i + 1))
    }
    res, maxTotient := 0, float64(0)
    sieved := [1000001]bool{}
    primes := []int{}
    for i := 2; i <= 1000000; i++ {
        if !sieved[i] {
            primes = append(primes, i)
            for j := 2 * i; j <= 1000000; j += i {
                sieved[j] = true
                totients[j] *= float64(float64(i) - 1) / float64(i)
            }
        }
        val := float64(i) / totients[i]
        if val > maxTotient {
            maxTotient = val
            res = i
        }
    }
    fmt.Println(res)
}
