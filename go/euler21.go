package main
import "fmt"

func properDivisorSum(n int) int {
    res := 1
    for i := 2; i * i <= n; i++ {
        if (n % i == 0){
            res += i + (n / i)
            if (n / i == i){
                res -= i
            }
        }
    }
    return res
}

func main() {
    res := 0
    for i := 2; i < 10000; i++ {
        divSum := properDivisorSum(i)
        if divSum > i && properDivisorSum(divSum) == i {
            res += i + divSum
        }
    }
    fmt.Println(res)
}
