from math import factorial

def curious_sum() -> int:
    sum: int = 0
    # minimum value of D-digit number N: N = 10^(D - 1)
    # maximum value of digit factorial sum of N: D * 9! = D * 362880
    # largest positive integer value of D that satisfies D * 9! > 10^(D - 1) is 7
    for i in range(3, 362880 * 7):
        if i == digit_factorial_sum(i):
            sum += i
    return sum
    
def digit_factorial_sum(n: int) -> bool:
    factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
    sum = 0
    while n > 0:
        sum += factorials[n % 10]
        n //= 10
    return sum

if __name__ == "__main__":
    print(curious_sum())