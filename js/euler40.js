function euler40(){
    var res = 1;
    // 1-9                 (9 numbers,         9 digits, positions 1-9)
    // 10-99              (90 numbers,       180 digits, positions 10-189)
    // 100-999           (900 numbers,     2,700 digits, positions 190-2889)
    // 1000-9999       (9,000 numbers,     3,600 digits, positions 2890-38889)
    // 10000-99999    (90,000 numbers,   450,000 digits, positions 38890-488889)
    // 100000-999999 (900,000 numbers, 5,400,000 digits, positions 488890-5888889)
    var starts = [1, 10, 190, 2890, 38890, 488890, 5888890];
    for (let pos of [1, 10, 100, 1000, 10000, 100000, 1000000]){
        // find # of digits in integer with digit at position pos
        let digits = 0;
        while (starts[digits] <= pos) digits += 1;
        // get starting index of group containing integer
        let startPos = starts[digits - 1];
        // number is kth integer in group
        let k = Math.floor((pos - startPos) / digits);
        // find n, value of kth integer
        let n = 10 ** (digits - 1) + k;
        // determine which digit of n pos corresponds to (zero-indexed)
        let digit_pos = pos - (startPos + k * digits);
        let digit = Number(n.toString().charAt(digit_pos));
        res *= digit;
    }
    return res;
}

console.log(euler40());
