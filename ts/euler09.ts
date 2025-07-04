function specialPythagoreanTriplet(): number {
    // a + b + c = 1000, a^2 + b^2 = c^2
    // c = 1000 - a - b
    // a^2 + b^2 = (1000 - a - b)^2
    // a^2 + b^2 = 1000000 - 1000a - 1000b - 1000a + a^2 + ab - 1000b + ab + b^2
    // 0 = 1000000 - 1000a - 1000b - 1000a + ab - 1000b + ab
    // 2000b - 2ab = 1000000 - 2000a
    // 1000b - ab = 500000 - 1000a
    // b * (1000 - a) = 1000 * (500 - a)
    // b = 1000 * (500 - a) / (1000 - a)
    
    // a + b + c = 1000, a < b < c, a < 1000 / 3
    // b = 1000 * (500 - a) / (1000 - a)
    // c = 1000 - a - b
    
    for (let a: number = 1; a < 333; a++) {
        let product: number = 1000 * (500 - a);
        let divisor: number = 1000 - a;
        if (product % divisor != 0) continue;
        
        let b: number = product / divisor;
        if (b < a) continue;
        
        let c: number = 1000 - a - b;
        if (c <= b) continue;
        return a * b * c;
    }
}

console.log(specialPythagoreanTriplet());
