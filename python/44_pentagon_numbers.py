from math import sqrt

def pentagon_numbers() -> int:
    # consider two pentagon numbers P_j and P_k, k > j, k = j + x
    # where D = P_k - P_j = (j * (3*j - 1)) / 2 - (k * (3*k - 1)) / 2
    # D = (3k^2 - k - 3j^2 + j) / 2
    # D = (3j^2 + 3x^2 + 6jx - j - x - 3j^2 + j) / 2
    # D = (3x^2 + 6jx - x) / 2 = 3jx + (3x^2 - x) / 2 = 3jx + (P_x)
    # D = 3jx + P_x
    # j = (D - P_x) / (3 * x)
    # D is a pentagon number, so D = P_(x + n)
    
    # given D as the difference of two pentagonal numbers, test values of j, x, and n
    # until a corresponding k is found where pent_j + pent_k is pentagonal
    
    min_diff: int = 0
    
    n: int = 4
    while min_diff == 0:
        pent_d = get_pentagon(n)
        
        for x in range(1, n):
            pent_x = get_pentagon(x)
            if (pent_d - pent_x) % (3 * x) == 0: 
                j = (pent_d - pent_x) // (3 * x)
                pent_j = get_pentagon(j)
                pent_k = get_pentagon(j + x)
                
            if is_pentagon(pent_j + pent_k):
                min_diff = pent_d
                break
        n += 1
        
    return min_diff
    
def get_pentagon(n: int) -> int:
    p = n * (3 * n - 1) // 2

    return p
    
def is_pentagon(p: int) -> bool:
    # p = n*(3n - 1)/2
    # 2p = 3n^2 - n
    # 3n^2 - n - 2p = 0
    # n = (1 + sqrt(1 - 4*3*-2p))/6 = (1 + sqrt(24p + 1))/6
    return (1 + sqrt(24 * p + 1)) // 6 == (1 + sqrt(24*p + 1)) / 6

if __name__ == "__main__":
    print(pentagon_numbers())