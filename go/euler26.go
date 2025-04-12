package main
import "fmt"

func getCycleLength(n int) int {
    seen := make(map[int]int)
    rem := 1
    curr := 0
    for rem != 0 {
        rem = (rem * 10) % n
        _, found := seen[rem]
        if found {
            return curr - seen[rem]
        }
        seen[rem] = curr
        curr++
    }
    return 0
}

func main() {
    res, maxCycle := 0, 0
    for d := 2; d < 1000; d++ {
        cycle := getCycleLength(d)
        if cycle > maxCycle {
            res = d
            maxCycle = cycle
        }
    }
  fmt.Println(res)
}
