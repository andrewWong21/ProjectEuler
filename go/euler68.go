package main
import (
    "fmt"
    "strconv"
)

func stringifyRing(nums []int) int {
    // precondition: ring is valid
    inner := nums[:5]
    outer := nums[5:]
    str := ""
    for i := 0; i <= 4; i++ {
        str += strconv.Itoa(outer[i]) + strconv.Itoa(inner[i]) + strconv.Itoa(inner[(i + 1) % 5])
    }
    if len(str) != 16 {
        return 0
    }
    num, _ := strconv.Atoi(str)
    return num
}

func isValidRing(nums []int) bool {
    inner := nums[:5]
    // 10 must be in outer ring to generate a 16-digit string
    for _, num := range inner {
        if num == 10 {
            return false
        }
    }
    
    outer := nums[5:]
    // numerically lowest number in outer ring must be first
    for _, num := range outer {
        if num < outer[0] {
            return false
        }
    }
    
    
    // each line must have the same sum
    sum := outer[4] + inner[4] + inner[0]
    for i := 0; i < 4; i++ {
        line := outer[i] + inner[i] + inner[i + 1]
        if line != sum {
            return false
        }
    }
    return true
}

func generateRings(nums []int) [][]int {
    n := len(nums)
    used := make([]bool, n)
    perms := [][]int{}
    perm := []int{}
    
    var backtrack func(int)
    backtrack = func(idx int) {
        if idx == n {
            // 10 must be in outer ring to generate a 16-digit string
            for i := 0; i < n / 2; i++ {
                if perm[i] == 10 {
                    return
                }
            }
            // numerically lowest number in outer ring must be first
            minVal := perm[n/2]
            for i := n / 2 + 1; i < n; i++ {
                if perm[i] < minVal {
                    return
                }
            }
            p := make([]int, n)
            copy(p, perm)
            perms = append(perms, p)
            return
        }
        for i := 0; i < n; i++ {
            if !used[i] {
                used[i] = true
                perm = append(perm, nums[i])
                backtrack(idx + 1)
                used[i] = false
                perm = perm[:len(perm) - 1]
            }
        }
    }
    backtrack(0)
    return perms
}

func main() {
    res := 0
    // generate permutations of numbers 1-10
    nums := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    rings := generateRings(nums)
    for _, ring := range rings {
        if isValidRing(ring) {
            val := stringifyRing(ring)
            if val > res {
                res = val
            }
        }
    }
    fmt.Println(res)
}
