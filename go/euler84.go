package main
import (
    "fmt"
    "time"
    "math/rand"
    "slices"
)


func roll(n int) int {
    return rand.Intn(n) + 1
}

func simulate(sides int, turns int) string {
    squares := []string{
        "GO",  "A1",  "CC1",  "A2",  "T1",  "R1",  "B1",  "CH1",
        "B2",  "B3",  "JAIL", "C1",  "U1",  "C2",  "C3",  "R2",
        "D1",  "CC2", "D2",   "D3",  "FP",  "E1",  "CH2", "E2", 
        "E3",  "R3",  "F1",   "F2",  "U2",  "F3",  "G2J", "G1",  
        "G2",  "CC3", "G3",   "R4",  "CH3", "H1",  "T2",  "H2",
    }
    
    // Community Chest and Chance cards
    chests := []int{0, 10}
    for len(chests) < 16 {
        chests = append(chests, -1)
    }
    chances := []int{0, 10, 11, 24, 39, 5, -5, -5, -12, -3}
    for len(chances) < 16 {
        chances = append(chances, -1)
    }
    
    // shuffle cards at the beginning of the game
    
    ccs := []int{2, 17, 33}
    chs := []int{7, 22, 36}
    railways := []int{5, 15, 25, 35}
    utilities := []int{12, 28}
    
    visited := [40]int{}
    curr, doubles := 0, 0
    
    for i := 0; i < turns; i++ {
        // roll die with given number of sides
        roll1, roll2 := roll(sides), roll(sides)
        
        // keep track of doubles rolled
        if roll1 == roll2 {
            doubles++
            // send player to jail (10)
            // if three consecutive doubles are rolled
            if doubles == 3 {
                curr = 10
                visited[curr]++
                doubles = 0
                continue
            }
        } else {
            doubles = 0
        }
        curr = (curr + roll1 + roll2) % len(squares)
        
        if curr == 30 {
            curr = 10
            visited[curr]++
            continue
        }
        
        // apply square side-effects if applicable
        if slices.Contains(ccs, curr) {
            
        } else if slices.Contains(chs, curr) {
            
        }
        
        // handle community chest and chance card draws
        // draw card, apply effect and insert at end of queue
    }
    
    return getModalStr(visited)
}

func getModalStr(squares []int) string {
    // generate length-6 modal string
    // from indices of top 3 most visited squares
    first, second, third := 0, 0, 0
    for i := 0; i < len(squares); i++ {
        if squares[i] > squares[first] {
            third = second
            second = first
            first = i
        } else if squares[i] > squares[second] {
            third = second
            second = i
        } else if squares[i] > squares[third] {
            third = i
        }
    }
    return fmt.Sprintf("%02d", first) + fmt.Sprintf("%02d", second) + fmt.Sprintf("%02d", third)
}

func main() {
    // Monte Carlo simulation
    tests, games, turns := 10, 200, 5000
    modalStrs := make(map[string]int)
    rand.Seed(time.Now().UnixNano())
    
    for i := 0; i < tests; i++ {
        for j := 0; j < games; j++ {
            modalStr := simulate(4, turns)
            if _, found := modalStrs[modalStr]; !found {
                modalStrs[modalStr] = 0
            }
            modalStrs[modalStr]++
        }
    }
    fmt.Println(modalStrs)
}
