package main
import "fmt"

func main() {
    res := 0
    res += len("onetwothreefourfivesixseveneightnine") * 190
    res += len("twentythirtyfortyfiftysixtyseventyeightyninety") * 100
    res += len("teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen") * 10
    res += len("hundred") * 900
    res += len("and") * 891
    res += len("onethousand")
    fmt.Println(res)
}
