import itertools

def arithmetic_expressions() -> str:

    digit_str: str = ""
    max_streak = 0
    
    # using combinations for increasing subsequences of digits
    for digits in itertools.combinations(range(10), 4):
        
        # calculate longest set of consecutive integers in results
        streak = get_streak(eval_exps(digits))
        
        if streak > max_streak:
            # update max streak and digit string if new longest streak found
            digit_str = "".join([str(d) for d in digits])
            max_streak = streak
    return digit_str

def eval_exps(d) -> list:
    # store obtained positive integer results for a given set of digits
    results = set()
    # list of possible groupings of parentheses
    groups = [
        "(xox)oxox", "xo(xox)ox", "xoxo(xox)", "(xox)o(xox)",
        "(xoxox)ox", "xo(xoxox)",
        "((xox)ox)ox", "(xo(xox))ox", "xo((xox)ox)", "xo(xo(xox))",
        "xoxoxox"
    ]
    
    for digits in itertools.permutations(d):
        # sample 3 operations with replacement from 4 possible operations
        # itertools.permutations() is not suitable: element can be used multiple times
        # itertools.combinations_with_replacement() is not suitable: order does matter
        for ops in itertools.product(["*", "/", "+", "-"], repeat=3):
            for group in groups:
                try:
                    # evaluate expression after substituting digits and operations
                    result = eval(build_exp(digits, ops, group))
                    rounded = int(result)
                    # only consider integer results
                    if result > 0 and rounded == result:
                        if rounded not in results:
                            results.add(rounded)
                # catch division by zero
                except ZeroDivisionError:
                    continue
    return sorted(list(results))

def build_exp(digits: list, ops: list, group: str) -> str:
    expression = ""
    digit, op = 0, 0
    
    for c in group:
        if c == 'x': # digit
            # force float division
            expression += str(float(digits[digit]))
            digit += 1
        elif c == 'o': # operation
            expression += ops[op]
            op += 1
        else:
            expression += c
    return expression

def get_streak(nums: list) -> int:
    # get length of streak of consecutive integers starting from 1
    streak: int = 0
    for i in range(len(nums)):
        if nums[i] == i + 1:
            streak += 1
        else:
            break
    return streak
    
if __name__ == "__main__":
    print(arithmetic_expressions())
