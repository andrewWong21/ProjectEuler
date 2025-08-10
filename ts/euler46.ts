function sieve(n: number): Set<number> {
    const sieved: boolean[] = Array(n + 1).fill(false);
    const primes: number[] = [];
    for (let i = 2; i <= n; i++) {
        if (!sieved[i]) {
            primes.push(i);
            for (let j = i * i; j <= n; j += i) {
                sieved[j] = true;
            }
        }
    }
    return new Set(primes);
}

function goldbachsOtherConjecture(): number {
    // n = p + 2x^2
    // p = n - 2x^2

    const primes = sieve(10000);
    for (let n = 35; n < 10000; n += 2) {
        if (primes.has(n)) continue;
        let isSum = false;
        for (let x = 1; 2 * x * x < n; x++) {
            if (primes.has(n - 2 * x * x)) {
                isSum = true;
                break;
            }
        }
        if (!isSum) return n;
    }
    return 0;
}

console.log(goldbachsOtherConjecture());
