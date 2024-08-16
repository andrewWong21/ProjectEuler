function euler03(){
    var sq = Math.round(Math.sqrt(600851475143));
    var sieved = new Array(sq + 1).fill(false);
    var res = 0;
    for (let i = 2; i < sq; i++){
        if (!sieved[i]){
            for (let j = 2 * i; j <= sq; j += i){
                sieved[j] = true;
            }
            if (600851475143 % i == 0){
                res = i;
            }
        }
    }
    return res;
}

console.log(euler03());
