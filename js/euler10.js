function euler10(){
    var sieved = new Array(2_000_001).fill(false);
    var total = 0;
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            total += i;
        }
    }
    return total;
}

console.log(euler10());
