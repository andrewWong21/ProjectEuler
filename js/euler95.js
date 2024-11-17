function euler95(){
    let minElement = 0, longest = 0;
    for (let i = 1; i < 1e6; i++){
        const seen = new Set();
        let n = i;
        // numbers in chain cannot exceed 1 million
        while (!seen.has(n) && n <= 1e6){
            seen.add(n);
            n = getDivisorSum(n);
        }
        // new longest chain found that returns to starting point
        if (n == i && seen.size > longest){
            longest = seen.size;
            minElement = Math.min(...seen);
        }
    }
    return minElement;
}

function getDivisorSum(n){
    let res = 1;
    let root = Math.sqrt(n);
    for (let i = 2; i <= root; i++){
        if (n % i == 0) res += i + (n / i);
    }
    if (root == Math.floor(root)) res -= root;
    return res;
}

console.log(euler95());
