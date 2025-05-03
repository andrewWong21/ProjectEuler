package main
import (
    "fmt"
    "math/big"
)

func main() {
    res := new(big.Int)
    mod := big.NewInt(int64(10000000000))
    for n := 1; n <= 1000; n++ {
        base := big.NewInt(int64(n))
        selfPow := base.Exp(base, base, mod)
        res.Add(res, selfPow)
        res.Mod(res, mod)
    }
    fmt.Println(res)
}
