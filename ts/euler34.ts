function factSum(n: number): number {
    let res: number = 0;
    const factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880];
    while (n > 0) {
        res += factorials[n % 10];
        n = Math.floor(n / 10);
    }
    return res;
}

function digitFactorials(): number {
    let d: number = 1;
    while (d * 362880 >= 10 ** d - 1)  d++;
    let res: number = 0;
    for (let i: number = 3; i <= d * 362880; i++) {
        if (factSum(i) == i) res += i;
    }
    return res;
}

console.log(digitFactorials());
