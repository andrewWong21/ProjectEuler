package main
import (
    "fmt"
    "math"
    "math/big"
)

func isSquare(n int) bool {
    s := int(math.Sqrt(float64(n)))
    return s * s == n
}

func getParts(d int) []int {
    res := []int{}
    a0 := int(math.Sqrt(float64(d)))
    a := a0
    b := a
    c := 1
    for a != 2 * a0 {
        c = (d - b * b) / c
        a = int(math.Floor(float64(a0 + b) / float64(c)))
        b = a * c - b
        res = append(res, a)
    }
    
    return res
}

func getSolution(d int) *big.Int {
    parts := getParts(d)
    prevNum := big.NewInt(1)
    prevDen := big.NewInt(0)
    currNum := big.NewInt(int64(math.Sqrt(float64(d))))
    currDen := big.NewInt(1)
    
    count := 0
    for {
        k := big.NewInt(int64(parts[count % len(parts)]))
        num := new(big.Int).Add(new(big.Int).Mul(currNum, k), prevNum)
        den := new(big.Int).Add(new(big.Int).Mul(currDen, k), prevDen)
        
        numSq := new(big.Int).Mul(num, num)
        denSq := new(big.Int).Mul(den, den)
        prod := new(big.Int).Mul(denSq, big.NewInt(int64(d)))
        diff := new(big.Int).Sub(numSq, prod)
        if diff.Cmp(big.NewInt(1)) == 0 {
            return num
        }
        prevNum = currNum
        prevDen = currDen
        currNum = num
        currDen = den
        count++
    }
}

func main() {
    res, x := 0, big.NewInt(0)
    for d := 2; d <= 1000; d++ {
        if !isSquare(d) {
            solution := getSolution(d)
            if solution.Cmp(x) == 1 {
                x = solution
                res = d
            }
        }
    }
    fmt.Println(res)
}
