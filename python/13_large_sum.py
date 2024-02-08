if __name__ == "__main__":
    f = open("13_largesum.txt", 'r')
    sum: int = 0
    for line in f.readlines():
        sum += int(line.strip())
    print(str(sum)[:10])