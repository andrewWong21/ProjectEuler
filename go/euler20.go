package main
import (
    "fmt"
    "math/big"
)

func main() {
    res := 0
    num := big.NewInt(1)
    for i := int64(2); i <= 100; i++ {
        num.Mul(num, big.NewInt(i))
    }
    for _, r := range num.String() {
        res += int(r - '0')
    }
    fmt.Println(res)
}
