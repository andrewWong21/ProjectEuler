function euler34(){
    var factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880];
    var res = 0;
    // maximum factorial digit sum for d-digit number: d * 9!
    // minimum value of d-digit number: 10^(d - 1)
    // 9! * d < 10^(d - 1)
    // inequality is true when d > 7 (d cannot be negative)
    // check numbers up to 7 * 9! = 2540160
    for (let n = 10; n < 7 * factorials[9]; n++){
        let num = n, sum = 0;
        while (num > 0){
            let d = num % 10;
            sum += factorials[d];
            num = (num - d) / 10;
        }
        if (sum == n) res += n;
    }
    return res;
}

console.log(euler34());
