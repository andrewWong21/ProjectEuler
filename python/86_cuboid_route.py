from math import sqrt, floor

def cuboid_route(count: int) -> int:
    
    a, ans = 1, 0
    
    # brute-force approach, testing every possible set of dimensions for cuboids
    # requirement for integer length hypotenuse means this solution can be improved with pythagorean triple formula
    while ans <= count:
        for b in range(1, a + 1):
            for c in range(1, b + 1):
                # shortest cuboid route is the hypotenuse of the right triangle
                # created by a, the longest side of the cuboid, and the sum of the shorter side lengths b, c
                min_route = sqrt(a*a + (b + c) ** 2)
                
                if floor(min_route) == min_route:
                    ans += 1
                    if ans > count:
                        return a
        a += 1
        if a % 10 == 0:
            print(a, ans)

if __name__ == "__main__":
    print(cuboid_route(1_000_000))
