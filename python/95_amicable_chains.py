from math import sqrt

def amicable_chains(max_num: int) -> int:
    
    max_len: int = 0
    min_term: int = 0
    ones = set()
    
    for n in range(12496, max_num + 1):
    
        chain = set()
        div_sum: int = n
        exceeded: bool = False
        
        while div_sum not in chain:
            chain.add(div_sum)
            div_sum = divisor_sum(div_sum)
            
            # term in chain exceeds 1 million
            if div_sum > max_num:
                exceeded = True
                break
            
            # chain goes to one
            if div_sum == 1 or div_sum in ones:
                ones.update(chain)
                break
        
        if not exceeded and div_sum == n:
            if len(chain) > max_len:
                max_len = len(chain)
                min_term = min(chain)
    
    return min_term

def divisor_sum(num: int) -> int:
    sum: int = 1
    for i in range(2, int(sqrt(num)) + 1):
        if num % i == 0:
            sum += i + (num // i)
    
    if sqrt(num) == int(sqrt(num)):
        sum -= int(sqrt(num))
    return sum

if __name__ == "__main__":
    print(amicable_chains(1_000_000))
