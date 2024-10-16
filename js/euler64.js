function euler64(){
    var res = 0;
    for (let n = 2; n <= 10_000; n++){
        if (getPeriod(n) % 2 == 1) res++;
    }
    return res;
}

function getPeriod(n){
    // perfect squares have a rational square root with a period of 0
    let sqrtN = Math.sqrt(n);
    if (sqrtN == Math.floor(sqrtN)) return 0;
    // a_0 = floor(sqrt(n))
    // sqrt(n) = a_0 + sqrt(n) - a_0
    // = a_0 + (sqrt(n) - a_0) / 1
    // b_0 = a_0, c_0 = 1
    
    // sqrt(n) = a_0 + 1 / (c_0 / (sqrt(n) - b_0))
    // = a_0 + 1 / ( (c_0 * (sqrt(n) + b_0)) / (n - b_0^2) )
    // = a_0 + 1 / ( (sqrt(n) + b_0) / ((n - b_0^2) / c_0) )
    
    // (sqrt(n) + b_0) / ((n - b_0^2) / c_0) = a_1 + (sqrt(n) - b_1) / c_1
    // c_1 = (n - b_0^2) / c_0
    // a_1 = floor(sqrt(n) + b_0) / c_1)
    // b_1 = a_1 * c_1 - b_0
    let seen = new Map();
    let a0 = Math.floor(sqrtN), a = a0, b = a, c = 1;
    let count = 0;
    while (true){
        let newC = (n - b * b) / c;
        let newA = Math.floor((a0 + b) / newC);
        let newB = newA * newC - b;
        a = newA;
        b = newB;
        c = newC;
        
        let key = [b, c].toString();
        if (seen.has(key)){
            return count - seen.get(key);
        }
        seen.set(key, count);
        count++;
    }
    return 0;
}

console.log(euler64());
