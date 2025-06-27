function sumMultiples(x: number, n: number): number {
    // number of multiples of x below n, k
    let multiples: number = Math.floor((n - 1) / x);
    // sum of multiples x + 2x + 3x + ... + kx
    // x * (1 + 2 + 3 + ... + k) = x * (k * (k + 1) / 2)
    let sumCoeffs = multiples * (multiples + 1) / 2;
    return x * sumCoeffs;
}

console.log(sumMultiples(3, 1000) + sumMultiples(5, 1000) - sumMultiples(15, 1000));
