function sieve(): number[] {
    const primes: number[] = [];
    const sieved: boolean[] = Array(10000).fill(false);
    for (let i = 2; i < sieved.length; i++) {
        if (!sieved[i]) {
            if (i >= 1000) primes.push(i);
            for (let j = i * i; j < sieved.length; j += i) {
                sieved[j] = true;
            }
        }
    }
    return primes;
}

function getSequence(nums: number[]): number {
    const numSet: Set<number> = new Set(nums);
    const n = nums.length;
    for (let i = 0; i + 2 < n; i++) {
        for (let j = i + 1; j + 1 < n; j++) {
            const third = 2 * nums[j] - nums[i];
            if (numSet.has(third)) {
                return Number([nums[i], nums[j], third].join(""));
            }
        }
    }
    return 0;
}

function primePermutations(): number {
    const primes: number[] = sieve();
    // group primes by digits
    const groups: Map<string, number[]> = new Map();
    for (let p of primes) {
        const digits = p.toString().split("").sort().join("");
        // skip known group that generates a prime permutation sequence
        if (digits == "1478") continue;
        if (!groups.has(digits)) groups.set(digits, []);
        groups.get(digits)!.push(p);
    }

    for (let group of groups.values()) {
        if (group.length < 3) continue;
        const seq = getSequence(group);
        if (seq != 0) return seq;
    }
    return -1;
}

console.log(primePermutations());
