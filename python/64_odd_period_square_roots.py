from math import sqrt, floor

def odd_period_square_roots() -> int:
    
    odd_period_roots: int = 0
    
    for n in range(1, 10_001):
        # period = get_root_period(n)
        # print(n, period)
        
        if get_root_period(n) % 2 == 1:
            odd_period_roots += 1
    
    return odd_period_roots
    
def get_root_period(n: int) -> int:
    if sqrt(n) == floor(sqrt(n)):
        return 0
        
    # first iteration: sqrt(n) = a + sqrt(n) - a
    # a_0 = sqrt(n)
    # b_0 = a_0
    # c_0 = 1
    
    # result after each iteration: a_n + (sqrt(n) - b_n) / c_n
    # rationalize reciprocal of (sqrt(n) - b_n) / c_n
    # c_n / (sqrt(n) - b_n) * ((sqrt(n) + b_n) / c_n) / ((sqrt(n) + b_n) / c_n)
    # = (sqrt(n) + b_n) / ((n - (b_n)^2) / c_n)
    
    a: int = floor(sqrt(n))
    b: int = a
    c: int = 1
    bc = set()
    
    # c_(n+1) = (n - (b_n)^2) / c_n
    # a_(n+1) = int((sqrt(n) - b_n)/c_(n+1))
    # b_(n+1) = a_(n+1) * c_(n+1) - b_n
    while True:
        c = (n - b * b) // c
        a = floor((sqrt(n) + b) / c)
        b = a * c - b
        if (b, c) in bc:
            break
        bc.add((b, c))
    
    return len(bc)
    
if __name__ == "__main__":
    print(odd_period_square_roots())