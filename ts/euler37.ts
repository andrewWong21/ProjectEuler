function sieve(n: number): Set<number> {
    const sieved: boolean[] = Array(n + 1).fill(false);
    const primes: Set<number> = new Set<number>();
    for (let i = 2; i < n; i++) {
        if (!sieved[i]) {
            primes.add(i);
            for (let j = i * i; j < sieved.length; j += i) {
                sieved[j] = true;
            }
        }
    }

    return primes;
}

function isLeftTruncatable(n: number, primes: Set<number>): boolean {
    let s: string = n.toString();
    while (s.length > 0) {
        if (!primes.has(+s)) return false;
        s = s.substring(1);
    }
    return true;
}

function isRightTruncatable(n: number, primes: Set<number>): boolean {
    while (n > 0) {
        if (!primes.has(n)) return false;
        n = Math.floor(n / 10);
    }
    return true;
}

function truncatablePrimes(): number {
    const truncPrimes: number[] = [];
    const primes: Set<number> = sieve(1_000_000);
    for (let p of primes) {
        if (p > 7 && isLeftTruncatable(p, primes) && isRightTruncatable(p, primes)) {
            truncPrimes.push(p);
            if (truncPrimes.length == 11) break;
        }
    }
    return truncPrimes.reduce((sum, curr) => sum + curr, 0);
}

console.log(truncatablePrimes());
