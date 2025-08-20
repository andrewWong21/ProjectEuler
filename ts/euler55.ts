function isPalindrome(s: string): boolean {
    return s == s.split("").reverse().join("");
}

function reverseNum(n: number): number {
    let rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n = Math.floor(n / 10);
        }
    return rev;
}

function isLychrel(n: number): boolean {
    for (let i = 0; i < 50; i++){
        n += reverseNum(n);
        if (isPalindrome(n.toString())) return false;
    }
    return true;
}

function lychrelNumbers(): number {
    let res = 0;
    for (let i = 1; i <= 10_000; i++) {
        if (isLychrel(i)) res++;
    }
    return res;
}

console.log(lychrelNumbers());
