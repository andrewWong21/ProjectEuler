function latticePaths(n: number): number {
    // number of routes to bottom right corner of square nxn grid
    // arrangements of n right movements and n down movements
    // = (2n)! / (n! * n!)
    // = (2n * (2n - 1) * ... * (n + 1)) / n!
    let res: number = 1;
    for (let i: number = 1; i <= n; i++) {
        res = res * (n + i) / i;
    }
    return res;
}

console.log(latticePaths(20));
