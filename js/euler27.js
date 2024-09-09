function euler27(){
    var product = 0;
    // n^2 + an + b generates primes starting from n = 0
    // therefore, b must be a prime number
    var sieved = new Array(1000).fill(false);
    var primes = new Set();
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            primes.add(i);
        }
    }
    
    var res = 0, maxLen = 0;
    for (let a = -999; a < 1000; a++){
        for (let b of primes){
            var n = 0;
            while (true){
                let val = n * n + a * n + b;
                if (val > 1000 && isPrime(val) || primes.has(val)) n++;
                else break;
            }
            // update with n - 1, as n is first input that results in non-prime output
            if (n - 1 > maxLen){
                maxLen = n - 1;
                res = a * b;
            }
        }
    }
    
    return res;
}

function isPrime(n){
    for (let i = 2; i <= Math.sqrt(n); i++){
        if (n % i == 0) return false;
    }
    return true;
}

console.log(euler27());
