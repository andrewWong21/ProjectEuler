package main
import "fmt"

func gcf(a int, b int) int{
    for b > 0 {
        temp := a % b
        a = b
        b = temp
    }
    return a
}

func main() {
    res := 2520
    for i := 11; i <= 20; i++ {
        res = (res * i) / gcf(res, i)
    }
    fmt.Println(res)
}
