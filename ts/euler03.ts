function maxPrimeFactor(n: number): number {
    let factor: number = 2, lastFactor: number = 0;
    // divide n by increasing prime factors
    // until n is an odd number that cannot be a multiple 
    // of factor or any of its subsequent values
    while (factor * factor <= n) {
        if (n % factor == 0){
            lastFactor = factor;
            n /= factor;
        }
        else {
            // move to next odd for checking
            // even if next odd is composite,
            // its prime factors will already be divided out
            factor = (factor == 2) ? 3 : factor + 2;
        }
    }
    
    // n is the largest prime factor if not reduced to 1
    // else lastFactor is the largest prime factor of n
    return n > 1 ? n : lastFactor;
}

console.log(maxPrimeFactor(600851475143));
