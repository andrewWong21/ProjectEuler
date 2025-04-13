package main
import "fmt"

func main() {
    res := 1
    for s := 3; s <= 1001; s += 2 {
        // corners of spiral of side length s:
        // s^2, s^2 - s + 1, s^2 - 2s + 2, s^2 - 3s + 3
        res += 4 * s * s - 6 * s + 6
    }
    fmt.Println(res)
}
