from math import sqrt

def coded_triangle_numbers(words) -> int:
    count: int = 0
    
    for word in words:
        sum: int = 0
        for chr in word:
            sum += ord(chr) - ord('A') + 1
        
        if is_triangle_number(sum):
            count += 1
    
    return count
    
def is_triangle_number(t: int) -> bool:
    # t = 1/2 * n * (n + 1)
    # 2t = n^2 + n
    # n^2 + n - 2t = 0
    # n = (-1 + sqrt(1 - 4*1*-2t))/2 = (-1 + sqrt(8t + 1))/2
    
    res = (-1 + sqrt(8*t + 1)) / 2
    return res == int(res)

if __name__ == "__main__":
    f = open("42_words.txt", 'r')
    words = []
    for line in f.readlines():
        words.extend(line.replace('"', "").split(","))
    f.close()
    
    print(coded_triangle_numbers(words))