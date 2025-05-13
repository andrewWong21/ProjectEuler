package main
import (
    "fmt"
    "math/big"
)

func main() {
    res := 0
    num := big.NewInt(3)
    den := big.NewInt(2)
    two := big.NewInt(2)
    for i := 1; i <= 1000; i++ {
        newNum := new(big.Int).Mul(den, two)
        newNum.Add(newNum, num)
        newDen := new(big.Int).Add(num, den)
        
        if len(newNum.String()) > len(newDen.String()) {
            res++
        }
        num = newNum
        den = newDen
    }
    fmt.Println(res)
}
