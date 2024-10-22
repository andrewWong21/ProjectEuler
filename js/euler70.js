function euler70(n){
    var sieved = new Array(n + 1);
    var totients = [...Array(n + 1).keys()];
    var minVal = Number.MAX_VALUE, res = 0;
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
        let val = i / totients[i];
        if (isPermutation(i, totients[i]) && val < minVal){
            minVal = val;
            res = i;
        }
    }
    return res;
}

function isPermutation(a, b){
    let aStr = a.toString().split('').sort().join('');
    let bStr = b.toString().split('').sort().join('');
    return aStr == bStr;
}

console.log(euler70(1e7));
