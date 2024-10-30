function euler78(){
    const sums = new Array(60001).fill(0);
    sums[0] = 1;
    
    for (let i = 1; i < sums.length; i++){
        for (let n = i; n < sums.length; n++){
            sums[n] += sums[n - i];
            sums[n] %= 1_000_000;
        }
        if (sums[i] == 0) return i;
    }
}

console.log(euler78());
