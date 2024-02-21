def reciprocal_cycles(n: int) -> int:
    max_length: int = 0
    max_num: int = 0
    for i in range(2, n):
        c = cycle(i)
        if c > max_length:
            max_num, max_length = i, c
    return max_num

def cycle(den: int) -> int:
    remainders = {} # use dict for fast lookup of remainder and its first occurrence
    rem = 1
    count = 0
    while rem != 0:
        rem = rem * 10 % den
        if rem in remainders:
            # cycle length is current decimal place - last decimal place remainder was seen
            return count - remainders[rem]
        else: # save new remainder in dict
            remainders[rem] = count
            count += 1
    return 0

if __name__ == "__main__":
    print(reciprocal_cycles(1000))