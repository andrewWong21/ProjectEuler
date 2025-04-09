package main
import "fmt"

func properDivisorSum(n int) int {
    if n == 1 {
        return 0
    }
    res := 1
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            res += i
            if n / i != i {
                res += n / i
            }
        }
    }
    return res
}

func main() {
    res := 0
    limit := 28123
    abNums := []int{}
    for i := 1; i <= limit; i++ {
        if properDivisorSum(i) > i {
            abNums = append(abNums, i)
        }
    }
    
    abSums := make([]bool, limit + 1)
    for i := 0; i < len(abNums); i++ {
        for j := i; j < len(abNums); j++ {
            sum := abNums[i] + abNums[j]
            if sum > limit {
                break
            }
            abSums[sum] = true
        }
    }
    for i := 1; i <= limit; i++ {
        if !abSums[i] {
            res += i
        }
    }
    fmt.Println(res)
}
