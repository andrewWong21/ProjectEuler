def special_pythagorean_triplet(n: int) -> int:
    
    # since a < b < c and a + b + c = 1000,
    # a cannot be greater than 333 as b must then be at least 334
    # and c at least 335, but 
    for a in range (1, n // 3):
        for b in range(a + 1, n - a + 1):
            c = n - a - b
            if b > c:
                continue
            if (a*a + b*b == c*c):
                return a * b * c
    return -1
    
if __name__ == "__main__":
    print("Product of a, b, c:", special_pythagorean_triplet(1000))