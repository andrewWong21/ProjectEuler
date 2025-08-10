function isPentagonal(x: number): boolean {
    const n: number = (Math.sqrt(24 * x + 1) + 1) / 6;
    return Number.isInteger(n);
}

function triangularPentagonalHexagonal(): number {
    // T_n = n * (n + 1) / 2
    // H_n = n * (2n - 1) = 2n / 2 * (2n - 1)
    // T_(2n - 1) = (2n - 1) * (2n) / 2 = n 
    // all hexagonal numbers are also triangular

    // find next tri-pent-hex after H_143
    for (let n: number = 144; ; n++) {
        const hex: number = 2 * n * n - n;
        if (isPentagonal(hex)) return hex;
    }
}

console.log(triangularPentagonalHexagonal());
