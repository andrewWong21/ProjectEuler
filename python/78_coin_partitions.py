def coin_partitions(n: int) -> int:
    
    sums = [0] * (n + 1)
    sums[0] = 1
    for i in range(1, n + 1): # i is current largest integer used in sum
        if i % 100 == 0:
            print(i)
        for j in range(i, n + 1): # update sums to integers j > i with sums including i
            # add number of ways to sum to (j - i) to number of known ways to sum to j
            sums[j] += sums[j - i] % 1_000_000
            sums[j] %= 1_000_000
        if sums[i] == 0:
            return i
    
    return -1

if __name__ == "__main__":
    print(coin_partitions(56_000))
