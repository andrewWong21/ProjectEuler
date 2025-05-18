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
    res := math.MaxInt64
    // a number has at least 5 permutations if it has at least 3 digits
    maxLen := 3
    for res == math.MaxInt64 {
        cubeDigits := make(map[string][]int)
        start := math.Ceil(math.Cbrt(math.Pow(10, float64(maxLen - 1))))
        end := math.Floor(math.Cbrt(math.Pow(10, float64(maxLen))))
        for n := int(start); n <= int(end); n++ {
            cube := n * n * n
            digits := sortDigits(cube)
            cubeDigits[digits] = append(cubeDigits[digits], cube)
        }
        for _, group := range cubeDigits {
            if len(group) == 5 && group[0] < res {
                res = group[0]
            }
        }
        maxLen++
    }
    fmt.Println(res)
}
