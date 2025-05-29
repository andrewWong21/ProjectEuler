package main
import "fmt"

func gcf(a int, b int) int {
    for b != 0 {
        a, b = b, a % b
    }
    return a
}

func main() {
    res := 0
    for d := 2; d <= 12000; d++ {
        for n := d / 3 + 1; 2 * n < d; n++ {
            if gcf(d, n) == 1 {
                res++
            }
        }
    }
    fmt.Println(res)
}
