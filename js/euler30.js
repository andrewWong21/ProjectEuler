function euler30(){
    // maximum sum of digit fifth powers of an d-digit number is d * 9^5
    // minimum value of an d-digit number is 10^(d -1)
    // stop checking when n * 9^5 < 10^(n - 1), or 59049d < 10^(d - 1)
    // inequality is true when d is at least 7 (d must be a non-negative integer)
    // check numbers with at most 6 digits
    
    var res = 0, powers = [0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049];
    // 1 = 1^5 is not a sum of fifth powers, not included
    for (let n = 2; n < 1_000_000; n++){
        let total = 0, num = n;
        while (num > 0){
            let d = num % 10;
            total += powers[d];
            num = (num - d) / 10;
        }
        if (total == n){
            res += n;
        }
    }
    return res;
}

console.log(euler30());
