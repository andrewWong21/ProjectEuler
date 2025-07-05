function primeSummation(): number {
    let res: number = 2, len: number = 2000000;
    let sieved: boolean[] = new Array(len).fill(false);
    for (let i: number = 3; i < len; i += 2) {
        if (!sieved[i]) {
            res += i;
            for (let j: number = i * i; j < len; j += i){
                sieved[j] = true;
            }
        }
        
    }
    return res;
}

console.log(primeSummation());
