function euler25(){
    var n1 = 0n, n2 = 1n, count = 1;
    while (String(n2).length < 1000){
        let temp = n1;
        n1 = n2, n2 += temp;
        count++;
    }
    return count;
}

console.log(euler25());
