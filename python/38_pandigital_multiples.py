def pandigital_multiples() -> int:
    max_product: int = 918273645
    
    for i in range(9876, 0, -1):
        product = str(i)
        n = 2
        while len(product) < 9:
            product += str(n * i)
        if len(product) != 9:
            continue
        if sorted(product) == sorted(str(max_product)) and int(product) > max_product:
            max_product = int(product)
    
    return max_product

if __name__ == "__main__":
    print(pandigital_multiples())