package main
import "fmt"

func main() {
    n := 60000
    sums := make([]int, n + 1)
    sums[0] = 1
    for i := 0; i < len(sums); i++ {
        for j := i; j < len(sums); j++ {
            sums[j] += sums[j - i] % 1000000
        }
        sums[i] %= 1000000
        if sums[i] == 0 {
            fmt.Println(i)
            break
        }
    }
}
