function champernownesConstant(): number {
    let starts: number[] = [0, 1, 10, 190, 2890, 38890, 488890, 5888890];
    let res: number = 1;
    for (let pos = 1; pos <= 1_000_000; pos *= 10) {
        // get number of group containing pos, # of digits in each number in the group
        let digits = starts.length - 1;
        while (pos < starts[digits]) digits--;
        let start = starts[digits];
        // get number in group containing pos
        let k = Math.floor((pos - start) / digits);
        let n = 10 ** (digits - 1) + k;
        // get corresponding digit of number in group containing pos
        let digitPos = (pos - start) % digits;
        let digit = n.toString().charAt(digitPos);
        res *= +digit;
    }
    return res;
}

console.log(champernownesConstant());
