package main
import "fmt"

func main(){
    res := 0
    n1 := 1
    n2 := 1
    for n2 < 4000000 {
        if n2 % 2 == 0 {
            res += n2
        }
        temp := n1
        n1 = n2
        n2 += temp
    }
    fmt.Println(res)
}
