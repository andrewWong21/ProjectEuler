def totient_maximum(n: int) -> int:
    max_val: float = 0
    max_n: int = 0
    
    # build totients of composite numbers using sieved primes
    sieved = [False] * (n + 1)
    totients = list(range(0, n + 1))
    
    for i in range(2, n + 1):
        if not sieved[i]:
            # if n is prime, totient(n) = i - 1
            totients[i] -= 1
            
            # else, totient(n) = n * P(1 - 1/p) for all prime factors p of n
            for j in range(2*i, n + 1, i):
                sieved[j] = True
                totients[j] *= (i - 1) / i
    
    for i in range(2, n + 1):
        val = i / totients[i]
        if val > max_val:
            max_n, max_val = i, val
        
    return max_n
    
    
if __name__ == "__main__":
    print(totient_maximum(1_000_000))