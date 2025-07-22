function getCycle(n: number): number {
    const seen: Map<number, number> = new Map<number, number>();
    let rem: number = 1, count: number = 0;
    while (rem != 0) {
        rem = (rem * 10) % n;
        if (seen.has(rem)) return count - seen.get(rem)!;
        seen.set(rem, count++);
    }
    return 0;
}

function reciprocalCycles(): number {
    let res: number = 0, maxLen = 0;
    for (let d: number = 2; d < 1000; d++) {
        let len = getCycle(d);
        if (len > maxLen) {
            [res, maxLen] = [d, len];
        }
    }
    return res;
}

console.log(reciprocalCycles());
