package main
import (
    "fmt"
    "math"
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

func main() {
    n := 50000000
    maxSqrt := int(math.Sqrt(float64(n)))
    maxCbrt := int(math.Cbrt(float64(n)))
    maxFtrt := int(math.Sqrt(math.Sqrt(float64(n))))
    
    squares := []int{}
    cubes := []int{}
    fourths := []int{}
    
    for _, p := range sieve(maxSqrt) {
        sq := p * p
        if p <= maxFtrt {
            fourths = append(fourths, sq * sq)
        }
        if p <= maxCbrt {
            cubes = append(cubes, p * sq)
        }
        squares = append(squares, sq)
    }
    
    triples := make(map[int]bool)
    for _, fourth := range fourths {
        for _, cube := range cubes {
            if fourth + cube >= n {
                break
            }
            for _, square := range squares {
                triple := fourth + cube + square
                if triple >= n {
                    break
                }
                triples[triple] = true
            }
        }
    }
    
    fmt.Println(len(triples))
}
