def totient_permutation(n: int) -> int:
    min_val: float = n
    min_n: int = 0
    
    totients = list(range(0, n))
    
    # since n may go up to 10^7, rounding errors may occur with floats
    # using the formula totient(n) = n * P(1 - 1/p) for all prime factors p of n
    # another formula for totient(n) is n - S(totient(c)) for all c < n that are coprime with n
    for i in range(1, n):
        for j in range(2*i, n, i):
            totients[j] -= totients[i]
        
        if i < 2 or sorted(str(i)) != sorted(str(int(totients[i]))):
            continue
        
        val = i / totients[i]
        if val < min_val:
            min_n, min_val = i, val
        
    return min_n
    
    
if __name__ == "__main__":
    # print(totient_permutation(10))
    print(totient_permutation(10_000_000))