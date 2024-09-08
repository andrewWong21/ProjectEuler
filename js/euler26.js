function euler26(){
    var res = 0, maxLen = 0;
    for (let n = 2; n < 1000; n++){
        var len = getCycle(n);
        if (len > maxLen){
            maxLen = len;
            res = n;
        }
    }
    return res;
}

function getCycle(n){
    var rem = 1, count = 0;
    var seen = new Map();
    while (rem != 0){
        rem = (rem * 10) % n;
        if (seen.has(rem)) return (count - seen.get(rem));
        seen.set(rem, count++);
    }
    return 0;
}

console.log(euler26());
