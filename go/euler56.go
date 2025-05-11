package main
import (
    "fmt"
    "math/big"
)

func getDigitalSum(n *big.Int) int {
    sum := 0
    temp := new(big.Int).Set(n)
    zero, mod := big.NewInt(0), big.NewInt(0)
    ten := big.NewInt(10)
    
    for temp.Cmp(zero) > 0 {
        temp.DivMod(temp, ten, mod)
        sum += int(mod.Int64())
    }
    return sum
}

func main() {
    res := 0
    for a := 1; a < 100; a++ {
        for b := 1; b < 100; b++ {
            base := big.NewInt(int64(a))
            pow := big.NewInt(int64(b))
            num := new(big.Int).Exp(base, pow, nil)
            res = max(res, getDigitalSum(num))
        }
    }
  fmt.Println(res)
}
