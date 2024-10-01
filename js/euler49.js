function euler49(){
    var primes = new Set();
    var sieved = new Array(10000).fill(false);
    for (let i = 2; i <= sieved.length; i++){
        if (!sieved[i]){
            for (let j = 2*i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            if (i >= 1000) primes.add(i);
        }
    }
    var map = new Map();
    for (let prime of primes){
        let digits = prime.toString().split('').sort().join('');
        if (digits == "1478") continue;
        if (!map.has(digits)){
            map.set(digits, new Set());
        }
        map.get(digits).add(prime);
    }
    var res = "";
    for (let val of map.values()){
        if (val.size < 3) continue;
        res = getSequence(val);
        if (res != "") break;
    }
    return res;
}

function getSequence(nums){
    let seq = Array.from(nums);
    for (let i = 0; i + 2 < seq.length; i++){
        for (let j = i + 1; j < seq.length; j++){
            let diff = seq[j] - seq[i];
            if (nums.has(seq[i] + 2 * diff)){
                return "" + seq[i] + seq[j] + (seq[i] + 2 * diff);
            }
        }
    }
    return "";
}

console.log(euler49());
