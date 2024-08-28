function euler15(n){
    // number of routes in nxn grid: (2n) choose n 
    // (2n)C(n) = (2 * n)! / (n! * (2n - n)!) (2 * n)! / (n! * n!)
    //  = (2 * n) * (2 * n - 1) * ... * (n + 1) / (n!)
    // potential for overflows or precision errors during computation
    // current solution - alternate multiplication and division, works for given grid size
    // but encounters precision errors with larger sizes starting at around 29
    // decomposition into prime factors may be a feasible approach
    var res = 1;
    for (let i = n + 1; i <= 2 * n; i++){
        res *= i;
        res /= i - n;
    }
    return res;
}

console.log(euler15(20));
