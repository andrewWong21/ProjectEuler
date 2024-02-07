from math import sqrt

def highly_divisible_triangle(n: int) -> int:
    divs: int = 0
    t: int = 0
    i: int = 1
    # T_n = n(n + 1)/2 = 1 + 2 + 3 + ... + n
    while divs < n:
        t = i * (i + 1) // 2
        i += 1
        divs = get_divisors(t)
    return t

def get_divisors(n: int) -> int:
    divs: int = 0
    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            divs += 2

    if sqrt(n) == int(sqrt(n)):
        divs -= 1
    return divs

if __name__ == "__main__":
    print("First triangle number with over 500 divisors:", highly_divisible_triangle(500))