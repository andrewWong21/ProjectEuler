package main
import (
    "fmt"
    "math"
)

func gcd(a int, b int) int {
    for b > 0 {
        a, b = b, a % b
    }
    return a
}

func main() {
    almostEq := make(map[int]bool)
    res, max := 0, 1000000000
    
    for m := 2; m * m <= max / 3; m++ {
        for n := 1; n < m; n++ {
            if gcd(m, n) == 1 {
                a := m * m - n * n
                b := 2 * m * n
                c := m * m + n * n
                if m % 2 == 1 && n % 2 == 1 {
                    a /= 2
                    b /= 2
                    c /= 2
                }
                if math.Abs(float64(c - 2 * a)) == 1 && 2 * a + c < max {
                    almostEq[2 * (a + c)] = true
                }
                if math.Abs(float64(c - 2 * b)) == 1 && 2 * b + c < max {
                    almostEq[2 * (b + c)] = true
                }
            }
        }
    }
    
    for perim := range almostEq {
        res += perim
    }
  fmt.Println(res)
}
