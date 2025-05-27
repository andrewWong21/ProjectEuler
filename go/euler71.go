package main
import "fmt"

func main() {
    a, b, c, d := 2, 5, 3, 7
    for b + d < 1000000 {
        a += c
        b += d
    }
    fmt.Println(a)
}
