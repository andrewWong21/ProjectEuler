function euler29(){
    var seen = new Set();
    for (let a = 2; a <= 100; a++){
        for (let b = 2; b <= 100; b++){
            seen.add(Math.pow(a, b));
        }
    }
    return seen.size;
}

console.log(euler29());
