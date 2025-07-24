function numberSpiralDiagonals(): number {
    let res: number = 1;
    for (let n: number = 3; n <= 1001; n += 2){
        res += 4 * n * n - 6 * n + 6;
    }
    return res;
}

console.log(numberSpiralDiagonals());
