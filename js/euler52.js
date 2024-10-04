function euler52(){
    var n = 1;
    while (true){
        let str = n.toString().split('').sort().join('');
        let permuted = true;
        for (let i = 2; i <= 6; i++){
            let newStr = (n * i).toString().split('').sort().join('');
            if (newStr != str){
                permuted = false;
                break;
            }
        }
        if (permuted) return n;
        n++;
    }
}

console.log(euler52());
