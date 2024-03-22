def lychrel_numbers() -> int:
    
    count: int = 0
    
    for n in range(1, 10_001):
        if is_lychrel(n):
            count += 1
    return count
    
def is_lychrel(num) -> bool:
    for i in range(1, 51):
        sum = num + int(str(num)[::-1])
        if str(sum) == str(sum)[::-1]:
            return False
        num = sum
    return True

if __name__ == "__main__":
    print(lychrel_numbers())