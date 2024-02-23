from math import sqrt

def reciprocal_cycles() -> int:
    primes = get_primes(1000)
    max_len: int = 0
    product: int = 0
    
    for b in primes:
        if abs(b) > 1000:
            continue
        for a in range(-999, 1000):
            length = 0
            for n in range(0, 1000):
                res = n * (n + a) + b
                if (res < 1000 and res not in primes) or not is_prime(res):
                    break
                length = n
            
            if length > max_len:
                max_len = length
                product = a*b
                
    return product
    
def is_prime(n: int):
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def get_primes(n: int) -> set:
    prime_set = set()
    sieved = [False for _ in range(0, n)]
    for i in range(2, n):
        if not sieved[i]:
            for j in range(2*i, n, i):
                sieved[j] = True
            prime_set.add(i)
    return prime_set

if __name__ == "__main__":
    print(reciprocal_cycles())