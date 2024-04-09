def digit_factorial_chains() -> int:
    count: int = 0
    
    for i in range(1, 1_000_000):
        if get_chain_length(i) == 60:
            count += 1
    
    return count
    
def get_chain_length(n: int) -> int:
    seen = set()
    fact = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
    
    while True:
        seen.add(n)
        fact_sum = sum(fact[int(c)] for c in str(n))
        if fact_sum in seen:
            return len(seen)
        n = fact_sum

if __name__ == "__main__":
    print(digit_factorial_chains())