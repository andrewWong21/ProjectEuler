function gcd(a: number, b: number) {
    while (b > 0) {
        [a, b] = [b, a % b];
    }
    return a;
}

function digitCancellingFractions(): number {
    let denProduct: number = 1;
    let numProduct: number = 1;
    for (let n: number = 10; n < 100; n++) {
        if (n % 10 == 0) continue;

        for (let d: number = n + 1; d < 100; d++) {
            if (d % 10 == 0) continue;

            const [n1, n2] = [Math.floor(n / 10), n % 10];
            const [d1, d2] = [Math.floor(d / 10), d % 10];
            // cancel second digit of numerator and first digit of denominator
            if ((n2 == d1) && (n1 * d == d2 * n)) {
                numProduct *= n1;
                denProduct *= d2;
            }
            // cancel first digit of numerator and second digit of denominator
            // no curious fractions are found with this check
            if ((n1 == d2) && (n2 * d == d1 * n)) {
                numProduct *= n2;
                denProduct *= d1;
            }
        }
    }
    return denProduct / gcd(denProduct, numProduct);
}

console.log(digitCancellingFractions());
