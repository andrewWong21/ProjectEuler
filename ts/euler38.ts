function isPandigital(s: string): boolean {
    return s.length == 9 && [...s].sort().join("") == "123456789";
}

function pandigitalMultiples(): number {
    let res: number = 1;
    for (let i = 192; i <= 9876; i++) {
        let s: string = "";
        for (let k = 1; s.length < 9; k++) {
            s += (k * i).toString();
        }
        if (isPandigital(s)) {
            res = Math.max(res, +s);
        }
    }
    return res;
}

console.log(pandigitalMultiples());
