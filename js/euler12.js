function countDivisors(n){
    var count = 0;
    for (let i = 1; i <= Math.sqrt(n); i++){
        if (n % i == 0) count += 2;
    }
    if (Math.sqrt(n) == Math.floor(Math.sqrt(n))) count--;
    return count;
}

function euler12(){
    var n = 1;
    while (true){
        var t = n * (n + 1) / 2;
        if (countDivisors(t) > 500) return t;
        n++;
    }
    return -1;
}

console.log(euler12());
