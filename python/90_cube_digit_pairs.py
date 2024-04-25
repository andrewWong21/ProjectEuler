from itertools import combinations

def cube_digit_pairs() -> int:
    squares =  ["01", "04", "09", "16", "25", "36", "49", "64", "81"]
    sides = [comb for comb in combinations(range(10), 6)]
    distinct_arrs = 0
    
    
    for idx, perm1 in list(enumerate(sides)):
        for perm2 in sides[idx:]:
            ext_set1 = set(perm1)
            if 6 in ext_set1 or 9 in ext_set1:
                ext_set1.update([6, 9])
            
            ext_set2 = set(perm2)
            if 6 in ext_set2 or 9 in ext_set2:
                ext_set2.update([6, 9])
                
            if all(possible_pair(ext_set1, ext_set2, sq) for sq in squares):
                distinct_arrs += 1
    return distinct_arrs
    
def possible_pair(s1: set, s2: set, sq: str) -> bool:
    return (int(sq[0]) in s1 and int(sq[1]) in s2) or (int(sq[1]) in s1 and int(sq[0]) in s2)

if __name__ == "__main__":
    print(cube_digit_pairs())
