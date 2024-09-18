function euler35(){
    var sieved = new Array(1_000_000).fill(false);
    var primes = new Set();
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]) {
            primes.add(i);
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
        }
    }
    var res = 0;
    for (let prime of primes){
        var s = new String(prime);
        var isCircular = true;
        for (let i = 0; i < s.length; i++){
            s = s.substring(1) + s.charAt(0);
            if (!primes.has(Number(s))){
                isCircular = false;
                break;
            }
        }
        if (isCircular) res++;
    }
    return res;
}

console.log(euler35());
