package main
import (
    "fmt"
    "math"
)

func isTriangle(n int) bool {
    // p = n * (n + 1) / 2
    // 0 = n^2 + n - 2p
    // n = (-1 + sqrt(1 + 8p)) / 2
    x := (math.Sqrt(8 * float64(n) + 1) - 1) / 2
    return x == math.Floor(x)
}

func isSquare(n int) bool {
    x := math.Sqrt(float64(n))
    return x == math.Floor(x)
}

func isPentagon(n int) bool {
    // p = n * (3n - 1) / 2
    // 0 = 3n^2 - n - 2p
    // n = (1 + sqrt(1 + 24p)) / 6
    x := (math.Sqrt(24 * float64(n) + 1) + 1) / 6
    return x == math.Floor(x)
}

func isHexagon(n int) bool {
    // p = n * (2n - 1)
    // 0 = 2n^2 - n - p
    // n = (1 + sqrt(1 + 8p)) / 4
    x := (math.Sqrt(8 * float64(n) + 1) + 1) / 4
    return x == math.Floor(x)
}


func isHeptagon(n int) bool {
    // p = n * (5n - 3) / 2
    // 0 = 5n^2 - 3n - 2p
    // n = (3 + sqrt(9 + 40p)) / 10
    x := (math.Sqrt(40 * float64(n) + 9) + 3) / 10
    return x == math.Floor(x)
}

func isOctagon(n int) bool {
    // p = n * (3n - 2)
    // 0 = 3n^2 - 2n - p
    // n = (2 + sqrt(4 + 12p)) / 6
    // n = (1 + sqrt(1 + 3p)) / 3
    x :=(math.Sqrt(3 * float64(n) + 1) + 1) / 3
    return x == math.Floor(x)
}

func canContinue(a int, b int) bool {
    return a % 100 == b / 100
}

func generateCycle(cycle []int, used map[int]bool, polygonSets [][]int) []int {
    if len(cycle) == 6 {
        if canContinue(cycle[5], cycle[0]) {
            return cycle
        }
        return []int{}
    }
    last := cycle[len(cycle) - 1]
    for i, pSet := range polygonSets {
        if used[i] {
            continue
        }
        for _, p := range pSet {
            if canContinue(last, p) {
                used[i] = true
                newCycle := generateCycle(append(cycle, p), used, polygonSets)
                if len(newCycle) != 0 {
                    return newCycle
                }
                used[i] = false
            }
        }
    }
    return []int{}
}

func main() {
    triangles := []int{}
    squares := []int{}
    pentagons := []int{}
    hexagons := []int{}
    heptagons := []int{}
    octagons := []int{}
    
    for n := 1000; n < 10000; n++ {
        if isTriangle(n) {
            triangles = append(triangles, n)
        }
        if isSquare(n) {
            squares = append(squares, n)
        }
        if isPentagon(n) {
            pentagons = append(pentagons, n)
        }
        if isHexagon(n) {
            hexagons = append(hexagons, n)
        }
        if isHeptagon(n) {
            heptagons = append(heptagons, n)
        }
        if isOctagon(n) {
            octagons = append(octagons, n)
        }
    }
    polygons := [][]int{
        triangles, squares, pentagons, hexagons, heptagons,
    }
    res := 0
    
    // start with smallest set
    for _, oct := range octagons {
        cycle := generateCycle([]int{oct}, make(map[int]bool), polygons)
        
        if len(cycle) == 6 {
            sum := 0
            for _, p := range cycle {
                sum += p
            }
            res = sum
            break
        }
    }
    fmt.Println(res)
}
