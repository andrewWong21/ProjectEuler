var primes = new Set();

function euler50(){
    var sieved = new Array(1000000).fill(false);
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            primes.add(i);
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
        }
    }
    for (let prime of primes){
        if (replace(prime) != null) return prime;
    }
    return 0;
}

function replace(n){
    let digits = n.toString().split('').reverse().map(Number);
    // replace 0, 1, or 2 so at least 8 replacements can be made
    for (let d = 0; d < 3; d++){
        let mask = 0;
        for (let i = 0; i < digits.length; i++){
            if (digits[i] == d) mask += 10 ** i;
        }
        // digit not found
        if (mask == 0) continue;
        // prime is smallest in family
        let size = 1;
        // check if replacing d with d + 1, d + 2, ..., 9
        // results in a prime number
        for (let t = 1; t < 10 - d; t++){
            if (primes.has(n + mask * t)) size++;
        }
        
        // return smallest prime part of family of size 8
        if (size == 8) return n;
    }
    return null;
}

console.log(euler50());
