function euler86(){
    let count = 0, res = 0;
    for (let a = 1; ; a++){
        for (let b = 1; b <= a; b++){
            for (let c = 1; c <= b; c++){
                let r = Math.sqrt(a * a + (b + c) * (b + c));
                if (r == Math.floor(r)) count++;
                if (count >= 1e6) return a;
            }
        }
    }
}

console.log(euler86());
