package main
import (
    "fmt"
    "math/big"
)

func main() {
    var base, pow = big.NewInt(2), big.NewInt(1000)
    base.Exp(base, pow, nil)
    res := 0
    for _, r := range base.String() {
        res += int(r - '0')
    }
    fmt.Println(res)
}
