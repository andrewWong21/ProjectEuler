function euler21(){
    var res = 0;
    for (let i = 1; i < 10_000; i++){
        let d = sumProperDivisors(i);
        if (i != d && sumProperDivisors(d) == i) res += i;
    }
    return res;
}

function sumProperDivisors(n){
    var sum = 0;
    for (let i = 1; i <= Math.sqrt(n); i++){
        if (n % i == 0) sum += i + (n / i);
    }
    // if n is a perfect square, only add its root once
    if (Math.sqrt(n) == Math.floor(Math.sqrt(n))) sum -= Math.sqrt(n);
    // proper divisors of n are strictly less than n
    return sum - n;
}

console.log(euler21());
