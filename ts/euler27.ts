function sieve(): number[] {
    const primes: number[] = [];
    const sieved: boolean[] = new Array(1000).fill(false);
    for (let i: number = 2; i < sieved.length; i++) {
        if (!sieved[i]) {
            primes.push(i);
            for (let j: number = i * i; j < sieved.length; j += i) {
                sieved[j] = true;
            }
        }
    }
    return primes;
}

function isPrime(n: number): boolean {
    if (n == 2) return true;
    if (n < 2 || n % 2 == 0) return false;
    for (let i: number = 3; i * i <= n; i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

function consecutivePrimes(a: number, b: number): number {
    for (let n: number = 0;; n++) {
        if (!isPrime(n * n + a * n + b)) return n;
    }
}

function quadraticPrimes(): number {
    // generating primes with n^2 + an + b
    // starting with n = 0: b must be prime
    let res: number = 0, maxPrimes = 0;
    let primes: number[] = sieve();
    for (let b of primes) {
        for (let a: number = -999; a < 1000; a++) {
            let streak: number = consecutivePrimes(a, b);
            if (streak > maxPrimes) {
                maxPrimes = streak;
                res = a * b;
            }
        }
    }
    return res;
}

console.log(quadraticPrimes());
