function isPalindrome(n: number): boolean {
    let num: number = n;
    let rev: number = 0;
    while (num > 0){
        rev = rev * 10 + (num % 10);
        num = (num - num % 10) / 10;
    }
    return rev == n;
}

function largestPalindromeProduct(): number {
    let res: number = 0;
    for (let a: number = 990; a >= 100; a -= 11){
        for (let b: number = 999; b >= 100; b--){
            let product: number = a * b;
            if (product < res) break;
            if (isPalindrome(product)){
                res = product;
            }
        }
    }
    return res;
}


console.log(largestPalindromeProduct());
