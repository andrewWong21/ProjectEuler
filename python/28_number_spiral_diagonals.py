def number_spiral_diagonal(num: int) -> int:
    assert(num % 2 == 1)
    # 1: 1
    # 3: + 3 + 5 + 7 + 9
    # 5: + 13 + 17 + 21 + 25
    # n: + (n^2 - 3*n + 3) + (n^2 - 2*n + 2) + (n^2 - n + 1) + n^2
    # 4*n^2 - 6*n + 6
    sum: int = 1
    for n in range(3, num+1, 2):
        sum += 4*n*n - 6*n + 6
    
    
    return sum

if __name__ == "__main__":
    print(number_spiral_diagonal(1001))