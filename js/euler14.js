function euler14(){
    // keep track of starting number with longest chain
    var res = 1;
    var longest = 1;
    for (let i = 1; i < 1_000_000; i++){
        let n = i;
        let chain = 1;
        while (n > 1){
            if (n % 2 == 1){
                n = 3 * n + 1;
            }
            else n /= 2;
            chain++;
        }
        // update number and longest chain if longer chain found
        if (chain > longest){
            longest = chain;
            res = i;
        }
    }
    return res;
}

console.log(euler14());
