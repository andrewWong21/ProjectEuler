def square_root_convergents() -> int:
    
    # 1: 1 + 1/(2 + 0)   = 1 + 1/(1 + 1/1) = (2 + 1/1)/(1 + 1/1) = (2 + 1)/(1 + 1) = 3/2
    # 2: 1 + 1/(2 + 1/2) = 1 + 1/(1 + 3/2) = (2 + 3/2)/(1 + 3/2) = (4 + 3)/(2 + 3) = 7/5
    # 3: 1 + 1/(2 + 2/5) = 1 + 1/(1 + 7/5) = (2 + 7/5)/(1 + 7/5) = (10 + 7)/(5 + 7) = 17/12
    
    # iteration x: n/d
    # iteration x + 1: 1 + 1/(1 + n/d) = (2 + n/d)/(1 + n/d) = (2*d + n)/(d + n)
    
    count: int = 0
    n: int = 1
    d: int = 1
    
    for i in range(1, 1001):
        n, d = 2*d + n, d + n
        count += 1 if len(str(n)) > len(str(d)) else 0
    return count

if __name__ == "__main__":
    print(square_root_convergents())