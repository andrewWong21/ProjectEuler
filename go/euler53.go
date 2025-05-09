package main
import "fmt"

func main() {
    res := 0
    // nCr first exceeds 1 million when n = 23
    for n := 23; n <= 100; n++ {
        ncr := 1
        // nC1 = n
        // nC2 = n * (n - 1) / 2
        // nC3 = n * (n - 1) * (n - 2) / (2 * 3)
        // nCr = nC(r - 1) * (n - r + 1) / r
        for r := 1; r <= n; r++ {
            ncr = ncr * (n - r + 1) / r
            // first r in row n that makes nCr exceed 1 million
            // combinatorics are symmetric, nCr = nC(n - r)
            if ncr > 1000000 {
                // size of range [r, n - r]: n - r - r + 1 = n - 2r + 1
                res += n - 2 * r + 1
                break
            }
        }
    }
    fmt.Println(res)
}
