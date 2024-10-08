function euler56(){
    var res = 0;
    for (let a = 1n; a < 100n; a++){
        for (let b = 1n; b < 100n; b++){
            let sum = 0;
            let powStr = (a ** b).toString();
            for (let i = 0; i < powStr.length; i++){
                sum += powStr.charAt(i) - '0';
            }
            res = Math.max(res, sum);
            
        }
    }
    return res;
}

console.log(euler56());
