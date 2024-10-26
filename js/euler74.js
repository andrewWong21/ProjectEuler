function euler74(){
    const factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880];
    let count = 0;
    for (let i = 1; i < 1_000_000; i++){
        const seen = new Set();
        let n = i;
        while (!seen.has(n)){
            seen.add(n);
            let sum = 0;
            while (n > 0){
                sum += factorials[n % 10];
                n = Math.floor(n / 10);
            }
            n = sum;
        }
        if (seen.size == 60) count++;
    }
    return count;
}

console.log(euler74());
