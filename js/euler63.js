function euler63(){
    var count = 0;
    // 10^n has n + 1 digits, so the base x can be at most 9 for x^n to have n digits
    for (let base = 1; base < 10; base++){
        let power = 1;
        let result = base;
        // increment count for every nth power found with n digits
        while (result.toString().length == power){
            count++;
            power++;
            // get next power by multiplying by base
            result *= base;
        }
    }
    return count;
}

console.log(euler63());
 