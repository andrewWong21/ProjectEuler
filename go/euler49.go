package main
import (
    "fmt"
    "sort"
    "strings"
    "strconv"
)

func buildGroups() map[string][]int {
    groups := make(map[string][]int)
    for n := 1001; n <= 9999; n += 2 {
        if isPrime(n) {
            digits := sortDigits(n)
            
            if (digits == "1478") {
                continue
            }
            _, found := groups[digits]
            if !found {
                groups[digits] = []int{}
            }
            groups[digits] = append(groups[digits], n)
        }
    }
    return groups
}

func isPrime(n int) bool {
    if n < 2 {
        return false
    }
    for i := 2; i * i <= n; i++ {
        if n % i == 0 {
            return false
        }
    }
    return true
}

func buildSequence(nums []int) int {
    seen := make(map[int]bool)
    for _, num := range nums {
        seen[num] = true
    }
    for j := 1; j < len(nums); j++ {
        for i := 0; i < j; i++ {
            diff := nums[j] - nums[i]
            third := nums[j] + diff
            _, found := seen[third]
            if found {
                return nums[i] * 100000000 + nums[j] * 10000 + third
            }
        }
    }
    
    return 0
}

func sortDigits(n int) string {
    s := strings.Split(strconv.Itoa(n), "")
    sort.Strings(s)
    digits := strings.Join(s, "")
    return digits
}

func main() {
    res := 0
    groups := buildGroups()
    for _, group := range groups{
        if len(group) >= 3 {
            res = buildSequence(group)
            if res != 0 {
                break
            }
        }
    }
    fmt.Println(res)
}
