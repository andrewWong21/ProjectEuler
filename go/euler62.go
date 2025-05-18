package main
import (
    "fmt"
    "math"
    "sort"
    "strings"
    "strconv"
)

func sortDigits(n int) string {
    s := strings.Split(strconv.Itoa(n), "")
    sort.Strings(s)
    digits := strings.Join(s, "")
    return digits
}

func main() {
    res := math.MaxInt32
    // a number has at least 5 permutations if it has at least 3 digits
    maxLen := 3
    for res == math.MaxInt32 {
        cubeDigits := make(map[string][]int)
        start := math.Ceil(math.Pow(math.Pow(10, maxLen - 1), 1.0/3.0))
        for len(string(math.Pow(start, 3)) < maxLen {
            cube = start * start * start
            digits = sortDigits()
            _, found := cubeDigits[digits]
            if found {
                cubeDigits[digits] = append(cubeDigits[digits], cube)
            }
            // TODO: check if digit family has exactly 3 permutations and identify smallest cube
        }
    }
    fmt.Println(res)
}
