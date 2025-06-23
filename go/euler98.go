package main
import (
    "fmt"
    "sort"
    "strings"
    "strconv"
)

func sortLetters(word string) string {
    s := strings.Split(word, "")
    sort.Strings(s)
    return strings.Join(s, "")
}

func mapSquares(words []string, squares []string) int {
    // TODO: given a list of words of the same length,
    // identify anagram families
    // return maximum square that is an anagram of another square
    // where both squares can be mapped to a pair of word anagrams
    // such that each digit corresponds to a different letter
    // and each letter corresponds to a different digit
    return 0
}

func isValidMapping(word string, square int) bool {
    // precondition: len(word) == len(square)
    charToDigit := make(map[byte]byte)
    digitToChar := make(map[byte]byte)
    for i := 0; i < len(word); i++ {
        c, d := word[i], square[i]
        if (charToDigit[c] && charToDigit[c] != d) ||
            (digitToChar[d] && digitToChar[d] != c) {
            return false
        }
        charToDigit[c] = d
        digitToChar[d] = c
    }
    return true
}

func main() {
    words := []string{
        "ACT", "CAT", "TAB", "BAT", 
        "RACE", "CARE", 
        "PEARS", "SPARE",
        //"ABCDEF", "FABCDE",
        //"ANAGRAM", "NAGARAM",
        "ONOMATOPOEIA",
    }
    maxLen := 0
    groups := make(map[string][]string)
    for _, word := range words {
        key := sortLetters(word)
        groups[key] = append(groups[key], word)
    }
    fmt.Println(groups)
    // only generate squares up to length of longest word in group of at least 2 anagrams
    for _, group := range groups {
        if len(group) < 2 {
            continue
        }
        maxLen = max(maxLen, len(group[0]))
    }
    
    // populate groups of squares of the same length with up to maxLen digits
    squares := make([][]string, maxLen + 1)
    for i := 1; ; i++ {
        sq := strconv.Itoa(i * i)
        length := len(sq)
        if length > maxLen {
            break
        }
        squares[length] = append(squares[length], sq)
    }
    
    res := 0
    // for each group, try mapping 
    
    fmt.Println(res)
}
