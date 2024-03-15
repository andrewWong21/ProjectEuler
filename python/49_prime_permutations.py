def prime_permutations() -> str:
    # sieve 4-digit primes
    primes = []
    
    sieved = [False] * 10_000
    for i in range(2, 10_000):
        if not sieved[i]:
            for j in range (2*i, 10_000, i):
                sieved[j] = True
            if i >= 1000:
                primes.append(i)
    
    # group primes by digits
    digits_dict = dict()
    for prime in primes:
        
        digits = "".join(sorted(str(prime)))
        # looking for sequence other than 1487, 4817, 8147
        if digits == "1478":
            continue
        
        if digits not in digits_dict:
            digits_dict[digits] = []
        digits_dict[digits].append(prime)
    
    ans: str = ""
    
    # find 3-term arithmetic sequence from 4-digit prime permutations
    for val in digits_dict.values():
        if len(val) < 3:
            continue
        
        seq = arithmetic_sequence(val)
        if len(seq) > 0:
            # concatenate primes together
            ans = "".join([str(num) for num in seq])
            break
    
    return ans
    
def arithmetic_sequence(nums: list) -> list:
    # returns 3-term arithmetic sequence if found, empty list otherwise
    for first in range(0, len(nums)):
        for second in range(first + 1, len(nums)):
            diff: int = nums[second] - nums[first]
            if nums[second] + diff in nums:
                return [nums[first], nums[second], nums[second] + diff]
    
    return []
    

if __name__ == "__main__":
    print(prime_permutations())