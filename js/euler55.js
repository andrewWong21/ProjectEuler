function euler55(){
    var res = 0;
    for (let n = 1; n < 10_000; n++){
        let num = n;
        let isLychrel = true;
        for (let i = 0; i < 50; i++){
            let rev = num.toString().split('').reverse().join('');
            num += Number(rev);
            if (isPalindrome(num)){
                isLychrel = false;
                break;
            }
        }
        if (isLychrel) res++;
    }
    return res;
}

function isPalindrome(n){
    return n.toString() == n.toString().split('').reverse().join('');
}

console.log(euler55());
