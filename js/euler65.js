function euler65(){
    var res = 0;
    var num = 2n, prev = 1n;
    var k = 1n;
    for (let i = 1; i < 100; i++){
        // 1, 2, 1, 1, 4, 1, 1, 6, 1, ..., 1, 2k, 1, ...
        let r = (i % 3 == 2) ? 2n * k++ : 1n;
        newNum = num * r + prev;
        prev = num;
        num = newNum;
    }
    for (let c of num.toString()){
        res += Number(c);
    }
    return res;
}

console.log(euler65());
