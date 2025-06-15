package main
import "fmt"

func main() {
    res := 0
    for x1 := 0; x1 <= 50; x1++ {
        for y1 := 0; y1 <= 50; y1++ {
            if x1 == 0 && y1 == 0 {
                continue
            }
            for x2 := 0; x2 <= 50; x2++ {
                for y2 := 0; y2 <= 50; y2++ {
                    if x2 == 0 && y2 == 0 {
                        continue
                    }
                    if x2 < x1 || (x2 == x1 && y2 <= y1) {
                        continue
                    }
                    s1 := x1 * x1 + y1 * y1
                    s2 := x2 * x2 + y2 * y2
                    s3 := (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)
                    if s1 + s2 == s3 || s1 + s3 == s2 || s2 + s3 == s1 {
                        res++
                    }
                    
                }
            }
        }
    }
    fmt.Println(res)
}
