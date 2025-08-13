function modPow(base: bigint, exp: bigint, mod: bigint): bigint {
    let res = 1n;
    base %= mod;
    while (exp > 0n) {
        if (exp % 2n == 1n) {
            res = (res * base) % mod;
        }
        base = (base * base) % mod;
        exp /= 2n;
    }
    return res;
}

function selfPowers(): number {
    const MOD = 10n ** 10n;
    let res: bigint = 0n;
    for (let n = 1n; n <= 1000n; n++) {
        res = (res + modPow(n, n, MOD)) % MOD;
    }
    return Number(res);
}

console.log(selfPowers());
