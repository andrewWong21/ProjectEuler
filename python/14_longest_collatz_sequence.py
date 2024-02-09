def longest_collatz_sequence(n: int) -> int:
    max_chain: int = 1
    max_num: int = 1
    nums: list = [0] * n
    for i in range(1, n):
        j = i
        chain: int = 0
        while j != 1:
            if j < n and nums[j] != 0:
                chain += nums[j]
                break
            if j % 2 == 0:
                j //= 2
            else:
                j = 3*j + 1
            chain += 1
        
        nums[i] = chain
        if max_chain < chain:
            max_chain = chain
            max_num = i
    return max_num

if __name__ == "__main__":
    print(longest_collatz_sequence(1_000_000))