function isPrime(n: number): boolean {
    for (let i: number = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

function nthPrime(n: number): number {
    if (n == 1) return 2;
    if (n == 2) return 3;
    let k: number = 1, count: number = 2;
    while (true) {
        if (isPrime(6*k - 1)) count++;
        if (count == n) return 6 * k - 1;
        if (isPrime(6*k + 1)) count++;
        if (count == n) return 6 * k + 1;
        k++;   
    }
}

console.log(nthPrime(10001));
