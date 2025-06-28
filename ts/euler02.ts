function evenFib(n: number): number {
    let f1: number = 0, f2: number = 1;
    let res: number = 0;
    while (f2 < n) {
        if (f2 % 2 == 0) res += f2;
        let temp: number = f1;
        f1 = f2;
        f2 += temp;
    }
    return res;
}

console.log(evenFib(4_000_000));
