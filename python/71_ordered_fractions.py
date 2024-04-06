from math import floor

def ordered_fractions():
    # using Stern-Brocot tree formula: given two neighboring fractions a/b and c/d,
    # the next fraction that appears between them in a Farey sequence is (a + c)/(b + d)
    # repeating this n times results in the mediant (a + c*n)/(b + d*n)
    
    a, b, c, d = 2, 5, 3, 7
    # while b + d < 1_000_000:
        # a, b = a + c, b + d
    # return a
    
    # 5 + 7*n <= 1_000_000
    # 7*n <= 1_000_000 - 5
    # n <= 999_995/7
    
    return a + c * floor((1_000_000 - b) / d)
    
if __name__ == "__main__":
    print(ordered_fractions())