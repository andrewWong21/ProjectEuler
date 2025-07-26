function getDigitFifthPowerSum(n: number): number {
    const pows: number[] = [0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049];
    let res: number = 0;
    while (n > 0) {
        res += pows[n % 10];
        n = Math.floor(n / 10);
    }
    return res;
}

function digitFifthPowers(): number {
    let d: number = 0;
    while (59049 * (d + 1) >= 10 ** d) d++;
    let res: number = 0;
    for (let i: number = 2; i <= 59049 * d; i++) {
        if (i == getDigitFifthPowerSum(i)) res += i;
    }
    return res;
}

console.log(digitFifthPowers());
