function sieve(): number[] {
    const primes: number[] = [];
    const sieved = Array(1_000_000).fill(false);
    for (let i = 2; i < sieved.length; i++) {
        if (!sieved[i]) {
            primes.push(i);
            for (let j = i * i; j < sieved.length; j += i) {
                sieved[j] = true;
            }
        }
    }
    return primes;
}

function consecutivePrimeSum(): number {
    const primes = sieve();
    const primesSet = new Set(primes);
    const prefixSums = [0];
    let curr = 0;
    for (let prime of primes) {
        curr += prime;
        if (curr > 1_000_000) break;
        prefixSums.push(curr);
    }
    const n = prefixSums.length;
    // number of primes in sum
    for (let length = prefixSums.length - 1; length >= 0; length--) {
        // last index of prime counted in sum
        for (let end = n - 1; end - length >= 0; end--){
            // first prime sum found is guaranteed to be largest
            const sum = prefixSums[end] - prefixSums[end - length];
            if (primesSet.has(sum)) return sum;
        }
    }
    return -1;
}

console.log(consecutivePrimeSum());
