def roman_numerals(numerals: list) -> int:
    groups = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
    counts = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    
    saved: int = 0
    for num in numerals:
        old_len = len(num)
        total = 0
        
        for idx, group in list(enumerate(groups)):
            while num.startswith(group):
                num = num[len(group):]
                total += counts[idx]
        
        new_rep = ""
        for idx, count in list(enumerate(counts)):
            while total >= count:
                total -= count
                new_rep += groups[idx]
        
        saved += old_len - len(new_rep)
    return saved

if __name__ == "__main__":
    f = open("89_roman.txt", 'r')
    numerals = [num.strip() for num in f.readlines()]
    f.close()
    
    print(roman_numerals(numerals))
