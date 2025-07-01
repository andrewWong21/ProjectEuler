function gcd(a: number, b: number): number {
    // Euclidean algorithm for finding
    // greatest common divisor of a, b
    while (b > 0) {
        [a, b] = [b, a % b];
    }
    return a;
}

function lcm(a: number, b: number): number {
    // least common multiple of (a, b) is (a * b) / gcd(a, b)
    return a / gcd(a, b) * b;
}

function smallestMultiple(n: number): number {
    let res: number = 1;
    for (let i: number = 2; i <= n; i++) {
        res = lcm(res, i);
    }
    return res;
}

console.log(smallestMultiple(20));
