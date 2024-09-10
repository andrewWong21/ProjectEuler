function euler28(){
    // n = 1: 1
    // increase n by 2 and add four corner values
    // n = 3: 3, 5, 7, 9
    // n = 5: 13, 17, 21, 25
    // for each subsequent value of n, values of the four corners are
    // n^2 - 3n + 3, n^2 - 2n + 2, n^2 - n + 1, n^2
    // total of corners added: 4n^2 - 6n + 6
    var res = 1, n = 3;
    while (n <= 1001){
        res += 4*n*n - 6*n + 6;
        n += 2;
    }
    return res;
}

console.log(euler28());
