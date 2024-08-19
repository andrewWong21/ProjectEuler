function euler06(){
    var squaredSum = (100 * 101 / 2) ** 2;
    var sumSquares = 0;
    for (let i = 1; i <= 100; i++){
        sumSquares += i ** 2;
    }
    return squaredSum - sumSquares;
}

console.log(euler06());
