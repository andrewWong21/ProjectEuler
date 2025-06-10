package main
import (
    "fmt"
    "math"
)

func main() {
    res, diff := 0, 2000000
    for length := 1; length <= 100; length++ {
        for width := 1; width <= length; width++ {
            rectangles := 0
            for i := 1; i <= length; i++ {
                for j := 1; j <= width; j++ {
                    rectangles += (length - i + 1) * (width - j + 1)
                }
            }
            newDiff := int(math.Abs(float64(2000000 - rectangles)))
            if newDiff < diff {
                diff = newDiff
                res = length * width
            }
        }
    }
    fmt.Println(res)
}
