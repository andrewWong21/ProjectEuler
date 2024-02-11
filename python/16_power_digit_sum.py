def power_digit_sum(n: int) -> int:
    sum: int = 0
    digits: string = str(2 ** n)
    for i in range(0, len(digits)):
        sum += int(digits[i])
    return sum

if __name__ == "__main__":
    print(power_digit_sum(1000))