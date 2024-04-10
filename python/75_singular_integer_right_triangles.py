from math import sqrt, floor

def singular_integer_right_triangles(p: int) -> int:
    # using Euclid's formula to find sides of right triangles
    # given integers m > n > 0,
    # a = m*m - n*n, b = 2mn, c = m^2 + n^2 satisfy the Pythagorean identity
    # if gcd(m, n) == 1 and exactly one of m, n is even, the resulting triple (a, b, c) is primitive
    
    # if both m and n are even, their gcd will be at least 2
    # thus, it is sufficient to check gcd(m, n) == 1 then whether both are odd
    
    perimeters = {perim: 0 for perim in range(1, p + 1)}
    count: int = 0
    
    for m in range(1, floor(sqrt(p)) + 1): # if m > sqrt(p), then c > p
        for n in range(1, m):
            if gcd(m, n) == 1:
                a = m*m - n*n
                b = 2*m*n
                if a > b: # treat valid triples as a < b < c only
                    continue
                c = m*m + n*n
                
                if m % 2 == 1 and n % 2 == 1:
                    a //= 2
                    b //= 2
                    c //= 2
                
                perim = a + b + c
                k = 1
                # once primitive triple is found, 
                # count scaled triples until perimeter exceeds p
                while k*perim <= p:
                    perimeters[k*perim] += 1
                    k += 1
    
    return sum(perimeters[perim] == 1 for perim in range(1, p + 1))
    
def gcd(a: int, b: int) -> int:
    if a % b == 0:
        return b
    return gcd(b, a % b)

if __name__ == "__main__":
    print(singular_integer_right_triangles(1_500_000))
