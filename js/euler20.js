function euler20(){
    var fact = 1n;
    for (let i = 2n; i <= 100n; i++){
        fact *= i;
    }
    var res = 0;
    for (let c of fact.toString()){
        res += c - '0';
    }
    return res;
}

console.log(euler20());
