function thousandDigitFibNum(): number {
    let f1: bigint = BigInt("1");
    let f2: bigint = BigInt("1");
    let res: number = 2;
    while (f2.toString().length < 1000) {
        [f1, f2] = [f2, f1 + f2];
        res++;
    }
    return res;
}

console.log(thousandDigitFibNum());
