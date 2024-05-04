from math import log

def largest_exponential(base_exps: list) -> int:
    max_idx: int = 0
    max_res: int = 0
    
    for i in range(len(base_exps)):
        
        # b^y = x
        # log(b^y) = log(x)
        # y * log(b) = log(x)
        base_exp = base_exps[i] # [base, exponent]
        res = int(base_exp[1]) * log(int(base_exp[0]))
        
        # update 1-based line index with largest found y * log(b)
        if res > max_res:
            max_res, max_idx = res, i + 1
    
    return max_idx

if __name__ == "__main__":
    f = open("99_base_exp.txt", 'r')
    base_exps = [base_exp.strip().split(",") for base_exp in f.readlines()]
    f.close()

    print(largest_exponential(base_exps))
