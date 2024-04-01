from math import sqrt, floor

def diophantine_equation() -> int:
    max_x: int = 0
    max_d: int = 0
    
    for d in range(1, 1_001):
        if sqrt(d) == floor(sqrt(d)):
            continue
        
        min_sol = minimal_solution(d)
        if min_sol > max_x:
            # print(d, min_sol)
            max_d, max_x = d, min_sol
    
    return max_d

def minimal_solution(d: int) -> int:

    parts = get_parts(d)
    prev_num, prev_den, curr_num, curr_den = 1, 0, floor(sqrt(d)), 1
    i = 0
    
    while True:
        a = parts[i % len(parts)]
        i += 1
        num = a*curr_num + prev_num
        den = a*curr_den + prev_den
        
        if num*num - d*den*den == 1:
            # print("\t", d, "x =", num, "\t", num*num, d*den*den, "= 1")
            return num
        
        curr_num, curr_den, prev_num, prev_den = num, den, curr_num, curr_den
    

def get_parts(n: int) -> list:
    # assert(sqrt(n) != floor(sqrt(n)))
    
    # generate the integer parts of the continued fraction
    # representation of the square root of n 
    parts = []
    
    a0: int = floor(sqrt(n))
    a: int = floor(sqrt(n))
    b: int = a
    c: int = 1
    
    while True:
        c = (n - b * b) // c
        a = floor((sqrt(n) + b) / c)
        b = a * c - b
        
        parts.append(a)
        if a == 2 * a0:
            break
    
    return parts
    
if __name__ == "__main__":
    print(diophantine_equation())