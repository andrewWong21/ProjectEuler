package main
import (
    "fmt"
    "strconv"
)

func topologicalSort(codes []string) string {
    adj := make(map[int]map[int]bool)
    indeg := make(map[int]int)
    
    for _, code := range codes {
        a, _ := strconv.Atoi(string(code[0]))
        b, _ := strconv.Atoi(string(code[1]))
        c, _ := strconv.Atoi(string(code[2]))
        
        for _, digit := range []int{a, b, c} {
            if _, found := adj[digit]; !found {
                adj[digit] = make(map[int]bool)
            }
            if _, found := indeg[digit]; !found {
                indeg[digit] = 0
            }
        }
        if !adj[a][b] {
            adj[a][b] = true    
            indeg[b]++
        }
        if !adj[b][c] {
            adj[b][c] = true
            indeg[c]++
        }
        
    }
    
    res := ""
    q := []int{}
    for digit, degree := range indeg {
        if degree == 0 {
            q = append(q, digit)
        }
    }
    
    for len(q) > 0 {
        curr := q[0]
        q = q[1:]
        
        res += strconv.Itoa(curr)
        
        for nei := range adj[curr] {
            indeg[nei]--
            if indeg[nei] == 0 {
                q = append(q, nei)
            }
        }
    }
    
    return res
}
func main() {
    codes := []string{
        "319", "680", "180", "690", "129",
        "620", "762", "689", "762", "318",
        "368", "710", "720", "710", "629", 
        "168", "160", "689", "716", "731", 
        "736", "729", "316", "729", "729", 
        "710", "769", "290", "719", "680", 
        "318", "389", "162", "289", "162",
        "718", "729", "319", "790", "680", 
        "890", "362", "319", "760", "316", 
        "729", "380", "319", "728", "716", 
    }
    
    fmt.Println(topologicalSort(codes))
}
