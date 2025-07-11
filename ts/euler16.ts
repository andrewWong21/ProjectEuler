function powerDigitSum(): number {
    let pow: bigint = 2n ** 1000n;
    let res: number = 0;
    for (let c of pow.toString()) {
        res += Number(c);
    }
    return res;
}

console.log(powerDigitSum());
