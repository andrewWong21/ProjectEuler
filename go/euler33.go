package main
import "fmt"

func gcf(a int, b int) int {
    for b > 0 {
        temp := a % b
        a = b
        b = temp
    }
    return a
}

func main() {
    num, den := 1, 1
    for n := 10; n < 100; n++ {
        if n % 10 == 0 {
            continue
        }
        for d := n + 1; d < 100; d++ {
            if (n % 10) == (d / 10) {
                before := float64(n) / float64(d)
                after := float64(n / 10) / float64(d % 10)
                if before == after {
                    num *= n / 10
                    den *= d % 10
                }
            }
            
        }
    }
    fmt.Println(den / gcf(den, num))
}
