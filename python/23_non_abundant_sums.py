from math import sqrt

def non_abundant_sums() -> int:

    sum: int = 0
    nums = set() # faster for checking membership than a list
    # all integers greater than 28123 can be written as the sum of 2 abundant numbers
    for i in range(1, 28124):
        # add to abundant number set
        if divisor_sum(i) > i:
            nums.add(i)
        if not is_abundant_sum(nums, i):
            sum += i
        
    return sum
    
def is_abundant_sum(nums: set, n: int) -> bool:
    # check if difference of n and any abundant number in the set
    # is also an abundant number, then n is an abundant sum
    for num in nums:
        if (n - num) in nums:
            return True
    return False
    
def divisor_sum(num: int) -> int:
    sum: int = 1
    for i in range(2, int(sqrt(num)) + 1):
        if num % i == 0:
            sum += i + num // i
    
    if int(sqrt(num)) == sqrt(num):
        sum -= int(sqrt(num))
    return sum

if __name__ == "__main__":
    print(non_abundant_sums())