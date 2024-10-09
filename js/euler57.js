function euler57(){
    var num = 1n;
    var den = 1n;
    var res = 0;
	// 1/1, 3/2, 7/5, 17/12, 41/29, ...
    for (let i = 0n; i < 1000n; i++){
        let newNum = 2n * den + num;
        let newDen = den + num;
        num = newNum;
        den = newDen;
		// numerator has more digits than denominator
        if (num.toString().length > den.toString().length) res++;
    }
    return res;
}

console.log(euler57());
