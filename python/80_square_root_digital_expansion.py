from math import sqrt
import decimal

def square_root_digital_expansion() -> int:
    
    total: int = 0
    # calculate square roots to precision slightly beyond 100 digits to prevent rounding errors
    decimal.getcontext().prec = 102
    
    for i in range(1, 101):
        # consider irrational square roots only
        if sqrt(i) == int(sqrt(i)):
            continue
        
        # remove decimal point from string representation
        digits = "".join(str(decimal.Decimal(i).sqrt()).split("."))
        
        # add first 100 digits of square root
        for chr in digits[:100]:
            total += int(chr)

    return total

if __name__ == "__main__":
    print(square_root_digital_expansion())
