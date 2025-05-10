package main
import "fmt"

type Hand struct {
    
}

func evaluateHand(handStr string) Hand {
    return Hand{}
}

func compareHands(h1 Hand, h2 Hand) bool {
    return true
}

func main() {
    res := 0
    games := []string{
        "8C TS KC 9H 4S 7D 2S 5D 3S AC",
        "5C AD 5D AC 9C 7C 5H 8D TD KS",
        "3H 7H 6S KC JS QH TD JC 2D 8S",
        "TH 8H 5C QS TC 9H 4D JC KS JS",
        "7C 5H KC QH JD AS KH 4C AD 4S",
    }
    for _, game := range games {
        h1 := evaluateHand(game[:5])
        h2 := evaluateHand(game[5:])
        fmt.Println(h1)
        fmt.Println(h2)
    }
    fmt.Println(res)
}
