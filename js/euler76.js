function euler76(){
    const sums = new Array(101).fill(0);
    sums[0] = 1;
    // sum to 100 using at least 2 positive integers
    // integers used in sum can range from 1 to 99
    // i represents current largest integer used in sum
    for (let i = 1; i < 100; i++){
        // sums[n - i] ways to sum to n with i as the largest integer in the sum
        for (let n = i; n <= 100; n++){
            sums[n] += sums[n - i];
        }
    }
    return sums[100];
}

console.log(euler76());
