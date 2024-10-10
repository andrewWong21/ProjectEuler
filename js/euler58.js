function euler58(){
    // 3, 5, 7, 13, 17, 31, 37, 43
    // 8 primes out of 13 numbers on diagonals of 7x7 square spiral
    var side = 7;
    var primes = 8;
    // continue while primes make up at least 10% of numbers on diagonals
    while ((2 * side - 1) < 10 * primes){
        side += 2;
        // new numbers on corners of square spiral of side length n
        // n^2, n^2 - n + 1, n^2 - 2n + 2, n^2 - 3n + 3
        for (let i = 0; i <= 3; i++){
            if (isPrime(side * side - i * (side - 1))) primes++;
        }
    }
    return side;
}

function isPrime(n){
    for (let i = 2; i * i <= n; i++){
        if (n % i == 0) return false;
    }
    return true;
}

console.log(euler58());
