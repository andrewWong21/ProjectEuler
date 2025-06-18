package main
import "fmt"

func generateOps() [][]string {
    syms := []string{"+", "-", "*", "/"}
    ops := [][]string{}
    for i := 0; i < 4; i++ {
        for j := 0; j < 4; j++ {
            for k := 0; k < 4; k++ {
                op := []string{syms[i], syms[j], syms[k]}
                ops = append(ops, op)
            }
        }
    }
    return ops
}

func generateCombs(n int, k int) [][]int {
    combs := [][]int{}
    curr := []int{}
    
    var backtrack func(int)
    backtrack = func(idx int) {
        if len(curr) == k {
            comb := make([]int, k)
            copy(comb, curr)
            combs = append(combs, comb)
            return
        }
        for i := idx; i <= n; i++ {
            curr = append(curr, i)
            backtrack(i + 1)
            curr = curr[:len(curr) - 1]
        }
    }
    backtrack(0)
    return combs
}

func generatePerms(nums []int) [][]int {
    perms := [][]int{}
    used := make([]bool, len(nums))
    curr := []int{}
    
    var backtrack func(int)
    backtrack = func(idx int) {
        if idx == len(nums) {
            perm := make([]int, len(nums))
            copy(perm, curr)
            perms = append(perms, perm)
            return
        }
        for i := 0; i < len(nums); i++ {
            if !used[i] {
                curr = append(curr, nums[i])
                used[i] = true
                backtrack(idx + 1)
                curr = curr[:len(curr) - 1]
                used[i] = false
            }
        }
    }
    backtrack(0)
    return perms
}

func getStreak(nums []int, ops []string) int {
    perms := generatePerms(nums)
    seen := make(map[int]bool)
    groups := []string{
        "xxxx...", "xxx.x..", "xxx..x.", "xx.xx..", "xx.x.x.",
    }
    
    for _, perm := range perms {
        for _, op := range ops {
            for _, group := range groups {
                seen[eval(perm, op, group)] = true
            }
        }
    }
    for i := 1; ; i++ {
        if _, found := seen[i]; !found {
            return i - 1
        }
    }
}

func eval(nums []int, ops string, group string) int {
    stack := []float{}
    // TODO: push nums and apply postfix ops according to group structure
    for _, c := range group {
        // if c == x
        
        // if c == .
    }
    
    res := stack[0]
    if res < 0 {
        return -1
    }
    return res
}

func main() {
    res, maxStreak := 0, 0
    ops := generateOps()
    
    combs := generateCombs(9, 4)
    for _, comb := range combs {
        for _, op := range ops {
            streak := getStreak(comb, op)
            if streak > maxStreak {
                maxStreak = streak
                res = comb[0] * 1000 + comb[1] * 100 + comb[2] * 10 + comb[3]
            }
        }
    }
    fmt.Println(res)
}