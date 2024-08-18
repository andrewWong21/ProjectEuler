function gcd(a, b){
    while (b > 0){
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

function euler05(){
    var smallest = 2520;
    for (let i = 11; i <= 20; i++){
        smallest = (smallest * i) / gcd(smallest, i);
    }
    return smallest;
}

console.log(euler05());
