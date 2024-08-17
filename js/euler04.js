function euler04(){
    var res = 0;
    // even palindrome is divisible by 11
    // alternating sum of digits have difference of 0
    for (let i = 902; i <= 999; i += 11){
        for (let j = i; j <= 999; j++){
            let s = String(i * j);
            if (s.split("").reverse().join("") == s && i * j > res){
                res = i * j;
            }
        }
    }
    return res;
}

console.log(euler04());
