function properDivisorSum(n: number): number {
    let res: number = 1;
    for (let i: number = 2; i * i <= n; i++) {
        if (n % i == 0) {
            res += i;
            if (n / i != i) {
                res += n / i;
            }
        }
    }
    return res;
}

function nonAbundantSums(): number {
    let n: number = 28123;
    // precompute sum of all numbers up to 28123
    let res: number = n * (n + 1) / 2;
    let abNums: Set<number> = new Set<number>();
    for (let i: number = 12; i <= 28123; i++) {
        // check if i is an abundant number
        if (properDivisorSum(i) > i) abNums.add(i);
        // check if i is a sum of two abundant numbers
        for (let abNum of abNums) {
            // i is an abundant sum, subtract from total
            if (abNums.has(i - abNum)) {
                res -= i;
                break;
            }
        }
    }
    return res;
}

console.log(nonAbundantSums());
