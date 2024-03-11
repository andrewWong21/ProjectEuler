from math import sqrt

def triangular_pentagonal_hexagonal() -> int:
    # all hexagonal numbers are also triangular
    # 1 = T_1 = H_1, 6 = T_3 = H_2, 15 = T_5 = H_3, ...
    # H_n = n(2n - 1) = 2n^2 - n
    # T_(2n - 1) = (2n - 1)*((2n - 1) + 1)/2 = (4n^2 - 2n)/2 = 2n^2 - n
    
    # hexagonal numbers increase faster than pentagonal numbers
    # since 2n^2 - n > 1.5n^2 - 0.5n for n > 1
    # so it is faster to check if a known hexagonal number is also pentagonal
    
    # 40755 = T_285 = P_265 = H_143
    
    tri_pent_hex: int = 0
    n: int = 144
    
    while tri_pent_hex == 0:
        hex: int = get_hexagon(n)
        if is_pentagon(hex):
            tri_pent_hex = hex
        n += 1
    
    return tri_pent_hex
    
def get_hexagon(n: int) -> int:
    return n * (2 * n - 1)
    
def is_pentagon(p: int) -> bool:
    # p = n*(3n - 1)/2
    # 2p = 3n^2 - n
    # 3n^2 - n - 2p = 0
    # n = (1 + sqrt(1 - 4*3*-2p))/6 = (1 + sqrt(24p + 1))/6
    return (1 + sqrt(24 * p + 1)) // 6 == (1 + sqrt(24*p + 1)) / 6

if __name__ == "__main__":
    print(triangular_pentagonal_hexagonal())