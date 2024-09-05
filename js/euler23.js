function euler23(){
    var abNums = new Set();
    var res = 0;
    for (let n = 1; n < 28124; n++){
        // n is an abundant number if it is
        // smaller than the sum of its proper divisors
        if (sumPropDiv(n) > n) abNums.add(n);
        // check that n cannot be written as a sum of two abundant numbers
        if (!isAbSum(n, abNums)) res += n;
    }
    return res;
}

function sumPropDiv(n){
    var res = 0;
    for (let i = 1; i <= Math.sqrt(n); i++){
        if (n % i == 0) res += i + (n / i);
    }
    if (Math.floor(Math.sqrt(n)) == Math.sqrt(n)) res -= Math.sqrt(n);
    return res - n;
}

function isAbSum(n, nums){
    // nums contains all abundant numbers <= n
    for (let num of nums){
        if (nums.has(n - num)) return true;
    }
    return false;
}

console.log(euler23());
