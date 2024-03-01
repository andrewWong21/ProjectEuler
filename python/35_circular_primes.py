def circular_primes() -> int:
    primes = set()
    sieved = [False] * 1_000_000
    for i in range(2, 1_000_000):
        if not sieved[i]:
            for j in range (2*i, 1_000_000, i):
                sieved[j] = True
            primes.add(i)
    
    count: int = 0
    for prime in primes:
        if prime < 10: # 2, 3, 5, 7 are circular primes
            count += 1
            continue
        
        is_circular_prime: bool = True
        prime_str = str(prime)
        
        # if prime > 10 contains 2, 4, 5, 6, 8, or 0, not all rotations can be prime
        if not all(chr not in prime_str for chr in ['2', '4', '5', '6', '8', '0']):
            continue
        
        for i in range(0, len(prime_str)):
            prime_str = prime_str[1:] + prime_str[0]
            if int(prime_str) not in primes:
                is_circular_prime = False
                break
            
        if is_circular_prime:
            count += 1
    
    return count

if __name__ == "__main__":
    print(circular_primes())