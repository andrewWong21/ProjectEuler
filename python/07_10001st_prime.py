from math import sqrt

def is_prime(n: int) -> bool:
    if n == 2 or n == 3:
        return True
    
    for i in range(2, int(sqrt(n) + 1)):
        if n % i == 0:
            return False
    return True
    

def nth_prime(n: int) -> int:
    if n == 1:
        return 2
    num = 3
    count = 2
    
    while count != n:
        num += 2
        if is_prime(num):
            count += 1
    
    return num
    
if __name__ == "__main__":
    print("10001st prime:", nth_prime(10_001))