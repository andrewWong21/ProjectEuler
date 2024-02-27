def pandigital_products() -> int:
    products = set()
    
    # 2-digit * 3-digit = 4-digit
    for a in range(12, 99):
        # 3-digit numbers in ranges 100-122, 988-999 have repeating digits or 0
        for b in range(123, 988):
            if is_pandigital(a, b) and a*b not in products:
                products.add(a*b)
    
    # 1-digit * 4-digit = 4-digit
    for a in range(2, 10):
        # 4-digit numbers in ranges 1000-1233, 9877-9999 have repeating digits or 0
        for b in range(1234, 9877):
            if is_pandigital(a, b) and a*b not in products:
                products.add(a*b)
    
    return sum(products)
    
def is_pandigital(a: int, b: int) -> bool:
    return sorted(str(a) + str(b) + str(a*b)) == sorted("123456789")

if __name__ == "__main__":
    print(pandigital_products())