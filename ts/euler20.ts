function factorialDigitSum(n: number): number {
    let fact: bigint = BigInt("1");
    for (let i: number = 1; i <= n; i++) {
        fact *= BigInt(i.toString());
    }
    let factStr: string = fact.toString();
    let res: number = 0;
    for (let i: number = 0; i < factStr.length; i++){
        res += Number(factStr[i]);
    }
    return res;
}

console.log(factorialDigitSum(100));
