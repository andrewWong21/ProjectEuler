function euler38(){
    var res = 0;
    // 1-9 pandigital string must have 9 digits
    // multiples of 5-digit numbers are at least 5 digits
    // concatenation of first two multiples of a 5-digit number has at least 10 digits
    // consider initial integers with at most 4 digits
    for (let n = 192; n <= 10_000; n++){
        let str = "";
        // concatenate multiples of n until string contains 9 digits
        for (let i = 1; str.length < 9; i++){
            str += n * i;
        }
        if (str.length == 9 && isPandigital(str)){
            res = Math.max(res, Number(str));
        }
    }
    return res;
}

function isPandigital(str){
    // precondition: str has length 9
    var s = new Set(str);
    // str must not contain duplicate digits or 0
    return s.size == str.length && !s.has('0');
}

console.log(euler38());
