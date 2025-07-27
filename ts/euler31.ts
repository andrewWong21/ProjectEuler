function coinSums(): number {
    const sums: number[] = new Array(201).fill(0);
    sums[0] = 1;
    const coins: number[] = [1, 2, 5, 10, 20, 50, 100, 200];
    for (let coin of coins){
        for (let i = coin; i < sums.length; i++){
            sums[i] += sums[i - coin];
        }
    }

    return sums[200];
}

console.log(coinSums());
