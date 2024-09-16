function euler33(){
    // n/d = (n1 * 10 + n2) / (d1 * 10 + d2)
    
    // = n2 / d2 (first digits match, n1 = d1 = x)
    // d2(x * 10 + n2) = n2(x * 10 + d2)
    // 10*x*d2 + d2*n2 = 10*x*n2 + d2*n2
    // 10*x*d2 - 10*x*n2 = 0
    // x(d2 - n2) = 0
    // x = 0 results in n and d being less than 10
    // d2 = n2 results in n = d (fraction is equal to 1)
    
    // = n1 / d1 (second digits match, n2 = d2 = x)
    // d1(n1 * 10 + x) = n1(d1 * 10 + x)
    // 10*d1*n1 + d1*x = 10*d1*n1 = n1*x
    // x(d1 - n1) = 0
    // x = 0 results in n and d being divisible by 10 (trivial DCF)
    // d1 = n1 results in n = d (fraction is equal to 1)
    
    // first digit of one number must match second digit of other number
    var numProduct = 1, denProduct = 1;
    for (let n = 11; n < 99; n++){
        // if both digits of n are the same,
        // any digit matches in d will result in above undesirable situations
        if (n % 11 == 0) continue;
        // proper fraction, n < d
        for (let d = n + 1; d <= 99; d++){
            // first digit of numerator matches second digit of denominator
            if (n % 10 == Math.floor(d / 10)){
                let n1 = Math.floor(n / 10), d2 = d % 10;
                if (n1 / d2 == n / d){
                    numProduct *= n1;
                    denProduct *= d2;
                }
            }
            // second digit of numerator matches first digit of denominator
            // (no digit-cancelling fractions are found with this check)
            if (d % 10 == Math.floor(n / 10)){
                let d1 = Math.floor(d / 10), n2 = n % 10;
                if (n2 / d1 == n / d){
                    numProduct *= n1;
                    denProduct *= d2;
                }
            }
        }
        
    }
    return denProduct / gcf(denProduct, numProduct);
}

function gcf(a, b){
    while (b > 0){
        let temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

console.log(euler33());
