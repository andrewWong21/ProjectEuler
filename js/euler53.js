function euler53(){
    var res = 0;
    for (let n = 10; n <= 100; n++){
        let ncr = n;
        // nC1 = n
        // nC2 = (n^2 - n) / 2 = n * (n - 1) / 2
        // nC3 = (n^3 - 3n^2 + 2n) = n * (n - 1) / 2 * (n - 2) / 3
		// nCr = nC(r - 1) * (n - r + 1) / r
        for (let r = 2; r <= n / 2; r++){
            ncr *= (n - r + 1) / r;
            if (ncr > 1_000_000){
                // n choose r = n choose (n - r)
                // [r, n - r] = [r + 0, r + n - 2r]
                // [r, n - r] has n - 2r + 1 values
                res += n - 2 * r + 1;
                break;
            }
        }
    }
    return res;
}

console.log(euler53());
