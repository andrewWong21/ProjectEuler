function getPentagon(n: number): number {
    return (3 * n * n - n) / 2;
}

function isPentagon(x: number): boolean {
    // t = (3n^2 - n) / 2
    // 2t = 3n^2 - n
    // 3n^2 - n - 2t = 0
    // n = (1 + sqrt(1 + 24t)) / 6
    const n = (Math.sqrt(24 * x + 1) + 1) / 6;
    return Number.isInteger(n);
}

function pentagonNumbers(): number {
    // P_n = n * (3 * n - 1) / 2 = (3n^2 - n) / 2
    // D = P_k - P_j, k = j + x
    // D = (3k^2 - k) / 2 - (3j^2 - j) / 2
    // D = (3k^2 - k - 3j^2 + j) / 2
    // D = (3(j + x)^2 - j - x - 3j^2 + j) / 2
    // D = (3j^2 + 6jx + 3x^2 - x - 3j^2) / 2
    // D = (3x^2 + 6jx - x) / 2
    // D = (3x^2 - x) / 2 + 3jx
    // D = P_x + 3jx
    // 3jx = D - P_x

    for (let n = 4; ; n++) {
        const pentD = getPentagon(n);
        for (let x = 1; x < n; x++) {
            const pentX = getPentagon(x);
            if ((pentD - pentX) % (3 * x) != 0) continue;
            
            const j = (pentD - pentX) / (3 * x);
            const pentJ = getPentagon(j);
            const pentK = getPentagon(j + x);
            if (isPentagon(pentJ + pentK)) return pentD;
        }
    }
}

console.log(pentagonNumbers());
