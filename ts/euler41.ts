function permute(str: string): number[] {
    const res: number[] = [];

    function backtrack(curr: string[], used: boolean[]): void {
        if (curr.length == str.length) {
            res.push(+(curr.join("")));
            return;
        }
        for (let i = 0; i < str.length; i++) {
            if (used[i]) continue;
            curr.push(str[i]);
            used[i] = true;
            backtrack(curr, used);
            used[i] = false;
            curr.pop();
        }
    }
    backtrack([], new Array(str.length).fill(false));
    return res;
}

function isPrime(n: number): boolean {
    if (n == 2) return true;
    for (let i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

function pandigitalPrime(): number {
    // sum of 1-9 is 45, divisible by 3, 9-digit pandigital cannot be prime
    // sum of 1-8 is 36, divisible by 3, 8-digit pandigital cannot be prime

    // generate 1-7 pandigitals in reverse lexicographical order and check if prime
    const pandigitals: number[] = permute("7654321");
    for (let pandigital of pandigitals) {
        if (isPrime(pandigital)) return pandigital;
    }
    return 0;
}

console.log(pandigitalPrime());
