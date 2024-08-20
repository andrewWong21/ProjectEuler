function euler07(){
    var sieved = Array(110000).fill(false);
    var count = 0;
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            for (let j = 2*i; j < sieved.length; j += i){
                sieved[j] = true;
            }
            if (++count == 10001) return i;
        }
    }
    return -1;
}

console.log(euler07());
