function properDivisorSum(n: number): number {
    let res: number = 1;
    for (let i: number = 2; i * i <= n; i++){
        if (n % i == 0){
            res += i;
            if (n / i != i) {
                res += n / i;
            }
        }
    }
    return res;
}

function amicableNumbers(n: number): number {
    let res: number = 0;
    const divSumCache: number[] = Array(n).fill(0);
    for (let i: number = 2; i < n; i++) {
        if (divSumCache[i] == 0) divSumCache[i] = properDivisorSum(i);
        let pair = divSumCache[i];
        if (divSumCache[pair] == 0) divSumCache[pair] = properDivisorSum(pair);
        if (i < pair && divSumCache[pair] == i) {
            res += i + pair;
        }
    }
    return res;
}

console.log(amicableNumbers(10000));
