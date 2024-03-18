def permuted_multiples() -> int:
    
    ans: int = 0
    n: int = 10
    
    while ans == 0:
        digits = sorted(str(n))
        found = True
        for i in range(2, 7):
            if sorted(str(n * i)) != digits:
                found = False
                break
        if found:
            return n
        n += 1
    
    return -1

if __name__ == "__main__":
    print(permuted_multiples())