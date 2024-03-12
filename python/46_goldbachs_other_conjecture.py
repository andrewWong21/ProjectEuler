from math import sqrt

def goldbachs_other_conjecture() -> int:

    counterexample: int = 0
    n: int = 35
    
    while counterexample == 0:
        # check composite odds only
        if is_prime(n):
            n += 2
            continue
        
        found: bool = False
        s: int = 1
        
        # n = p + 2*s*s
        # p = n - 2*s*s
        
        # test differences of n and all doubled squares less than n
        while (2*s*s < n):
            if is_prime(n - 2*s*s):
                found = True
                break
            s += 1
        
        if not found:
            counterexample = n
        n += 2
    
    return counterexample
    
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
    print(goldbachs_other_conjecture())