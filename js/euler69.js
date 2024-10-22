function euler69(n){
    var sieved = new Array(n + 1);
    var totients = [...Array(n + 1).keys()];
    var maxVal = 0, maxN = 0;
    for (let i = 2; i < n; i++){
        // totient(n) = n * P((p - 1) / p) for all prime factors p of n
        // if n is a prime p, this simplifies to totient(p) = p - 1
        if (!sieved[i]){
            for (let j = i; j < n; j += i){
                sieved[j] = true;
                totients[j] *= (i - 1) / i;
            }
        }
        // totients[i] is fully calculated
        // check if i / totients[i] is greater than current max
        let val = i / totients[i];
        if (val > maxVal){
            maxVal = val;
            maxN = i;
        }
    }
    return maxN;
}

console.log(euler69(1_000_000));
