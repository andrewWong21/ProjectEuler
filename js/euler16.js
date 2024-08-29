function euler16(){
    var str = String(2n ** 1000n);
    var res = 0;
    for (let i = 0; i < str.length; i++){
        res += str.charAt(i) - '0';
    }
    return res;
}

console.log(euler16());
