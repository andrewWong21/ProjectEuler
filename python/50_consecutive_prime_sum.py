def consecutive_prime_sum() -> int:
    primes = []
    sum: int = 0
    max_terms: int = 0
    
    sieved = [False] * 1_000_000
    for i in range(2, 1_000_000):
        if not sieved[i]:
            for j in range (2*i, 1_000_000, i):
                sieved[j] = True
            primes.append(i)
    primes_set = set(primes)
            
    for prime in primes:
        if sum + prime < 1_000_000:
            sum += prime
            max_terms += 1
        else:
            break
    
    sums = [0] * (max_terms + 1)
    sums[0] = 2
    for i in range(1, max_terms + 1):
        sums[i] = sums[i - 1] + primes[i]
    
    ans = 0
    for len in range(max_terms, 0, -1):
        for start in range(max_terms - len - 1, 0, -1):
            sum_a = sums[start]
            sum_b = sums[start + len]
            
            if sum_b - sum_a in primes_set:
                ans = sum_b - sum_a
                break
        if ans != 0:
            break
    return ans

if __name__ == "__main__":
    print(consecutive_prime_sum())