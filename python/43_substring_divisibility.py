def substring_divisibility() -> int:
    # 0-9 pandigital number abcdefghjij
    # bcd % 2 = 0,  cde % 3 = 0,  def % 5 = 0, efg % 7 = 0, 
    # fgh % 11 = 0, ghi % 13 = 0, hij % 17 = 0
    
    # since def % 5 = 0, f must be 0 or 5
    # if f = 0, fgh must be 0gh and a multiple of 11
    # all possible values for 0gh % 11 = 0 have repeating digits (011, 022, 033, ... 099)
    # so f must be 5 for the full number to be pandigital
    
    # possible values for 5gh: 506, 517, 528, 539, 561, 572, 583, 594
    # ghi % 13 = 0
    # 06i: 065, but f = 5 so fghi becomes 5065 which has a repeating digit
    # 17i: no solution since 169 and 182 are consecutive multiples of 13
    # 61i: 611 has a repeating digit
    # 94i: 949 has a repeating digit
    
    # possible values for fghi: 5286, 5390, 5728, 5832
    # hij % 17 = 0
    # 32j: 323 has a repeating digit
    
    # possible values for fghij: 52867, 53901, 57289
    # efg % 7 = 0
    # e52: 252 has a repeating digit, 952
    # e53: 553 has a repeating digit
    
    # possible values for efghij: 952867, 357289
    # bcd % 2 = 0, d % 2 = 0
    # d952867: d = 0, 4
    # d357289: d = 0, 4, 6
    
    # possible values for defghij: 0952867, 4952867, 0357289, 4357289, 6357289
    # cde % 3 = 0
    # c0952867: c = 3
    # c4952867: no solution (2, 5, 8 already used)
    # c0357289: c = 6
    # c4357289: no solution (2, 5, 8 already used)
    # c6357289: c = 0
    # possible values for cdefghij: 30952867, 60357289, 06357289
    # remaining digits: 1, 4
    
    # all possible numbers that meet the given conditions
    # are of the form ab30952867, ab60357289, ab06357289
    # where ab = 14 or ab = 41
    
    sum: int = 0
    for s in ["30952867", "60357289", "06357289"]:
        sum += int("14" + s)
        sum += int("41" + s)
    return sum

if __name__ == "__main__":
    print(substring_divisibility())