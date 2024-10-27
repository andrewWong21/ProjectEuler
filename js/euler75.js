function euler75(){
    const perims = new Array(1_500_001).fill(0);
    for (let m = 2; m * m < 1_500_000; m++){
        for (let n = 1; n < m; n++){
            if (gcd(m, n) != 1) continue;
            let a = m * m - n * n;
            let b = 2 * m * n;
            if (b < a) continue;
            let c = m * m + n * n;
            
            let perim = a + b + c;
            if (m % 2 == 1 && n % 2 == 1) perim /= 2;
            for (let k = 1; k * perim < perims.length; k++){
                perims[k * perim]++;
            }
        }
    }
    let count = 0;
    for (let p of perims){
        if (p == 1) count++;
    }
    return count;
}

function gcd(a, b){
    while (b != 0){
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

console.log(euler75());
