def champernownes_constant() -> int:
    #           1-9: d1      to d9
    #         10-99: d10     to d189     (2 * (99 - 9))         = 180
    #       100-999: d190    to d2889    (3 * (999 - 99))       = 2700
    #     1000-9999: d2890   to d38889   (4 * (9999 - 999))     = 36000
    #   10000-99999: d38890  to d488889  (5 * (99999 - 9999))   = 450000
    # 100000-999999: d488890 to d5888889 (6 * (999999 - 99999)) = 5400000
    
    # d1 = 1, d10 = 1
    product: int = 1
    starts = [1, 10, 190, 2890, 38890, 488890, 5888890]
    
    for pos in [1, 10, 100, 1000, 10000, 100000, 1000000]:
        # given the nth position, determine the number of digits
        # each number in that position's group has
        # e.g. position 10000 is in the range (2890, 38890), so
        # it is located in the group of 4-digit numbers
        num_digits = 0
        while pos >= starts[num_digits]:
            num_digits += 1
        # pos = 10000, num_digits = 4
        
        # given the number group, determine the number
        # in the group that contains the given position
        start_pos = starts[num_digits - 1]
        k = (pos - start_pos) // num_digits
        n = int(10 ** (num_digits - 1)) + k
        # start_pos = 2890, k = 7110 // 4 = 1777, n = 1000 + 1777 = 2777
        
        # given the number containing the position, determine
        # which digit of the number corresponds to the position
        digit_pos = pos - (start_pos + num_digits * k)
        digit = int(str(n)[digit_pos])
        # digit_pos = 10000 - (2890 + 4 * 1777) = 2
        # digit at index digit_pos of n --> digit at index 2 of 2777 (zero-indexed)
        # digit = 7
        
        product *= digit
    
    return product

if __name__ == "__main__":
    print(champernownes_constant())