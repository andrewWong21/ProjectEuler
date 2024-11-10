function euler88(){
    const maxK = 12_000;
    const minProdSumNums = new Array(maxK).fill(0);
    // store lists of factorizations for each integer
    const factGroups = new Array(2 * maxK + 1).fill().map(() => []);
    for (let idx = 2; idx <= 2 * maxK; idx++){
        const factorizations = [[idx]];
        // iterate over potential factors of idx
        for (let f = 2; f <= Math.ceil(Math.sqrt(idx)); f++){
            if (idx % f == 0){
                for (let group of factGroups[idx / f]){
                    // if f <= smallest factor in factorization of idx / f,
                    // then f is prependable to the factorization
                    if (f <= Math.min(...group)){
                        // add new factorization of idx to list
                        factorizations.push([f, ...group]);
                    }
                }
            }
        }
        // all factorizations of idx found
        factGroups[idx] = factorizations;
    }
    for (let n = 2; n < factGroups.length; n++){
        for (let group of factGroups[n]){
            if (group.length < 2) continue;
            let sum = group.reduce((a, b) => a + b, 0);
            // sum less than n can be padded with ones to maintain a product of n
            if (sum <= n){
                // difference of n and sum is number of 1s needed to pad sum
                const k = n - sum + group.length;
                // n is the minimum product-sum number for a set of k numbers
                if (k < maxK && minProdSumNums[k] == 0) minProdSumNums[k] = n;
            }
        }
    }
    let seen = new Set();
    let res = 0;
    for (let psn of minProdSumNums){
        if (!seen.has(psn)){
            res += psn;
            seen.add(psn);
        }
    }
    return res;
}

console.log(euler88());
