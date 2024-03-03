def truncatable_primes() -> int:
    n = 1_000_000
    primes = set()
    sieved = [False] * n
    for i in range(2, n):
        if not sieved[i]:
            for j in range(2*i, n, i):
                sieved[j] = True
            primes.add(i)
    trunc_primes = set()
    
    for prime in primes:
        if prime < 10: # skip 2, 3, 5, 7
            continue
        # if prime contains the digits 4, 6, 8, 0, at least one truncation will be composite
        if not all(chr not in str(prime) for chr in ['4', '6', '8', '0']):
            continue
        # prime containing 2 and 5 can only be left and right truncatable if it is the first digit
        if not all(str(prime).find(chr) <= 0 for chr in ['2', '5']):
            continue
        
        # left truncatable successively removes leftmost digit
        nl = prime
        is_left_trunc = True
        while nl > 10:
            nl = int(str(nl)[1:])
            if nl not in primes:
                is_left_trunc = False
                break
        if not is_left_trunc:
            continue
            
        # right truncatable successively removes rightmost digit
        nr = prime
        is_right_trunc = True
        while nr > 10:
            nr //= 10
            if nr not in primes:
                is_right_trunc = False
                break
        if not is_right_trunc:
            continue
        
        trunc_primes.add(prime)
        if len(trunc_primes) == 11:
            break
    
    return sum(trunc_primes)

if __name__ == "__main__":
    print(truncatable_primes())