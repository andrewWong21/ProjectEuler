package main
import "fmt"

func paths(n int) int {
    // moving from the top left corner to the bottom right corner
    // requires n movements right and n movements down (nxn grid)
    // 2n movements, number of possible routes is (2n)! / (n! * n!)
    // simplify to (2n * (2n - 1) * ... * (n + 1)) / (n!)
    res := 1
    for i := 1; i <= n; i++ {
        res *= n + i
        res /= i
    }
    return res
}

func main() {
  fmt.Println(paths(20))
}
