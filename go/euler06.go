package main
import "fmt"

func main() {
    sum := 0
    squareSum := 0
    for i := 1; i <= 100; i++ {
        sum += i
        squareSum += i * i
    }
    fmt.Println(sum * sum - squareSum)
}
