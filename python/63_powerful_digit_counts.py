def powerful_digit_counts() -> int:
    
    # if an n-th power x^n has n digits,
    # then it must fulfill the inequality
    # 10^(n - 1) <= x^n < 10^n
    # x^n < 10^n means that x can be at most 9
    # 10^(n - 1) <= x^n becomes false when n becomes too large
    
    powers: int = 0
    
    for x in range(1, 10):
        n = 1
        while x ** n >= 10 ** (n - 1):
            powers += 1
            n += 1
    
    return powers
    
if __name__ == "__main__":
    print(powerful_digit_counts())