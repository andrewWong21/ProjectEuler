var triangles = new Set();
var squares = new Set();
var pentagons = new Set();
var hexagons = new Set();
var heptagons = new Set();
var octagons = new Set();
var polygonSets = [triangles, squares, pentagons, hexagons, heptagons];

function euler61(){
    // find 4-digit figurate numbers
    for (let n = 1000; n < 10_000; n++){
        if (isTriangle(n)) triangles.add(n);
        if (isSquare(n)) squares.add(n);
        if (isPentagon(n)) pentagons.add(n);
        if (isHexagon(n)) hexagons.add(n);
        if (isHeptagon(n)) heptagons.add(n);
        if (isOctagon(n)) octagons.add(n);
    }
    // cycle can be started from any polygon set
    // start with octagons, as it has the fewest candidates
    for (let octagon of octagons){
        let cycle = generateCycle([octagon], octagon, new Set());
        // calculate sum of completed cycle of 6 numbers
        if (cycle && cycle.length == 6) return cycle.reduce((total, n) => total + n, 0);
    }
}

function generateCycle(cycle, last, used){
    // full cycle of 6 numbers completed
    // last 2 digits of last number is first 2 digits of first number
    if (cycle.length == 6 && last % 100 == Math.floor(cycle[0] / 100)) return cycle;
    for (let s of polygonSets){
        // each polygon set is represented by a different number, may only be used once
        if (used.has(s)) continue;
        used.add(s);
        for (let p of s){
            // cycle can be continued with p
            // 
            if (last % 100 == Math.floor(p / 100)){
                cycle.push(p);
                // if result is not undefined, complete cycle has been found
                if (generateCycle(cycle, p, used)) return cycle;
                // backtrack
                cycle.pop();
            }
        }
        used.delete(s);
    }
}

function isTriangle(p){
    // p = n (n + 1) / 2
    // 0 = n^2 + n - 2p
    // n = (-1 + sqrt(1 + 8p)) / 2
    var n = (Math.sqrt(8*p + 1) - 1) / 2;
    return n == Math.floor(n);
}

function isSquare(p){
    var n = Math.sqrt(p);
    return n == Math.floor(n);
}

function isPentagon(p){
    // p = n * (3n - 1) / 2
    // 0 = 3n^2 - n - 2p
    // n = (1 + sqrt(1 + 24p)) / 6
    var n = (Math.sqrt(24*p + 1) + 1) / 2;
    return n == Math.floor(n);
}

function isHexagon(p){
    // p = n * (2n - 1)
    // 0 = 2n^2 - n - p
    // n = (1 + sqrt(1 + 8p)) / 4
    var n = (Math.sqrt(8*p + 1) + 1) / 4;
    return n == Math.floor(n);
}

function isHeptagon(p){
    // p = n * (5n - 3) / 2
    // 0 = 5n^2 - 3n - 2p
    // n = (3 + sqrt(9 + 40p)) / 10
    var n = (Math.sqrt(40*p + 9) + 3) / 10;
    return n == Math.floor(n);
}
function isOctagon(p){
    // p = n * (3n - 2)
    // 0 = 3n^2 - 2n - p
    // n = (2 + sqrt(4 + 12p)) / 6
    // n = (1 + sqrt(1 + 3p)) / 3
    var n = (Math.sqrt(3*p + 1) + 1) / 3;
    return n == Math.floor(n);
}

console.log(euler61());
