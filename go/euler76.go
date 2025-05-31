package main
import "fmt"

func main() {
    sums := [101]int{}
    sums[0] = 1
    for i := 1; i < len(sums) - 1; i++ {
        for j := i; j < len(sums); j++ {
            sums[j] += sums[j - i]
        }
    }
    fmt.Println(sums[100])
}
