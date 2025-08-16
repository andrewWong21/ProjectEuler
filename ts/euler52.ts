function getDigits(n: number): string {
    const digits: number[] = Array(10).fill(0);
    while (n > 0) {
        digits[n % 10]++;
        n = Math.floor(n / 10);
    }
    return digits.join("");
}

function permutedMultiples(): number {
    for (let n = 100_000; n < 10 ** 6 / 6; n++) {
        const digits = getDigits(n);
        let sameDigits: boolean = true;
        for (let k: number = 2; k <= 6; k++) {
            if (getDigits(k * n) != digits) {
                sameDigits = false;
                break;
            }
        }
        if (sameDigits) return n;
    }
    return -1;
}

console.log(permutedMultiples());
