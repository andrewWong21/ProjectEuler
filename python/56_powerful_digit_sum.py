def powerful_digit_sum() -> int:
    
    max_sum: int = 0
    
    for a in range(1, 100):
        for b in range(1, 100):
            digit_sum = sum(int(chr) for chr in str(a ** b))
            max_sum = digit_sum if digit_sum > max_sum else max_sum
    return max_sum

if __name__ == "__main__":
    print(powerful_digit_sum())