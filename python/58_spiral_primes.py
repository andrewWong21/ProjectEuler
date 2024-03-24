from math import sqrt

def spiral_primes() -> int:
    
    # side length 3:  3,  5,  7,  9
    # side length 5: 13, 17, 21, 25
    # side length 7: 31, 37, 43, 49
    # side length n: n^2 - 3n + 3, n^2 - 2n + 2, n^2 - n + 1, n^2
    primes = [3, 5, 7]
    corners = [1, 3, 5, 7, 9]
    
    length: int = 3
    
    while len(primes) / len(corners) >= 0.1:
        length += 2
        
        for n in range(0, 4):
            corner = length ** 2 - n * (length - 1)
            if is_prime(corner):
                primes.append(corner)
            corners.append(corner)
        
    return length
    
def is_prime(n: int) -> bool:
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

if __name__ == "__main__":
    print(spiral_primes())