function euler02(){
    var prev = 1, curr = 1;
    var total = 0;
    while (curr < 4_000_000){
        if (curr % 2 == 0) total += curr;
        [prev, curr] = [curr, prev + curr];
    }
    return total;
}

console.log(euler02());
