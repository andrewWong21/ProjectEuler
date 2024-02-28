def digit_cancelling_fractions() -> int:
    # non-trivial examples of digit-cancelling fractions
    # have the cancelled digit in different places
    # e.g. 49/98 = 4/8 is non-trivial, 30/50 = 3/5 is trivial
    num_product: int = 1
    den_product: int = 1
    
    for num in range(10, 99):
        for den in range(num + 1, 99):
            if num % 10 != den // 10:
                continue # cannot cancel ones digit of num with tens digit of den
            if num % 10 == 0 or den % 10 == 0:
                continue # cancellation results in zero numerator or denominator
            
            new_num: int = num // 10 # tens digit of num
            new_den: int = den % 10  # ones digit of den
            
            if num / den == new_num / new_den:
                num_product *= new_num
                den_product *= new_den
    
    return den_product // gcf(num_product, den_product)
    
def gcf(a: int, b: int) -> int:
    if a % b == 0:
        return b
    return gcf(b, a % b)

if __name__ == "__main__":
    print(digit_cancelling_fractions())