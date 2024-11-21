function euler100(){
    // B = # of blue discs, R = # of red discs
    // B / (B + R) * (B - 1) / (B + R - 1) = 1 / 2
    // 2 * (B^2 - B) = (B + R) * (B + R - 1)
    // 2B^2 - 2B = B^2 + BR - B + BR + R^2 - R
    // 2B^2 - 2B = B^2 - B + 2BR + R^2 - R
    // B^2 - 2B = 2BR - B + R^2 - R
    // B^2 - B - 2BR + R - R^2 = 0
    // B^2 + (-2R - 1)B + R - R^2 = 0
    
    // a = 1, b = (-2R - 1), c = (R - R^2)
    // B = ( (2R + 1) +/- sqrt(4R^2 + 4R + 1 - 4R + 4R^2) ) / 2
    // B = ( 2R + 1 +/- sqrt(8R^2 + 1) ) / 2
    
    // discard extraneous solution (2R + 1 - sqrt(8R^2 + 1)) / 2
    // as 2R + 1 < sqrt(8R^2 + 1) for all positive values of R > 1
    
    // B = (2R + 1 + sqrt(8R^2 + 1)) / 2 = R + (sqrt(8R^2 + 1) + 1) / 2
    // B is an integer, so 2R + 1 + sqrt(8R^2 + 1) must be even
    // and therefore sqrt(8R^2 + 1) is an odd integer x
    // x^2 = 8r^2 + 1, so find solutions to x^2 - 8r^2 = 1
    // fundamental solution: x = 3, r = 1
    
    const x_f = 3, r_f = 1;
    const minTotal = 1e12;
    let x = x_f, r = r_f;
    while (true){
        const discrimSqrt = Math.sqrt(8 * r * r + 1);
        if (Number.isInteger(discrimSqrt) && discrimSqrt % 2 == 1){
            const b = r + (discrimSqrt + 1) / 2;
            if (b + r > minTotal) return b;
        }
        const nextX = x_f * x + 8 * r_f * r;
        const nextR = r_f * x + x_f * r;
        x = nextX;
        r = nextR;
    }
}

console.log(euler100());
