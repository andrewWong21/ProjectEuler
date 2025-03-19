package main
import (
    "fmt"
    "math"
)

func main() {
    res := 0
    n := 600851475143
    s := int(math.Floor(math.Sqrt(float64(n))))
    sieved := make([]bool, s)
    for i := 2; i < len(sieved); i++ {
        if (!sieved[i]){
            for j := 2 * i; j < len(sieved); j += i {
                sieved[j] = true
            }
            if n % i == 0 {
                res = i
            }
        }
    } 
    fmt.Println(res)
}
