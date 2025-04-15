package main
import "fmt"

func main() {
    res := 0
    powers := []int{0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049}
    // number with D digits can have a maximum fifth power digit sum of 9^5 * D
    // minimum value of D-digit number is 10^D-1
    // check numbers up to d digits, where d is first value
    // that satisfies 10^(d - 1) > d * 9^5, d = 7
    // check numbers up to 1 million
    for i := 2; i <= 1000000; i++ {
        n := i
        sum := 0
        for n > 0 {
            sum += powers[n % 10]
            n /= 10
        }
        if i == sum {
            res += i
        }
    }
    fmt.Println(res)
}
