function euler37(){
    var truncPrimes = new Set();
    // skip single-digit primes (2, 3, 5, 7)
    // primes with at least two digits are odd
    for (let n = 11; truncPrimes.size < 11; n += 2){
        // skip multiples of 5
        if (n % 5 == 0) continue;
        if (isPrime(n) && isLeftTruncatable(n) && isRightTruncatable(n)){
            truncPrimes.add(n);
        }
    }
    var res = 0;
    for (let prime of truncPrimes) res += prime;
    return res;
}

function isPrime(n){
    if (n < 2) return false;
    for (let i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

function isLeftTruncatable(p){
    var str = p.toString();
    while (str.length > 0){
        if (!isPrime(Number(str))) return false;
        // remove leftmost digit
        str = str.substring(1);
    }
    return true;
}

function isRightTruncatable(p){
    while (p > 0){
        if (!isPrime(p)) return false;
        // remove rightmost digit
        p = Math.floor(p / 10);
    }
    return true;

}

console.log(euler37());
