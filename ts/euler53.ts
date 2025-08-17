function combinatoricSelections(): number {
    let res: number = 0;
    for (let n: number = 23; n <= 100; n++) {
        let curr: number = n;
        for (let r: number = 2; r <= n; r++) {
            curr = curr * (n - r + 1) / r;
            if (curr > 1_000_000) {
                // (n - r) - r + 1 numbers in range [r, n - r]
                // console.log(n, r, curr);
                res += n - 2 * r + 1; 
                break;
            }
        }
    }
    return res;
}

console.log(combinatoricSelections());
