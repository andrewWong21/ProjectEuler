function diffSum(n: number): number {
    let sum: number = n * (n + 1) / 2;
    let sumSquares: number = n * (n + 1) * (2 * n + 1) / 6;
    return sum * sum - sumSquares;
}

console.log(diffSum(100));
