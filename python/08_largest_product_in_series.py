def largest_product(s: str) -> int:
    max_product: int = 0
    # split full string into substrings that do not contain 0
    substrings = [string for string in s.split("0") if len(string) >= 13]
    for sub in substrings:
        # check product of every contiguous sequence of 13 digits in each substring
        for i in range(0, len(sub) - 13 + 1):
            product = 1
            for j in range (i, i + 13):
                product *= ord(sub[j]) - ord('0')
            if max_product < product:
                max_product = product
    return max_product
    
if __name__ == "__main__":
    # digit string moved to separate file to avoid hanging indents from multi-line string
    f = open("08_largestproduct.txt", "r")
    s = ""
    for line in f.readlines():
        s += line.strip()
    f.close()
    print("Greatest product in 1000-digit number:", largest_product(s))