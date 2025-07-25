function distinctPowers(): number {
    let res: Set<string> = new Set();
    for (let a: bigint = 2n; a <= 100n; a++) {
        for (let b: bigint = 2n; b <= 100n; b++) {
            res.add((a ** b).toString());
        }
    }
    return res.size;
}

console.log(distinctPowers());
