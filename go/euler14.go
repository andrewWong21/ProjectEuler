package main
import "fmt"

var lengths = make(map[int]int)

func collatz(n int) int {
    if length, found := lengths[n]; found {
        return length
    }
    
    if n == 1 {
        return 1
    }
    
    var next int
    if n % 2 == 0 {
        next = n / 2
    } else {
        next = 3 * n + 1
    }
    
    length := 1 + collatz(next)
    lengths[n] = length
    return length
}

func main() {
    res := 0
    maxLen := 0
    lengths[1] = 1
    
    for i := 1; i < 1000000; i++ {
        length := collatz(i)
        if length > maxLen {
            res = i
            maxLen = length
        }
    }
    fmt.Println(res)
}
