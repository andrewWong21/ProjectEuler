function euler80(){
    let res = 0;
    for (let i = 2; i < 100; i++){
        let s = Math.sqrt(i);
        if (s == Math.floor(s)) continue;
        for (let d of getSqrtDigits(i, 100)){
            res += Number(d);
        }
    }
    return res;
}

function getSqrtDigits(n, d){
    // Calculating digits of square roots by integer subtraction
    // http://www.afjarvis.org.uk/maths/jarvisspec02.pdf
    let a = 5n * BigInt(n), b = 5n;
    while (b.toString().length < d + 2){
        if (a >= b){
            a -= b;
            b += 10n;
        }
        else{
            a *= 100n;
            let bStr = b.toString();
            b = BigInt(bStr.substring(0, bStr.length - 1)) * 100n + 5n;
        }
    }
    return b.toString().substring(0, 100);
}

console.log(euler80());
