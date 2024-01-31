from math import sqrt

def is_palindrome(n: int):
    s = str(n)
    return s == s[::-1]

def largest_palindrome_product():
    max_palindrome = 0
    # The largest palindrome product of two 3-digit numbers has 6 digits, since
    # the maximum product of two 3-digit numbers is 999 * 999 = 998001
    # and the palindrome 101101 = 1001 * 101 = (11 * 91) * 101 = 11 * 13 * 7 * 101 = 143 * 707.
    
    # The 6-digit palindrome can be represented as xyzzyx.
    # The alternating sum of its digits is x - y + z - x + y - z = 0, so it is divisible by 11.
    # Then one of the 3-digit numbers used in the product must also be divisible by 11.
    
    for i in range(990, 100, -11):
        for j in range (999, 100, -1):
            product = i*j
            if (is_palindrome(product) and product > max_palindrome):
                max_palindrome = product
    
    return max_palindrome
    
if __name__ == "__main__":
    print("Largest palindrome product made from two 3-digit numbers:", largest_palindrome_product())