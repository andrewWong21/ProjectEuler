from math import factorial

def lexicographic_permutations(digits, num) -> str:
    # zero-based counting - 0th permutation is lexicographically first
    if (len(digits) == 1 or num == 0):
        return digits
    # n! permutations of n digits, n groups of (n-1)! permutations
    # find which group of (n-1)! permutations the num-th permutation belongs to
    fact = factorial(len(digits) - 1)
    # this group corresponds to the index of the next digit in the num-th permutation
    rem_digits = digits[0:num // fact] + digits[num // fact + 1:]
    # append digit to answer, continue with remaining digits and reduced num
    return digits[num // fact] + lexicographic_permutations(rem_digits, num % fact)

if __name__ == "__main__":
    print(lexicographic_permutations("0123456789", 999_999))
    # 999999 // 362880 = 2 R274239, digits[2] = 2
    # 274239 //  40320 = 6 R 32319, digits[6] = 7
    #  32319 //   5040 = 6 R  2079, digits[6] = 8
    #   2079 //    720 = 2 R   639, digits[2] = 3
    #    639 //    120 = 5 R    39, digits[5] = 9
    #     39 //     24 = 1 R    15, digits[1] = 1
    #     15 //      6 = 2 R     3, digits[2] = 5
    #      3 //      2 = 1 R     1, digits[1] = 4
    #      1 //      1 = 1 R     0, digits[1] = 6
    #      0                        digits[0] = 0