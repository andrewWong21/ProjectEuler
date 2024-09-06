function euler24(){
    var nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    var res = "";
    // lexicographically first permutation corresponds to n = 0
    var n = 999_999;
    while (true){
        // d! possible permutations of d digits, building permutation n
        // d possible starting digits, d groups of (d - 1)! permutations
        let fact = factorial(nums.length - 1);
        // find permutation group that n belongs to
        let idx = Math.floor(n / fact);
        
        // append next common digit in group to result
        res += nums[idx];
        // remove digit at idx
        nums.splice(idx, 1);
        // repeat process with remaining digits
        n = n % fact;
        
        // append last digit to resulting permutation
        // if only one digit remaining in digits to choose from
        if (nums.length == 1){
            res += nums[0];
            break;
        }
    }
    return res;
}

function factorial(n){
    var res = 1;
    while (n > 1) res *= n--;
    return res;
}

console.log(euler24());
