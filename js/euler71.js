function euler71(){
    // next fraction between a/b and c/d is (a + c) / (b + d)
    let a = 2, b = 5, c = 3, d = 7;
    while (b + d <= 1e6){
        // add c to a n times, where n is floor((1e6 - b) / d)
        a += c;
        b += d;
    }
    return a;
    // return 2 + 3 * Math.floor((1e6 - 5) / 7);
}

console.log(euler71());
