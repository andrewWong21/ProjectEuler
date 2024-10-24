function euler72(){
    let n = 1_000_000;
    // initialize totient(n) as n
    var totients = [...Array(n + 1).keys()];
    var res = 0;
    for (let i = 2; i <= n; i++){
        if (totients[i] == i){ // i is prime
            // update totients of all multiples of i
            for (let j = i; j <= n; j += i){
                // totient(n) = n * P((p - 1) / p) for all prime factors p of n
                totients[j] *= (i - 1) / i;
            }
        }
        res += totients[i];
    }
    return res;
}

console.log(euler72());
