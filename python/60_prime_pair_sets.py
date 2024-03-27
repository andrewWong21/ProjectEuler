from math import sqrt

def prime_pair_sets() -> int:
    # separate primes into two sets based on congruency to 1 or 2 mod 3
    # let s1 be the set of primes congruent to 1 mod 3,
    # and s2 be the set of primes congruent to 2 mod 3
    # concatenating a prime p1 from s1 and a prime p2 from s2
    # results in a number with a digit sum that is divisible by 3, and therefore not prime
    
    primes = set()
    s1 = []
    s2 = []
    
    sieved = [False] * 10_000
    for i in range(2, len(sieved)):
        if not sieved[i]:
            for j in range(2*i, len(sieved), i):
                sieved[j] = True
            if i % 3 == 1:
                s1.append(i)
            elif i % 3 == 2:
                s2.append(i)
            else: # 3 % 3 == 0, so it does not change the congruency of the concatenation
                s1.append(i)
                s2.append(i)
            primes.add(i)
    
    groups = []
    for i in range(0, len(s1)):
        a = s1[i]
        for j in range(i + 1, len(s1)):
            b = s1[j]
            if a >= b:
             continue
            if is_concat_prime(a, b, primes):
                groups.append([a, b])
    
    for i in range(2, 5):
        new_groups = []
        for group in groups:
            for p in s1:
                if any(prime >= p for prime in group):
                    continue
                if all(is_concat_prime(prime, p, primes) for prime in group):
                    new_groups.append(group + [p])
        groups = new_groups
    
    min_sum: int = 5 * 10_000
    for group in groups:
        min_sum = min(sum(group), min_sum)
    
    return min_sum
    
def is_concat_prime(a: int, b: int, primes: set) -> bool:
    return is_prime(int(str(a) + str(b)), primes) and is_prime(int(str(b) + str(a)), primes)
    
def is_prime(n: int, primes: set) -> bool:
    if n < 10_000:
        return n in primes
    
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

if __name__ == "__main__":
    print(prime_pair_sets())