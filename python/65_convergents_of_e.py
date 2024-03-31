def convergents_of_e() -> int:
    # 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536
    #    2 =    1(1) +   1
    #    3 =    1(1) +   2
    #    8 =    3(2) +   2
    #   11 =    8(1) +   3
    #   19 =   11(1) +   8
    #   87 =   19(4) +  11
    #  106 =   87(1) +  19
    #  193 =  106(1) +  87
    # 1264 =  193(6) + 106
    # 1457 = 1264(1) + 193
    
    prev_num, curr_num, k = 1, 1, 1
    
    # curr_num corresponds to numerator for nth iteration
    # e.g. n = 1 -> curr_num = 2, n = 2 -> curr_num = 3, ..., n = 10 -> curr_num = 1457
    for n in range(1, 101):
        r = 1
        if n % 3 == 0:
            r = 2*k
            k += 1
        prev_num, curr_num = curr_num, curr_num * r + prev_num
        
    return sum(int(digit) for digit in str(curr_num))
    
if __name__ == "__main__":
    print(convergents_of_e())