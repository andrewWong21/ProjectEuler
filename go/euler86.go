package main
import (
    "fmt"
    "math"
)

func getMinDimension(minSols int) int {
    solutions := 0
    for a := 1; ; a++ {
        for b := 1; b <= a; b++ {
            for c := 1; c <= b; c++ {
                route := (a * a) + (b + c) * (b + c)
                s := int(math.Sqrt(float64(route)))
                if s * s == route {
                    solutions++
                    if solutions >= minSols {
                        return a
                    }
                }
            }
        }
    }
}

func main() {
    minSols := 1000000
    fmt.Println(getMinDimension(minSols))
}
