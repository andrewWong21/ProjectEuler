package main
import (
    "fmt"
    "math/big"
)

func main() {
    res := 0
    // nth power with n digits has a maximum base of 9, 10^n has (n - 1) digits
    for n := 1; n < 10; n++ {
        num := big.NewInt(1)
        base := big.NewInt(int64(n))
        power := 1
        for {
            num.Mul(num, base)
            if len(num.String()) != power {
                break
            }
            res++
            power++
        }
    }
    fmt.Println(res)
}
