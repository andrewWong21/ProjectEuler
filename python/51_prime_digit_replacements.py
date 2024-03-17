def prime_digit_replacements() -> int:
    primes = []
    
    sieved = [False] * 1_000_000
    for i in range(2, 1_000_000):
        if not sieved[i]:
            for j in range (2*i, 1_000_000, i):
                sieved[j] = True
            if i >= 1000:
                primes.append(i)
    
    primes_set = set(primes)
    
    # prime value family can only have at least 8 members if
    # the number of digits replaced is a multiple of 3
    # mod 3 of digit sum of 0,   1,   2,   3,   ...: 0, 1, 2, 0, 1, 2, ...
    # mod 3 of digit sum of 00,  11,  22,  33,  ...: 0, 2, 1, 0, 2, 1, ...
    # mod 3 of digit sum of 000, 111, 222, 333, ...: 0, 0, 0, 0, 0, 0, ...
    
    # ten possible digit replacements for each mask
    # modulus of digits not replaced N does not change
    # modulus of D new digits R will be 0, 1, or 2 at least 3 times if D mod 3 != 0
    # (N + R) mod 3 will always be 0 at least 3 times if D mod 3 != 0
    # at least 3 of the 10 results after replacement will be divisible by 3, so at most 7 results can be prime
    # so D must be divisible by 3 if the resulting family has at least 8 members
    
    # since at least 3 digits must be replaced, minimum prime has at least 4 digits
    
    masks4 = ["***.", "**.*", "*.**", ".***"] # 4C3 = 4
    masks5 = [
        "***..", "**.*.", "**..*", "*.**.", "*.*.*", 
        "*..**", ".***.", ".**.*", ".*.**", "..***"
    ] # 5C3 = (5 * 4) / 2 = 10
    masks6 = [
        "***...", "**.*..", "**..*.", "**...*", "*.**..", 
        "*.*.*.", "*.*..*", "*..**.", "*..*.*", "*...**",
        ".***..", ".**.*.", ".**..*", ".*.**.", ".*.*.*", 
        ".*..**", "..***.", "..**.*", "..*.**", "...***"
    ] # 6C3 = (6 * 5 * 4) / (3 * 2) = 20
    
    ans = 0
    for prime in primes:
        prime_str = str(prime)
        masks = []
        if len(prime_str) == 4:
            masks = masks4
        elif len(prime_str) == 5:
            masks = masks5
        else:
            masks = masks6
        
        for mask in masks:
            family = []
            for digit in range(0, 10):
                new_num = replace_digits(prime, mask, digit)
                if new_num in primes_set:
                    family.append(new_num)
            if len(family) == 8:
                return sorted(family)[0]
    
    return -1
    
def replace_digits(num: int, mask: str, digit: int) -> int:
    replaced = ""
    for i in range(0, len(mask)):
        if mask[i] == '*':
            replaced += str(digit)
        else:
            replaced += str(num)[i]
    return int(replaced)

if __name__ == "__main__":
    print(prime_digit_replacements())