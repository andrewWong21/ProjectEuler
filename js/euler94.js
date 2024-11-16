function euler94(){
    let maxPerimeter = 1e9;
    let maxSize = Math.ceil(maxPerimeter / 3);
    let perimeterSum = 0;
    let almostEqui = new Set();
    // build Pythagorean triples using Euclid's formula
    // a = m^2 - n^2, b = 2*m*n, c = m^2 + n^2
    for (let m = 1; m * m <= maxSize; m++){
        for (let n = 1; n < m; n++){
            if (gcd(m, n) == 1){
                let a = m * m - n * n, b = 2 * m * n, c = m * m + n * n;
                if (m % 2 == 1 && n % 2 == 1){
                    a /= 2;
                    b /= 2;
                    c /= 2;
                }
                if (2 * (a + c) > maxPerimeter || 2 * (b + c) > maxPerimeter) break;
                let ac = [a, c].toString();
                let bc = [b, c].toString();
                if (Math.abs(c - 2*a) == 1 && !almostEqui.has(ac)){
                    perimeterSum += 2 * (a + c);
                    almostEqui.add(ac);
                }
                if (Math.abs(c - 2*b) == 1 && !almostEqui.has(bc)){
                    perimeterSum += 2 * (b + c);
                    almostEqui.add(bc);
                }
            }
        }
    }
    return perimeterSum;
}

function gcd(a, b){
    while (b > 0){
        let temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

console.log(euler94());
