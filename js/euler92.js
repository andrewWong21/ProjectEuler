function euler92(){
    let count = 0;
    for (let i = 1; i < 1e7; i++){
        let n = i;
        while (n != 89 && n != 1){
            n = getSquareDigitSum(n);
        }
        if (n == 89){
            count++;
        }
    }
    return count;
}

function getSquareDigitSum(n){
    let sum = 0;
    while (n > 0){
        let d = n % 10;
        sum += d * d;
        n = Math.floor(n / 10);
    }
    return sum;
}

console.log(euler92());
