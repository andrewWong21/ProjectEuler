package main
import (
    "fmt"
    "math/big"
)

func main() {
    mod := big.NewInt(10000000000)
    one := big.NewInt(1)
    two := big.NewInt(2)
    pow := big.NewInt(7830457)
    num := big.NewInt(28433)
    
    res := new(big.Int)
    res.Exp(two, pow, mod)
    res.Mul(res, num)
    res.Mod(res, mod)
    res.Add(res, one)
    
    fmt.Println(res)
}
