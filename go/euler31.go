package main
import "fmt"

func main() {
    coins := []int{1, 2, 5, 10, 20, 50, 100, 200}
    dp := [201]int{}
    dp[0] = 1
    
    for _, coin := range coins {
        for i := coin; i < len(dp); i++ {
            dp[i] += dp[i - coin]
        }
    }
    fmt.Println(dp[200])
}
