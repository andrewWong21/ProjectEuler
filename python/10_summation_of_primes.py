def prime_summation(n: int) -> int:
    sum: int = 0
    sieved = [False for _ in range(0, n)]
    for i in range(2, n):
        if not sieved[i]:
            for j in range(2*i, n, i):
                sieved[j] = True
            sum += i
    return sum
 
if __name__ == "__main__":
    print("Sum of all primes under 2 million:", prime_summation(2_000_000))