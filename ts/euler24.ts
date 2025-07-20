function factorial(n: number): number {
    let res: number = 1;
    while (n >= 1) res *= n--;
    return res;
}

function lexicographicPermutations(): string {
    let nums: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let n = 999_999;
    let res: string = "";
    while (nums.length > 0) {
        let fact: number = factorial(nums.length - 1);
        let idx: number = Math.floor(n / fact);
        res += nums[idx];
        nums.splice(idx, 1);
        n %= fact;
    }
    return res;
}

console.log(lexicographicPermutations());
