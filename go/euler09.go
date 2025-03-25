package main
import "fmt"

func main() {
    // a + b + c = p, p = 1000
    // c = p - a - b
    // a^2 + b^2 = c^2
    
    // a^2 + b^2 = (p - a - b)^2
    // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
    // a^2 + b^2 = p^2 - 2ap - 2bp + 2ab + a^2 + b^2
    // 0 = p^2 - 2ap - 2bp + 2ab
    // 2bp - 2ab = p^2 - 2ap
    // b * (2p - 2a) = p^2 - 2ap
    // b = (p^2 - 2ap) / (2p - 2a)
    
    // p * (p - 2a) > 0, p > 0
    // p - 2a > 0, a < p / 2
    
    res := 0
    p := 1000
    for a := 1; a <= p / 2; a++ {
        if (p * p - 2 * a * p) % (2 * p - 2 * a) == 0 {
            b := (p * p - 2 * a * p) / (2 * p - 2 * a)
            c := p - a - b
            res = a * b * c
            break
        }
    }
    fmt.Println(res)
}
