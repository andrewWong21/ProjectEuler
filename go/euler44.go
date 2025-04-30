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

func getPentagon(n int) int {
    return (3 * n * n - n) / 2
}

func main() {
    // D = P_k - P_j, j < k
    // rewrite P_k and P_j using pentagonal formula
    // D = k * (3k - 1) / 2 - j * (3j - 1) / 2
    // D = (3k^2 - k - 3j^2 + j) / 2
    
    // j < k, so k = j + x, where x is an integer
    // D = (3(j + x)^2 - (j + x) - 3j^2 + j) / 2
    // D = (3(j^2 + 2jx + x^2) - j - x - 3j^2 + j) / 2
    // D = (3j^2 + 6jx + 3x^2 - x - 3j^2) / 2
    // D = (3x^2 + 6jx - x) / 2
    // D = (3x^2 - x) / 2 + 3jx
    // D = P_x + 3jx
    // 3jx = D - P_x
    // j = (D - P_x) / 3x
    // D is pentagonal, so D = P_n, where n > x
    
    res := 0
    // first pentagonal difference
    // P_8 - P_7 = P_4, 92 - 70 = 22
    n := 4
    for res == 0 {
        pentD := getPentagon(n)
        for x := 1; x < n; x++ {
            pentX := getPentagon(x)
            if (pentD - pentX) % (3 * x) == 0 {
                // construct pentagon j
                j := (pentD - pentX) / (3 * x)
                pentJ := getPentagon(j)
                pentK := getPentagon(j + x)
                
                // check if sum of pentagons is also pentagonal
                if isPentagonal(pentJ + pentK) {
                    res = pentD
                    break
                }
            }
        }
        n++
    }
    
    fmt.Println(res)
}