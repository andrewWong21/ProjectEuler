package main
import (
    "fmt"
    "math"
    "math/big"
)

func getSqrtDigits(n int, d int) *big.Int {
    // Calculating digits of square roots by integer subtraction
    // http://www.afjarvis.org.uk/maths/jarvisspec02.pdf
    a := big.NewInt(int64(5 * n))
    b := big.NewInt(5)
    five := big.NewInt(5)
    ten := big.NewInt(10)
    hundred := big.NewInt(100)
    
    for len(b.String()) < d + 2 {
        if a.Cmp(b) >= 0 {
            a = new(big.Int).Sub(a, b)
            b = new(big.Int).Add(b, ten)
        } else {
            a = new(big.Int).Mul(a, hundred)
            b = new(big.Int).Div(b, ten)
            b = new(big.Int).Mul(b, hundred)
            b = new(big.Int).Add(b, five)
        }
    }
    return new(big.Int).Div(b, hundred)
}


func main() {
    res := 0
    d := 100
    
    for n := 2; n < 100; n++ {
        s := int(math.Sqrt(float64(n)))
        if s * s == n {
            continue
        }
        digits := getSqrtDigits(n, d)
        mod := big.NewInt(0)
        for digits.Cmp(big.NewInt(0)) != 0 {
            digits.DivMod(digits, big.NewInt(10), mod)
            res += int(mod.Int64())
        }
    }
    
    fmt.Println(res)
}
