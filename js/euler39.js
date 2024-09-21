function euler39(){
    var solutions = new Array(1001).fill(0);
    var res = 0, count = 0;
    // a + b + c = p, c = p - a - b
    // a^2 + b^2 = c^2, a^2 + b^2 = (p - a - b)^2

    // a^2 + b^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
    // a^2 + b^2 = a^2 + b^2 + p^2 - 2ap - 2bp + 2ab
    // 0 = p^2 - 2ap - 2bp + 2ab
    // 2bp - 2ab = p^2 - 2ap
    // b(2p - 2a) = p^2 - 2ap
    // b = (p^2 - 2ap) / (2p - 2a)
    // since a, b, c are integers, (p^2 - 2ap) must be evenly divisible by (2p - 2a)
    // p^2 - 2ap = p(p - 2a) > 0, so 1 <= a < p/2

    for (let p = 1; p <= 1000; p++){
        for (let a = 1; a < p / 2; a++){
            // check that b is an integer
            if ((p * p - 2 * a * p) % (2 * p - 2 * a) == 0){
                let b = (p * p - 2 * a * p) / (2 * p - 2 * a);
                // avoid double-counting solutions by specifying a < b < c (does not affect result)
                if (b < a) continue;
                // increment solution count for given p
                // and update res if new p with maximum number of solutions is found
                if (++solutions[p] > count){
                    res = p;
                    count = solutions[p];
                }
            }
        }
    }
    return res;
}

console.log(euler39());
