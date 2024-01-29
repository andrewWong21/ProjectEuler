from math import sqrt

def largest_prime_factor(n: int) -> int:
    factor: int = 0
    root = int(sqrt(n))
    
    sieved = [False for _ in range(0, root + 1)]
    primes = []
    
    for i in range (2, len(sieved)):
        if not sieved[i]:
            for j in range (2*i, len(sieved), i):
                sieved[j] = True
            primes.append(i)
    
    for i in range(0, len(primes)):
        while n % primes[i] == 0:
            n //= primes[i]
            factor = primes[i]
    
    if n > 1:
        return n
    return factor
    
if __name__ == "__main__":
    print("Largest prime factor of 600851475143:", largest_prime_factor(600_851_475_143))