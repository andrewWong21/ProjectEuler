def sum_square_difference(n: int) -> int:
    
    sum_squares = 0
    sum = n * (n + 1) // 2
    
    for i in range(1, n + 1):
        sum_squares += i * i
    
    return abs(sum * sum - sum_squares)
    
if __name__ == "__main__":
    print("Difference between sum of the squares of first 100 natural numbers and square of the sum:", sum_square_difference(100))