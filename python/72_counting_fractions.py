from math import floor

def counting_fractions(n: int) -> int:
    # d = 2: 1 fraction  (1)
    # d = 3: 2 fractions (1, 2)               total 3
    # d = 4: 2 fractions (1, 3)               total 5
    # d = 5: 4 fractions (1, 2, 3, 4)         total 9
    # d = 6: 2 fractions (1, 5)               total 11
    # d = 7: 6 fractions (1, 2, 3, 4, 5, 6)   total 17
    # d = 8: 4 fractions (1, 3, 5, 7)         total 21
    
    # the set of reduced proper fraction for d <= n
    # has totient(n) more fractions than the set of reduced fractions for d <= n - 1
    
    totients = list(range(n + 1))
    
    for i in range(1, n + 1):
        for j in range(2*i, n + 1, i):
            totients[j] -= totients[i]
    
    return sum(t for t in totients[2:])
    
if __name__ == "__main__":
    # print(counting_fractions(8))
    print(counting_fractions(1_000_000))