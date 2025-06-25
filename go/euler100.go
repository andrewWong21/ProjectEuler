package main
import "fmt"

func main() {
    // b / (b + r) * (b - 1) / (b + r - 1) = 1 / 2
    // 2 * b * (b - 1) = (b + r) * (b + r - 1)
    // 2b^2 - 2b = b^2 + br - b + br + r^2 - r
    // 2b^2 - 2b = b^2 + r^2 + 2br - b - r
    // b^2 - b = r^2 + 2br - r
    // b^2 - b - r^2 - 2br + r = 0
    // b^2 - (2r + 1) * b - r^2 + r = 0
    // b = (2r + 1 +/- sqrt((2r + 1)^2 - 4 * 1 * (-r^2 + r))) / 2
    // b = (2r + 1 + sqrt(4r^2 + 4r + 1 + 4r^2 - 4r)) / 2
    // b = (2r + 1 + sqrt(8r^2 + 1)) / 2
    // b = r + (1 + sqrt(8r^2 + 1)) / 2
    
    // b is an integer, so sqrt(8r^2 + 1) is an odd integer x
    // x = sqrt(8r^2 + 1), x^2 = 8r^2 + 1
    // x^2 - 8r^2 = 1
    // fundamental solution (x, r) is (3, 1)
    
    // 3/4 * 2/3 = 6/12 = 1/2 (3 blue discs, 1 red disc)
    // 15/21 * 14/20 = 210/420 = 1/2, (15 blue discs, 6 red discs)
    minDiscs, res := int64(1_000_000_000_000), 0
    x_f, r_f := int64(3), int64(1)
    x, r := x_f, r_f
    for res == 0 {
        // recurrence relation
        if x % 2 == 1 {
            b := 1 + ((1 + x) / 2)
            if b + r > minDiscs {
                fmt.Println("res", b)
                break
            }
        }
        xNext := x_f * x + 8 * r_f * r
        rNext := x_f * r + r_f * x
        x, r = xNext, rNext
    }
}
