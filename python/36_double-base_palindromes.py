def double_base_palindromes(n: int) -> int:
    sum: int = 0
    
    for i in range(1, n):
        if is_palindrome(str(i)) and is_palindrome(bin(i)[2:]):
            sum += i
    return sum
    
def is_palindrome(s: str) -> bool:
    return s == s[::-1]
    

if __name__ == "__main__":
    print(double_base_palindromes(1_000_000))