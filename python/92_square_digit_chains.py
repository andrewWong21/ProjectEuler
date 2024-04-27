def square_digit_chains(max_n: int) -> int:

    count: int = 0
    known = {89}
    
    for n in range(1, max_n + 1):
        result = n
        ends_at_89 = True
        chain = set()
        
        while True:
            result = sum([int(c) ** 2 for c in str(result)])
            chain.add(result)
            if result in known:
                known.update(chain)
                break
            if result == 1:
                ends_at_89 = False
                break
        
        if ends_at_89:
            count += 1
    
    return count
    
if __name__ == "__main__":
    print(square_digit_chains(10_000_000))
