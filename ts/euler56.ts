function getDigitSum(n: bigint): number {
    let sum = 0;
    while (n > 0n) {
        sum += Number(n % 10n);
        n /= 10n;
    }
    return sum;
}

function powerfulDigitSum(): number {
    let res: number = 0;
    for (let i = 1n; i < 100n; i++) {
        const pow = i ** i;
        res = Math.max(res, getDigitSum(pow));
    }
    return res;
}

console.log(powerfulDigitSum());
