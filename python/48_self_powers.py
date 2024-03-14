def self_powers() -> int:
    total_sum: int = sum([n ** n for n in range(1, 11)])
    
    for n in range(11, 1001):
        total_sum += (n ** n) % (10 ** 10)
    
    return total_sum % (10 ** 10)

if __name__ == "__main__":
    print(self_powers())