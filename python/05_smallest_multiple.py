def gcd(a: int, b: int) -> int:
    if a % b == 0:
        return b
    return gcd(b, a % b)

def lcm(a: int, b: int) -> int:
    # if a is divisible by b, gcd(a, b) = b and lcm(a, b) = a
    # if a and b are relatively prime, gcd(a, b) = 1 and lcm(a, b) = a*b
    return a // gcd(a, b) * b

def smallest_multiple() -> int:
    # 2520 is the smallest positive number divisible by all numbers from 1 to 10
    multiple = 2520
    
    for i in range(11, 21):
        multiple = lcm(multiple, i)
    
    return multiple
    
if __name__ == "__main__":
    print("Smallest positive number evenly divisible by all numbers from 1 to 20:", smallest_multiple())