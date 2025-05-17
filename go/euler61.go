package main
import (
    "fmt"
    "math"
)

func isTriangle(n int) bool {
    // p = n * (n + 1) / 2
    // 0 = n^2 + n - 2p
    // n = () / 2
    x := 
    return x == math.Floor(x)
}

func isSquare(n int) bool {
    x := math.Sqrt(n)
    return x == math.Floor(x)
}

func isPentagon(n int) bool {
    // p = n * (3n - 1) / 2
    
    x :=
    return x == math.Floor(x)
}

func isHexagon(n int) bool {
    // p = n * (2n - 1)
    
    x :=
    return x == math.Floor(x)
}


func isHeptagon(n int) bool {
    // p = n * (5n - 3) / 2
    
    x :=
    return x == math.Floor(x)
}

func isOctagon(n int) bool {
    // p = n * (3n - 2)
    // 0 = 3n^2 - 2n - p
    // n = () / 6
    // n = () / 6
    x :=
    return x == math.Floor(x)
}

func canContinue(a int, b int) bool {
    return a % 100 == b / 100
}

func generateCycle(cycle []int, used map[[]int]bool, polygonSets [][]int) []int {
    if len(cycle) == 6 {
        if canContinue(cycle[5], cycle[0]) {
            return cycle
        }
        return [0]int{}
    }
    // TODO: refactor nested loop for better readability
    /*
    for _, s2 := range polygonSets {
        for _, p2 := range s2 {
            if p2 == p1 {
                continue
            }
            if p1 % 100 == p2 / 100 {
                for _, s3 := range polygonSets {
                    if s3 == s2 {
                        continue
                    }
                    for _, p3 := range s3 {
                        if p3 == p1 || p3 == p2 {
                            continue
                        }
                        if p2 % 100 == p3 / 100 {
                            // repeat for following 4 sets
                        }
                    }
                }
            }
        }
    }
    return [0]int{}
    */
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
        triangles, squares, pentagons, hexagons, heptagons
    }
    res := 0
    
    // start with smallest set
    for _, oct := range octagons {
        orderedSet := generateCycles(oct, polygons)
        
        if len(orderedSet) == 6 {
            sum := 0
            for _, p := range orderedSet {
                sum += p
            }
            res = sum
            break
        }
    }
    fmt.Println(res)
}
