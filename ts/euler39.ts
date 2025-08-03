function gcd(a: number, b: number) {
    while (b > 0) {
        [a, b] = [b, a % b];
    }
    return a;
}

function integerRightTriangles(): number {
    const MAX_PERIM = 1000;
    const perims: number[] = Array(MAX_PERIM + 1).fill(0);

    for (let m = 2; m * m < MAX_PERIM; m++) {
        for (let n = 1; n < m; n++) {
            if (gcd(m, n) == 1) {
                let a = m * m - n * n;
                let b = 2 * m * n;
                let c = m * m + n * n;
                // only consider triples (a, b, c) where a < b < c
                if (b < a || c < b) continue;
                // ensure primitive triple generation before scaling
                if (m % 2 == 1 && n % 2 == 1) {
                    [a, b, c] = [a / 2, b / 2, c / 2];
                }
                const p = a + b + c;
                for (let k = 1; k * p <= MAX_PERIM; k++) {
                    perims[k * p]++;
                }
            }
        }
    }

    let res: number = 0, count = 0;
    for (let i = 0; i < perims.length; i++) {
        if (perims[i] > count) {
            count = perims[i];
            res = i;
        }
    }
    return res;
}

console.log(integerRightTriangles());
