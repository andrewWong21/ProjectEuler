function distinctPrimesFactors(): number {
    const limit = 150_000;
    const factors = new Array(limit + 1).fill(0);
    for (let i = 2; i <= limit; i++) {
        if (factors[i] == 0) {
            for (let j = i; j <= limit; j += i) {
                factors[j]++;
            }
        }
    }

    let streak: number = 0;
    for (let n = 2; n < limit; n++) {
        if (factors[n] == 4) {
            streak++;
            if (streak == 4) return n - 3;
        }
        else streak = 0;
    }
    return -1;
}

console.log(distinctPrimesFactors());
