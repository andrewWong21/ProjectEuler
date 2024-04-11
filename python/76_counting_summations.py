def counting_summations(n) -> int:
    # 2: 1 way  (1 + 1)
    # 3: 2 ways (2 + 1, 1 + 1 + 1)
    # 4: 3 ways (3 + 1, 2 + 2, 2 + 1 + 1, 1 + 1 + 1 + 1)
    # 5: 6 ways (4 + 1, 3 + 2, 3 + 1 + 1, 2 + 2 + 1, 2 + 1 + 1 + 1, 1 + 1 + 1 + 1 + 1)
    
    # the number of ways to write n as a sum of at least two positive integers
    # is equal to the number of ways to sum to n using integers [1, n - 1]
    
    sums = [0] * (n + 1)
    sums[0] = 1
    for i in range(1, n): # i is current largest integer used in sum
        for j in range(i, n + 1): # update sums to integers j > i with sums including i
            # add number of ways to sum to (j - i)
            # to number of known ways to sum to j
            sums[j] += sums[j - i]
    
    return sums[n]

if __name__ == "__main__":
    print(counting_summations(100))
