from math import factorial

def factorial_digit_sum(num: int) -> int:
    sum: int = 0
    while num > 0:
        sum += num % 10
        num //= 10
    return sum

if __name__ == "__main__":
    print(factorial_digit_sum(factorial(100)))