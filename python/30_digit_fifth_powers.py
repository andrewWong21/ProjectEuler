def digit_fifth_powers() -> int:
    sum: int = 0
    
    # 9^5 = 59049
    # if the maximum sum of the fifth powers of the digits of a D-digit number
    # is less than the smallest D-digit number 10^(D-1),
    # all fifth-power digit sum numbers must be less than 10^(D-1)
    # the smallest positive integer that satisfies D * 9^5 < 10^(D - 1) is D = 7
    # 7 * 59049 =  < 1_000_000
    
    for n in range(2, 10 ** 6):
        if dfps(n):
            sum += n
    
    return sum
    
def dfps(n : int) -> bool:
    i = n
    sum = 0
    while i > 0:
        sum += (i % 10) ** 5
        i //= 10
    return sum == n

if __name__ == "__main__":
    print(digit_fifth_powers())