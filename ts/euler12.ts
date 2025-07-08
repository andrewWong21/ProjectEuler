function sieve(n: number): number[] {
    let sieved: boolean[] = new Array(n + 1);
    let primes: number[] = [];
    for (let i: number = 2; i <= n; i++){
        if (!sieved[i]){
            primes.push(i);
            for (let j: number = i * i; j <= n; j += i){
                sieved[j] = true;
            }
        }
    }
    return primes;
}

function countDivisors(n: number, primes: number[]): number {
    let count: number = 1;
    for (let p of primes){
        if (p * p > n) break;
        let exp = 0;
        while (n % p == 0) {
            n /= p;
            exp++;
        }
        count *= (exp + 1);
    }
    if (n > 1) count *= 2;
    return count;
}

function highlyDivisibleTriangularNumber(): number {
    let n: number = 1;
    let primes: number[] = sieve(1000);
    while (true) {
        let a: number, b: number;
        let divs: number = 0;
        // nth triangle number = n * (n + 1) / 2
        // n is the product of two coprime numbers a, b
        if (n % 2 == 0){
            a = n / 2;
            b = n + 1;
        }
        else {
            a = n;
            b = (n + 1) / 2;
        }
        // number of divisors of a number n is equal to
        // the product of the number of divisors of a and b
        divs = countDivisors(a, primes) * countDivisors(b, primes);
        if (divs > 500) return a * b;
        n++;
    }
}

console.log(highlyDivisibleTriangularNumber());
