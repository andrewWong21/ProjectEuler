function sieve(limit: number = 1_000_000): number[] {
    const sieved: boolean[] = Array(limit).fill(false);
    const primes: number[] = [];
    for (let i = 2; i < limit; i++) {
        if (!sieved[i]) {
            primes.push(i);
            for (let j = i * i; j < limit; j += i) {
                sieved[j] = true;
            }
        }
    }
    return primes;
}

function getDigitsReversed(n: number): number[] {
    const res: number[] = [];
    while (n > 0) {
        res.push(n % 10);
        n = Math.floor(n / 10);
    }
    return res;
}

function isEightPrimeFamilyMin(p: number, primes: Set<number>): boolean {
    // iterate over digits of p from smallest place to largest
    const digits = getDigitsReversed(p);

    // replace only digits 0, 1, 2 to allow for prime family of size 8
    // where the current prime is the smallest prime in the family
    for (let d = 0; d <= 2; d++) {
        let mask = 0, replaced = 0;
        for (let i = 0; i < digits.length; i++) {
            if (digits[i] == d){
                mask += 10 ** i;
                replaced++;
            }
        }
        // must replace some number of digits congruent to 0 mod 3,
        // else at least 3 post-replacement numbers will be divisible by 3
        if (mask == 0 || replaced % 3 != 0) continue;
        // keep track of prime family size, starting with p
        let size = 1;
        for (let t = 1; t < 10 - d; t++) {
            if (primes.has(p + t * mask)) size++;
        }
        if (size == 8) return true;
    }
    return false;
}

function primeDigitReplacements(): number {
    const primes = sieve();
    const primesSet = new Set(primes);
    for (let p of primes) {
        if (isEightPrimeFamilyMin(p, primesSet)) return p;
    }
    return -1;
}

console.log(primeDigitReplacements());
