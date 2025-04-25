package main
import(
    "fmt"
    "math"
)


func main() {
    res, maxSol, max := 0, 0, 1000
    // a^2 + b^2 = c^2
    // p = a + b + c, c = p - a - b
    // a^2 + b^2 = (p - a - b)^2
    // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
    // 0 = p^2 - 2ap - 2bp + 2ab
    // 2bp - 2ab = p^2 - 2ap
    // b(2p - 2a) = p^2 - 2ap
    // b = (p^2 - 2ap) / (2p - 2a)
    
    // a, b, c, p are integers
    // (p^2 - 2ap) % (2p - 2a) = 0
    // p^2 - 2ap > 0, p > 0 so p - 2a > 0
    // 1 <= a < p / 2
    
    for p := 1; p <= max; p++ {
        solutions := 0
        for a := 1; a < p / 2; a++ {
            if  (p * p - 2 * a * p) % (2 * p - 2 * a) == 0 {
                b := (p * p - 2 * a * p) / (2 * p - 2 * a)
                // avoid double-counting triplets
                if b < a {
                    continue
                }
                c := math.Sqrt(float64(a * a + b * b))
                if c == math.Floor(c) {
                    solutions += 1
                }
            }
        }
        if solutions > maxSol {
            maxSol = solutions
            res = p
        }
    }
    fmt.Println(res)
}
