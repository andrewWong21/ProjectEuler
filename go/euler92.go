package main
import "fmt"

func main() {
    squares := []int{0, 1, 4, 9, 16, 25, 36, 49, 64, 81}
    cache := make(map[int]bool)
    res := 0
    for n := 1; n < 10000000; n++ {
        // keep track of numbers seen starting at n
        chain := []int{}
        curr := n
        for curr != 1 && curr != 89 {
            chain = append(chain, curr)
            // calculate sum of digits squared
            sum := 0
            for curr > 0 {
                sum += squares[curr % 10]
                curr /= 10
            }
            curr = sum
            if val, exists := cache[curr]; exists {
                // current number in chain has been encountered before
                curr = 89
                // if curr is part of a chain ending at 1, short-circuit
                if !val {
                    curr = 1
                    break
                }
            }
        }
        endsAt89 := (curr == 89)
        if endsAt89 {
            res++
        }
        // store whether all numbers in chain reach 89
        for _, num := range chain {
            cache[num] = endsAt89
        }
    }
    fmt.Println(res)
}
