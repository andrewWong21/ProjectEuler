package main
import (
    "fmt"
    "math/big"
)

func main() {
    n1, n2 := big.NewInt(1), big.NewInt(1)
    sum, temp := new(big.Int), new(big.Int)
    n := 2
    for len(n2.String()) < 1000 {
        temp.Set(n1)
        n1.Set(n2)
        sum.Add(n2, temp)
        n2.Set(sum)
        n++
    }
    fmt.Println(n)
}
