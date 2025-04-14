package main
import (
    "fmt"
    "math/big"
)

func main() {
    seen := make(map[string]bool)
    for a := 2; a <= 100; a++ {
        for b := 2; b <= 100; b++ {
            base := big.NewInt(int64(a))
            exp := big.NewInt(int64(b))
            pow := new(big.Int).Exp(base, exp, nil)
            seen[pow.String()] = true
        }
    }
    fmt.Println(len(seen))
}
