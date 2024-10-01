function euler50(){
    var primesSet = new Set();
    var sieved = new Array(1000000).fill(false);
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            for (let j = 2*i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            primesSet.add(i);
        }
    }
    var primes = Array.from(primesSet);
    var sum = 0, maxTerms = 0;
    for (let prime of primes){
        if (sum + prime < 1000000){
            sum += prime;
            maxTerms++;
        }
        else break;
    }
    var sums = new Array(maxTerms + 1).fill(0);
    sums[0] = 2;
    for (let i = 1; i <= maxTerms; i++){
        sums[i] = primes[i] + sums[i - 1];
    }
    for (let len = maxTerms; len > 0; len--){
        for (let start = maxTerms - len - 1; start >= 0; start--){
            let sumA = sums[start], sumB = sums[start + len];
            if (primesSet.has(sumB - sumA)) return sumB - sumA;
        }
    }
    return 0;
}

console.log(euler50());
