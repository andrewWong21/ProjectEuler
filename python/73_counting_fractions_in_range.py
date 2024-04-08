def counting_fractions_in_range(n: int) -> int:
    # recursion limit causes issues with output for naive recursion approach
    count: int = 0
    for den in range(2, n + 1):
        for num in range(1, den):
            if gcf(den, num) == 1 and num * 3 > den and num * 2 < den:
                count += 1
    
    return count

def gcf(a, b):
    if a % b == 0:
        return b
    return gcf(b, a % b)

if __name__ == "__main__":
    print(counting_fractions_in_range(12_000))