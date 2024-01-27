def get_multiples(n: int):
    sum: int = 0
    
    # get number of multiples of 3 or 5 from 1 to n, exclusive
    mults3 = (n - 1) // 3
    mults5 = (n - 1) // 5
    
    # get sum of multiples of x by getting the product of x and the sum of 1 to m,
    # where m is the number of multiples of x calculated above
    sum += 3 * mults3 * (mults3 + 1) // 2
    sum += 5 * mults5 * (mults5 + 1) // 2
    
    # subtract multiples of 15 to avoid double-counting
    mults15 = (n - 1) // 15
    sum -= 15 * mults15 * (mults15 + 1) // 2
    
    print("Sum of multiples of 3 or 5 under 1000:", sum)
    
if __name__ == "__main__":
    get_multiples(1000)