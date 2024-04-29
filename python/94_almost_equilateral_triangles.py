from math import sqrt

def almost_equilateral_triangles(max_perim: int) -> int:
    
    # almost equilateral triangle with two sides equal is isosceles
    # isosceles with sides of length s, s, t where t = s + 1 or s - 1
    # has perimeter 2s + t (3s - 1 or 3s + 1)
    # area t/2 * sqrt(s^2 - (t/2)^2) = t/2 * sqrt(s^2 - t^2/4)
    
    # isosceles triangle is composed of 2 right triangles
    # each right triangle has side lengths t/2, sqrt(s^2 - t^2/4), s
    # and area 1/2 * t/2 * sqrt(s^2 - t^2/4)
    
    # generate integer right triangles a = t/2, b = sqrt(s^2 - t^2/4), c = s
    # a = m^2 - n^2, b = 2mn, c = m^2 + n^2, for integers m > n > 0
    
    # if 2*a = c + 1 or 2*a = c - 1, almost equilateral triangle can be created
    # with integer sides c, c, 2*a and perimeter 2*(a+c) and area a*b
    
    perim_sum: int = 0
    max_side = max_perim // 3 + 1
    almost_tri = set()
    
    for m in range(1, int(sqrt(max_side)) + 1):
        for n in range(1, m):
            if gcd(m, n) == 1:
                a = m*m - n*n
                b = 2*m*n
                c = m*m + n*n
                
                if m % 2 == 1 and n % 2 == 1:
                    a //= 2
                    b //= 2
                    c //= 2
                
                if abs(c - 2*a) == 1 and 2*(c+a) < max_perim and (a, c) not in almost_tri:
                    almost_tri.add((a, c))
                    perim_sum += 2*(c+a)
                    # print(c, c, 2*a)
                if abs(c - 2*b) == 1 and 2*(c+b) < max_perim and (b, c) not in almost_tri:
                    almost_tri.add((b, c))
                    perim_sum += 2*(c+b)
                    # print(c, c, 2*b)
    
    return perim_sum
    
def gcd(a: int, b: int) -> bool:
    if a % b == 0:
        return b
    return gcd(b, a % b)

if __name__ == "__main__":
    print(almost_equilateral_triangles(1_000_000_000))
