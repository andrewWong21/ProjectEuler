def pandigital_prime() -> int:
    # all n-digit pandigital numbers have the same digit sum 1 + 2 + 3 + ... + n = (n * (n + 1))/2
    # 9-digit pandigital numbers have the digit sum (9 * 10)/2 = 45 
    # 45 is divisible by 3, so 9-digit pandigital numbers cannot be prime
    # similarly, 8-digit pandigital numbers have the digit sum (8 * 9)/2 = 36, which is also divisible by 3
    # therefore pandigital primes can have at most 7 digits
    
    
    # checking all permutations of the string 1234567      (5,040)
    # would be faster than checking all 7-digit primes   (586,081)
    
    sieved = [False] * 10_000_000
    primes = set()
    for i in range(2, len(sieved)):
        if not sieved[i]:
            for j in range(2*i, len(sieved), i):
                sieved[j] = True
            # print(i)
            primes.add(i)
    
    max_pandigital_prime: int = 0
    digits = sorted("1234567")
    
    for prime in primes:
        # 1, 3, 6, 10, 15, 21, 28, 36, 45
        # only primes with 1, 4, or 7 digits can be pandigital
        length = len(str(prime))
        if length not in [1, 4, 7]:
            continue
        if sorted(str(prime)) == digits[0:length]:
            if prime > max_pandigital_prime:
                max_pandigital_prime = prime
    
    return max_pandigital_prime

if __name__ == "__main__":
    print(pandigital_prime())