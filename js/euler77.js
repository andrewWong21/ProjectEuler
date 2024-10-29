function euler76(){
    const sieved = new Array(101).fill(false);
    const sums = new Array(101).fill(0);
    
    for (let i = 2; i < 100; i++){
        if (!sieved[i]){
            sums[i]++;
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            for (let n = i + 1; n < sums.length; n++){
                sums[n] += sums[n - i];
            }
        }
    }
    for (let i = 0; i < sums.length; i++){
        if (sums[i] > 5000) return i;
    }
}

console.log(euler76());
