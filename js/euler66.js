function euler66(){
    var maxSolution = 0, resD = 0;
    for (let d = 1; d <= 1_000; d++){
        // no positive integer solutions for x^2 - Dy^2 = 1 when D is square
        if (Math.sqrt(d) == Math.floor(Math.sqrt(d))) continue;
        let solution = getSolution(d);
        // update resD when new largest minimal solution x is found
        if (solution > maxSolution){
            maxSolution = solution;
            resD = d;
        }
    }
    return resD;
}

function getSolution(d){
    // build continued fraction representation of sqrt(d)
    let a0 = Math.floor(Math.sqrt(d));
    let a = a0, b = a, c = 1;
    let cfr = [];
    while (a != 2 * a0){
        c = (d - b * b) / c;
        a = Math.floor((a0 + b) / c);
        b = a * c - b;
        cfr.push(a);
    }
    let num0 = 1n, den0 = 0n, num1 = BigInt(a0), den1 = 1n;
    let count = 0;
    while (true){
        let k = cfr[count % cfr.length];
        let num = num1 * BigInt(k) + num0;
        let den = den1 * BigInt(k) + den0;
        // 
        if (num * num - BigInt(d) * den * den == 1n) return num;
        num0 = num1;
        den0 = den1;
        num1 = num;
        den1 = den;
        count++;
    }
}

console.log(euler66());
