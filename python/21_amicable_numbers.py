from math import sqrt

def amicable_numbers(num: int) -> int:
    sum: int = 0
    for a in range(2, num):
        b: int = divisor_sum(a)
        if a != b and divisor_sum(b) == a:
            sum += a
    return sum
    
def divisor_sum(num: int) -> int:
    sum: int = 1
    for i in range(2, int(sqrt(num)) + 1):
        if num % i == 0:
            sum += i + num // i
    
    if int(sqrt(num)) == sqrt(num):
        sum -= int(sqrt(num))
    return sum

if __name__ == "__main__":
    # print(divisor_sum(220))
    print(amicable_numbers(10_000))