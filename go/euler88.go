package main
import "fmt"

func main() {
    maxK := 12000
    // store minimum product-sum numbers for sets of size k
    minPSNs := make([]int, maxK + 1)
    // maximum product-sum number for set of size k is 2*k
    // k * 2 * 1^(k - 2) = k + 2 + 1 * (k - 2)
    
    // store factorizations of numbers up to 2*k
    factLists := [][][]int{}
    // dummy lists for 0 and 1
    factLists = append(factLists, [][]int{})
    factLists = append(factLists, [][]int{})
    
    for n := 2; n <= 2 * maxK; n++ {
        // generate factorizations of n
        facts := [][]int{}
        // add single-number factorization
        facts = append(facts, []int{n})
        
        // iterate over potential factors of n
        for f := 2; f * f <= n; f++ {
            if n % f == 0 {
                for _, factList := range factLists[n / f] {
                    if f <= factList[0] {
                        newFactList := append([]int{f}, factList...)
                        facts = append(facts, newFactList)
                    }
                }
            }
        }
        factLists = append(factLists, facts)
    }
    
    for n := 2; n < len(factLists); n++ {
        for _, factList := range factLists[n] {
            if len(factList) < 2 {
                continue
            }
            sum := 0
            for _, fact := range factList {
                sum += fact
            }
            // pad factor sum with 1s to create a set of k numbers
            // that also multiply to n
            if sum <= n {
                // number of 1s required to pad sum
                k := len(factList) + n - sum
                // n is guaranteed to be minimal PSN for k numbers
                if k <= maxK && minPSNs[k] == 0 {
                    minPSNs[k] = n
                }
            }
        }
    }
    
    productSums := make(map[int]bool)
    for k := 2; k < len(minPSNs); k++ {
        productSums[minPSNs[k]] = true
    }
    
    res := 0
    for prodSum := range productSums {
        res += prodSum
    }
    fmt.Println(res)
}
