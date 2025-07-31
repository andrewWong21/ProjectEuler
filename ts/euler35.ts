function filterPrimes(): number[] {
    const sieved: boolean[] = Array(1_000_000).fill(false);
    const primes: number[] = [];
    const digits: Set<string> = new Set<string>(['0', '2', '4', '5', '6', '8']);

    for (let i = 2; i < sieved.length; i++) {
        if (!sieved[i]) {
            for (let j = i * i; j < sieved.length; j += i) {
                sieved[j] = true;
            }
            // if prime has at least 2 digits and contains 5 or an even digit,
            // then it will have at least one digit rotation that is composite
            const str: string = i.toString();
            if (i < 10 || [...str].every(c => !digits.has(c))) {
                primes.push(i);
            }
        }
    }
    return primes;
}

function getRotations(p: number): number[] {
    let s: string = p.toString();
    // avoid counting duplicate rotations
    const res: Set<number> = new Set();
    for (let i = 0; i < s.length; i++) {
        res.add(Number(s));
        s = s.slice(1) + s.charAt(0);
    }
    return [...res];
}

function circularPrimes(): number {
    const primes: number[] = filterPrimes();
    const primeSet: Set<number> = new Set<number>(primes);
    const circularPrimes: Set<number> = new Set<number>();

    for (let p of primes) {
        // skip tracked rotations of circular primes
        if (circularPrimes.has(p)) continue;
        // check if every rotation of p is prime
        const rotations: number[] = getRotations(p);
        if (rotations.every(r => primeSet.has(r))){
            for (const r of rotations) circularPrimes.add(r);
        }
    }
    return circularPrimes.size;
}

console.log(circularPrimes());
