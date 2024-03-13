from math import sqrt

def distinct_prime_factors() -> int:
    
    primes = set()
    n: int = 2
    streak: int = 0
    last: int = 0
    
    while last == 0:
        print(n)
        if not is_prime(n):
            # check number of prime factors 
            if get_distinct_prime_factors(n, primes) == 4:
                streak += 1
            else:
                streak = 0
            
        else:
        # n is prime and cannot have 4 distinct prime factors
        # reset streak and cache prime for faster lookup later
            primes.add(n)
            streak = 0
        
        if streak == 4:
            last = n
        n += 1
    
    return last - 3
    
def get_distinct_prime_factors(n: int, primes: set) -> int:
    factors = set()
    # divide n by its prime factors in primes
    while n > 1:
        for p in primes:
            if n % p == 0:
                factors.add(p)
                n //= p
        
    return len(factors)
    
def is_prime(n: int) -> bool:
    if n < 2:
        return False
    
    i: int = 2
    while i*i <= n:
        if n % i == 0:
            return False
        i += 1
    return True

if __name__ == "__main__":
    print(distinct_prime_factors())