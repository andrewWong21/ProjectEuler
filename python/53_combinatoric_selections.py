def combinatoric_selections() -> int:
    
    # nCr = nC(n - r)
    # if nCr > 1000000, nC(n + 1), nC(n + 2), ..., nC(n - r) will also be > 1000000
    # values in range [r, n - r]: (n - r) - r + 1 = n - 2r + 1
    # unique values of nCr: 1, 2, 3, ..., n - r + 1
    
    # nC1 = n
    # nC2 = n! / (2! * (n - 2)!) = n * (n - 1) / 2
    # nC3 = n! / (3! * (n - 3)!) = n * (n - 1) * (n - 2) / (2 * 3)
    # nCr = nC(r - 1) * (n - r + 1) / r
    
    count: int = 0
    
    # 23 choose 10 is first value exceeding 1 million for 1 <= n <= 100
    for n in range(23, 101):
        ncr = n
        
        for r in range(2, n + 1):
            ncr = ncr * (n - r + 1) // r
            
            if ncr > 1_000_000:
                count += n - 2*r + 1
                break
        
    return count

if __name__ == "__main__":
    print(combinatoric_selections())