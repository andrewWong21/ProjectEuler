from math import sqrt

def integer_right_triangles() -> int:
    
    # a^2 + b^2 = c^2, a + b + c = p <= 1000
    
    # rewrite c in terms of a, b, p
    # c = p - a - b
    # rewrite b in terms of a, p
    # a^2 + b^2 = (p - a - b)^2 = p^2 - ap - bp - ap + a^2 + ab - bp + ab + b^2
    # a^2 + b^2 = p^2 + a^2 + b^2 + 2ab - 2ap - 2bp
    # 0 = p^2 + 2ab - 2ap - 2bp
    # 2bp - 2ab = b(2p - 2a) = p^2 - 2ap
    # b = (p^2 - 2ap) / (2p - 2a)
    # given integers a and p, if (p^2 - 2ap) is divisible by (2p - 2a) then b is also an integer
    
    # p^2 - 2ap > 0 --> p^2 > 2ap --> a < p/2
    
    ans: int = 0
    max_solutions: int = 0
    
    for p in range(1, 1001):
        solutions = 0
        for a in range(1, p // 2):
            if (p*p - 2*a*p) % (2*p - 2*a) == 0:
                b = (p*p - 2*a*p) // (2*p - 2*a)
                # restrict triplets to a < b < c to avoid double-counting solutions
                # if a == b then the hypotenuse c can never be an integer
                if b < a:
                    continue
                solutions += 1
                if solutions > max_solutions:
                    ans = p
                    max_solutions = solutions
    
    return ans

if __name__ == "__main__":
    print(integer_right_triangles())