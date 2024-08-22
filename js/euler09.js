function euler09(){
    // a + b + c = 1000
    // a^2 + b^2 = c^2
    // a < b < c
    // constraint of a < 333, since minimal values for a = 333
    // are b = 334 and c = 335, which makes a + b + c > 1000
    
    // c = 1000 - a - b
    // a^2 + b^2 = (1000 - a - b)^2
    // a^2 + b^2 = 1,000,000 - 1000a - 1000b - 1000a + a^2 + ab - 1000b + ab + b^2
    // 0 = 1,000,000 - 2000a - 2000b + 2ab
    // 0 = 500,000 - 1000a - 1000b + ab
    // b(1000 - a) = 500,000 - 1000a
    // b = (500,000 - 1000a) / (1000 - a)
    
    for (let a = 332; a >= 1; a--){
        // b must be an integer, therefore
        // 1000 - a must be a factor of 500,000 - 1000a
        if ((500000 - 1000 * a) % (1000 - a) != 0) continue;
        let b = (500000 - 1000 * a) / (1000 - a);
        let c = 1000 - a - b;
        return a * b * c;
    }
    return 0;
}

console.log(euler09());
