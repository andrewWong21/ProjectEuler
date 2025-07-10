function longestCollatzSequence(): number {
    const cache: Map<number, number> = new Map();
    cache.set(1, 1);
    let res: number = 0, maxLen: number = 0;

    for (let i: number = 2; i < 1_000_000; i++) {
        let n: number = i, len: number = 0;
        while (n != 1 && !cache.has(n)) {
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
            len++;
        }
        len += cache.get(n) ?? 0;
        cache.set(i, len);

        if (len > maxLen){
            maxLen = len;
            res = i;
        }
    }
    return res;
}

console.log(longestCollatzSequence());
