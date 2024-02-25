def distinct_powers() -> int:
    num: int = 99 * 99
    # a**b is a duplicate of another power if a itself is a perfect power
    
    # simple squares: 4, 9, 25, 36, 49, 100 (b = 2, 3, 4, ..., 50)
    # 4^2 = 2^4, 4^3 = 2^6, ..., 4^50 = 2^100, ..., 100^50 = 10^100 (49 values of b)
    num -= 6*49
    
    # simple cubes: 8, 27 (duplicates of a^(1/3), a^(2/3))
    # 8^2  = 2^6,  8^3  = 2^9,  ..., 8^33 = 2^99 (32 values of b)
    # 8^34 = 4^51, 8^36 = 4^54, ..., 8^66 = 4^99 (17 values of b)
    num -= 2*49
    
    # fourth powers: 16, 81 (duplicates of a^(2/4), a^(3/4))
    # 16^2  = 4^4,  16^3  = 4^6,  ..., 16^50 = 4^100 (49 values of b)
    # 16^51 = 8^68, 16^54 = 8^72, ..., 16^75 = 8^100  (9 values of b)
    num -= 2*58
    
    # fifth powers: 32 (duplicates of a^(1/5), a^(2/5), a^(3/5), a^(4/5))
    # 32^2  =  2^10, 32^3  =  2^15, ..., 32^20 =  2^100   (19 values of b)
    # 32^22 =  4^55, 32^24 =  4^60, ..., 32^40 =  4^100  (+10 values of b)
    # 32^21 =  8^35, 32^27 =  8^45, ..., 32^60 =  8^100  (+11 values of b)
    # 32^44 = 16^55, 32^52 = 16^65, ..., 32^80 = 16^100   (+8 values of b)
    num -= 48
    
    # sixth powers: 64 (duplicates of a^(1/6), a^(2/6), a^(5/6))
    # 64^2  =  8^4,  64^3 =   8^6,  ..., 64^50 = 8^100 (49 values of b)
    # 64^52 = 16^78, 64^54 = 16^81, ..., 64^66 = 16^99 (+8 values of b)
    # 64^55 = 32^66, 64^60 = 32^72, ..., 64^80 = 32^96 (+6 values of b)
    num -= 62
    
    return num

if __name__ == "__main__":
    print(distinct_powers())