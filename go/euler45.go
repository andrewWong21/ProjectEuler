package main
import (
    "fmt"
    "math"
)

func isPentagonal(n int) bool {
    // p = n * (3n - 1) / 2
    // 2p = 3n^2 - n
    // 3n^2 - n - 2p = 0
    // n = (1 +/- sqrt(1 - 4 * 3 * -2p)) / 6
    // discard negative solution
    // n = (1 + sqrt(24p + 1)) / 6
    x := (1 + math.Sqrt(float64(24 * n + 1))) / 6
    return x == math.Floor(x)
}

func getHexagon(n int) int {
    return 2 * n * n - n
}

func main() {
    // all hexagonal numbers are also triangular
    // H_n = n(2n - 1) = 2n^2 - n, T_n = n * (n + 1) / 2
    // 2n^2 - n = (4n^2 - 2n) / 2 = 2n * (2n - 1) / 2
    // T_(2n - 1) = (2n - 1) * (2n) / 2 = (2n - 1) * n = 2n^2 - n
    // H_n = T_(2n - 1)
    
    // iterate over hexagonal numbers and check if they are also pentagonal
    // H_143 is pentagonal and triangular, start checking from H_144
    res, n := 0, 144
    for res == 0 {
        hex := getHexagon(n)
        if isPentagonal(hex) {
            res = hex
        }
        n++
    }
    fmt.Println(res)
}
