def fibonacci(n: int) -> int:
    fibs = [0, 1]
    idx: int = 1
    while len(str(fibs[1])) < n:
        fibs[0], fibs[1] = fibs[1], fibs[0] + fibs[1]
        idx += 1
    return idx

if __name__ == "__main__":
    print(fibonacci(1000))