package main
import "fmt"

func multSum(n, max int) int {
    mults := (max - 1) / n
    return n * (mults * (mults + 1)) / 2
}

func main(){
    n := 1000
    res := multSum(3, n) + multSum(5, n) - multSum(15, n)
    fmt.Println(res)
}
