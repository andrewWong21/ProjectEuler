import itertools

def arithmetic_expressions() -> str:

    digit_str: str = ""
    max_streak = 0
    
    # for m in range(0, 1):
    for digits in itertools.permutations(range(0, 10), 4):
        # digits = [1, 2, 3, 4]
        
        if digits[0] >= digits[1] or digits[1] >= digits[2] or digits[2] >= digits[3]:
            continue
        
        results = set()
        # generate all possible positive integer results and store in results
        # pick 3 out of 4 operations with replacement
        for ops in itertools.combinations_with_replacement(["*", "/", "+", "-"], 3):
            # print(digits, ops)
            results.update(eval_exps(digits, ops))
        
        # calculate longest set of consecutive integers in results
        
        streak = longest_streak(sorted(list(results)))
        #print(digits, len(results), streak)
        
        # update max streak and digit string if new longest streak found
        if streak > max_streak:
            digit_str = "".join([str(d) for d in digits])
            max_streak = streak

    return digit_str
    
def eval_exps(d, ops) -> set:
    results = set()
    # list possible groupings of parentheses
    parens = [
        "(xox)oxox", "xo(xox)ox", "xoxo(xox)", "(xox)o(xox)",
        "(xoxox)ox", "xo(xoxox)",
        "((xox)ox)ox", "(xo(xox))ox", "xo((xox)ox)", "xo(xo(xox))",
        "xoxoxox"
    ]
    
    for digits in itertools.permutations(d):
        for paren in parens:
            expression = ""
            digit = 0
            op = 0
            
            for c in paren:
                if c == 'x': # digit
                    expression += str(float(digits[digit]))
                    digit += 1
                elif c == 'o': # operation
                    expression += ops[op]
                    op += 1
                else:
                    expression += c
            try:
                result = eval(expression)
                
                rounded: int = int(round(result))
                if rounded > 0 and abs(result - rounded) <= 0.005:
                    if rounded not in results:
                        # print(expression, rounded)
                        results.add(rounded)
            
            except ZeroDivisionError: 
                continue
    return results
    
def longest_streak(nums: list) -> int:
    # streak must contain consecutive integers starting from 1
    # if list does not contain 1, exit early
    if 1 not in nums:
        return 1
        
    nums = nums[nums.index(1):]

    max_streak: int = 0
    
    # increment streak from 1 until next integer is not consecutive
    for i in range(len(nums)):
        if nums[i] == i + 1:
            max_streak += 1
        else:
            break
    
    return max_streak
    
if __name__ == "__main__":
    # TODO: figure out issue with output, returns 1247 (incorrect)
    # possibly due to rounding errors or parenthesis grouping
    # print(eval(""))
    # print(eval(""))
    # print(eval(""))
    # print(eval(""))
    # print(eval(""))
    print(arithmetic_expressions())
