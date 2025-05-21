package main
import (
    "fmt"
    "math/big"
)

func getDigitSum(n *big.Int) int {
    temp := new(big.Int).Set(n)
    zero := big.NewInt(0)
    mod := big.NewInt(0)
    ten := big.NewInt(10)
    sum := 0
    for temp.Cmp(zero) != 0 {
        temp.DivMod(temp, ten, mod)
        sum += int(mod.Int64())
    }
    return sum
}

func main() {
    k := 1
    prevNum := big.NewInt(1)
    num := big.NewInt(2)
    for n := 1; n < 100; n++ {
        r := int64(1)
        if n % 3 == 2 {
            r = int64(2 * k)
            k++
        }
        temp := new(big.Int)
        newNum := temp.Add(temp.Mul(big.NewInt(r), num), prevNum)
        prevNum = num
        num = newNum
    }
    res := getDigitSum(num)
    fmt.Println(res)
}
