package main
import "fmt"

func generateCombs(nums []int) [][]int {
    n, k := len(nums), 6
    combs := [][]int{}
    comb := []int{}
    
    var backtrack func(int)
    backtrack = func (idx int) {
        if len(comb) == k {
            c := make([]int, k)
            copy(c, comb)
            combs = append(combs, c)
            return
        }
        for i := idx; i < n; i++ {
            comb = append(comb, nums[i])
            backtrack(i + 1)
            comb = comb[:len(comb) - 1]
        }
    }
    backtrack(0)
    return combs
}

func canShowSquares(d1 []int, d2 []int) bool {
    s1, s2 := generateSet(d1), generateSet(d2)
    for i := 1; i < 10; i++ {
        sq := i * i
        n1, n2 := sq / 10, sq % 10
        if (s1[n1] && s2[n2]) || (s1[n2] && s2[n1]) {
            continue
        }
        return false
    }
    return true
}

func generateSet(nums []int) []bool {
    set := make([]bool, 10)
    for _, n := range nums {
        if n == 6 || n == 9 {
            set[6] = true
            set[9] = true
        } else {
            set[n] = true
        }
    }
    return set
}

func main() {
    nums := []int{
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
    }
    dice := generateCombs(nums)
    res := 0
    for i := 0; i < len(dice); i++ {
        for j := i; j < len(dice); j++ {
            if canShowSquares(dice[i], dice[j]) {
                res++
            }
        }
    }
    fmt.Println(res)
}
