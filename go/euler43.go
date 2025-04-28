package main
import (
    "fmt"
    "strconv"
)

func main() {
    // abcdefghij - 0-9 pandigital number
    // bcd % 2 = 0, cde % 3 = 0, def % 5 = 0, efg % 7 = 0
    // fgh % 11 = 0, ghi % 13 = 0, hij % 17 = 0
    
    // def % 5 = 0: f = 0, 5
    // 0gh % 11 = 0 requires g = h, cannot be pandigital
    
    // 5gh % 11 = 0: (506, 517, 528, 539, 550, 561, 572, 583, 594)
    // 550 has repeated digit
    // fgh = 506, 517, 528, 539, 561, 572, 583, 594
    
    // ghi % 13 = 0
    // 06i % 13 = 0: i = 5, cannot be pandigital since f = 5
    // 17i % 13 = 0: no solution
    // 28i % 13 = 0: i = 6
    // 39i % 13 = 0: i = 0
    // 61i % 13 = 0: i = 1, cannot be pandigital
    // 72i % 13 = 0: i = 8
    // 83i % 13 = 0: i = 2
    // 94i % 13 = 0: i = 9, cannot be pandigital
    // fghi = 5286, 5390, 5728, 5832
    
    // hij % 17 = 0
    // 86j % 17 = 0: j = 7
    // 90j % 17 = 0: j = 1
    // 28j % 17 = 0: j = 9
    // 32j % 17 = 0: j = 3, cannot be pandigital
    // fghij = 52867, 53901, 57289
    
    // efg % 7 = 0
    // e52 % 7 = 0: e = 9 (e = 2 results in non-pandigital)
    // e53 % 7 = 0: e = 5, cannot be pandigital
    // e57 % 7 = 0: e = 3
    // efghij = 952867, 357289
    
    // bcd % 2 = 0
    // efghij = 952867: d = 0, 4
    // efghij = 357289: d = 0, 4, 6
    // defghij = 0952867, 4952867, 0357289, 4357289, 6357289
    
    // cde % 3 = 0
    // c09 = 0: c = 3 (6 already used)
    // c49 = 0: c = 2, 5, 8, all already used
    // c03 = 0: c = 6 (9 already used)
    // c43 = 0: c = 2, 5, 8, all already used
    // c63 = 0: c = 0 (9 already used)
    
    
    res := 0
    // cdefghij = 30952867, 60357289, 06357289 satisfies all divisibility conditions
    suffixes := []string{"30952867", "60357289", "06357289"}
    // ab = 14, 41 satisfies pandigital condition
    prefixes := []string{"14", "41"}
    
    for _, prefix := range prefixes {
        for _, suffix := range suffixes {
            str := prefix + suffix
            num, _ := strconv.Atoi(str)
            res += num
        }
    }
    
    fmt.Println(res)
}
