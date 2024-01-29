def sum_even_fib(n: int):
    sum: int = 0
    fibs = [0, 1]
    while fibs[1] < 4_000_000:
        fibs[0], fibs[1] = fibs[1], fibs[0] + fibs[1]
        if (fibs[1] % 2 == 0):
            sum += fibs[1]
    
    print("Sum of even Fibonacci numbers under 4 million:", sum)
    
if __name__ == "__main__":
    sum_even_fib(4_000_000)