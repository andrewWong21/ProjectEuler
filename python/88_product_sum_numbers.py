from math import sqrt

def product_sum_numbers(maxK: int) -> int:

    # find the sum of the set of numbers N where N is the minimal product/sum of 
    # a set of k natural numbers where 2 <= k <= 12000 that sum to and multiply to N
    
    # a set of size k has a minimal product-sum number of at most 2*k
    # k * 2 * 1 * 1 * 1 * ... * 1 = k + 2 + (k-2) * 1 = 2*k
    
    # k = 2:  4 = 2 * 2                 = 2 + 2
    # k = 3:  6 = 1 * 2 * 3             = 1 + 2 + 3
    # k = 4:  8 = 1 * 1 * 2 * 4         = 1 + 1 + 2 + 4
    # k = 5:  8 = 1 * 1 * 2 * 2 * 2     = 1 + 1 + 2 + 2 + 2
    # k = 6: 12 = 1 * 1 * 1 * 1 * 2 * 6 = 1 + 1 + 1 + 1 + 2 + 6
    
    # min_psns[k] = minimal product-sum number N for a set of k natural numbers
    min_psns = [0 for _ in range(maxK + 1)]
    
    # store factorizations of numbers up to 2k
    # factorizations[x] = list of factorizations of x
    factorizations = [[], []] 
    
    # iterate over values of N up to 2*k
    for idx in range(2, 2 * maxK + 1):
    
        factors = []
        # single-number factorization used as basis for factorization of larger numbers
        factors.append([idx])
        
        # build factorizations of idx by prepending smaller numbers to known factorizations
        for f in range(2, int(sqrt(idx)) + 1):
            if idx % f == 0:
                # iterate over factorizations of (idx / f)
                for fact in factorizations[idx // f]:
                    prependable = True
                    for num in fact:
                        if num < f:
                            prependable = False
                            break
                    
                    # prepend new smallest factor f to complete new factorization of idx
                    if prependable:
                        new_fact = [f] + fact
                        factors.append(new_fact)
        
        factorizations.append(factors)
    
    # iterate through factorizations
    for n, fact_list in list(enumerate(factorizations)):
        for fact in fact_list:
            # the factorization of a minimal product-sum number n cannot contain n itself as n + 1 > n * 1
            # factorization must be composed of numbers strictly less than n, so it must be of at least length 2
            if len(fact) < 2:
                continue
            
            # sum of factors must be less than n to be able to pad with ones
            # to create a set of k natural numbers that both sum and multiply to n
            # the number of ones is equal to n minus the sum of the integers in its factorization
            if sum(fact) <= n:
                k = len(fact) + n - sum(fact)
                
                # mark n as the minimal product-sum number for k natural numbers
                # n is guaranteed to be minimal if min_psns[k] has not already been found
                if k <= maxK and min_psns[k] == 0:
                    min_psns[k] = n
    
    return sum(set(min_psns))

if __name__ == "__main__":
    print(product_sum_numbers(12_000))
