def prime_summations(n: int) -> int:
    sieved = [False] * (n + 1)
    primes = []
    for i in range(2, n + 1):
        if not sieved[i]:
            primes.append(i)
            for j in range(2*i, n + 1, i):
                sieved[j] = True
    
    sums = [0] * (n + 1)
    sums[0] = 1
    for i in primes: # i is current largest prime used in sum
        for j in range(i, n + 1): # update sums to integers j > i with sums including i
            # add number of ways to sum to (j - i)
            # to number of known ways to sum to j
            sums[j] += sums[j - i]
    
    for i in range(2, n + 1):
        if sums[i] >= 5000:
            return i
    return -1

if __name__ == "__main__":
    n: int = 50
    ans: int = -1
    # increase search size until answer is found
    while ans == -1:
        ans = prime_summations(n)
        n *= 2
    print(ans)
