function isPalindrome(s: string): boolean {
    return s == s.split("").reverse().join("");
}

function doubleBasePalindromes(): number {
    let res: number = 0;
    // positive even numbers always end in 0 in binary, never palindromes
    for (let i = 1; i < 1_000_000; i += 2) {
        if (isPalindrome(i.toString()) && isPalindrome(i.toString(2))) {
            res += i;
        }
    }
    return res;
}

console.log(doubleBasePalindromes());
