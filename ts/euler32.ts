function isPandigitalProduct(a: number, b: number): boolean {
    const c: number = a * b;
    const s: string = `${a}${b}${c}`;
    if (s.length != 9 || s.includes('0')) return false;
    return new Set(s).size == 9;
}

function pandigitalProducts(): number {
    const products: Set<number> = new Set();
    for (let a = 1; a <= 9; a++) {
        for (let b = 1234; b <= 9876; b++) {
            if (isPandigitalProduct(a, b)) products.add(a * b);
        }
    }
    for (let a = 12; a <= 98; a++) {
        for (let b = 123; b <= 987; b++) {
            if (isPandigitalProduct(a, b)) products.add(a * b);
        }
    }
    let res: number = 0;
    for (let product of products) res += product;
    return res;
}

console.log(pandigitalProducts());
