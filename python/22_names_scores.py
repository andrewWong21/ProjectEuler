def names_scores(names: list) -> int:
    sum: int = 0
    # iterate over list of names
    for i in range(0, len(names)):
        # iterate over characters in name
        for j in range(0, len(names[i])):
            # letter score: ord(letter) - ord('A') + 1
            # A -> 1, B -> 2, C -> 3, ..., Z -> 26
            # multiply letter score by alphabetical position of name in list, i + 1
            sum += (ord(names[i][j]) - ord('A') + 1) * (i + 1)
    return sum

if __name__ == "__main__":
    f = open("22_names.txt", 'r')
    # names are stored as a comma separated list on a single line
    names = f.read().replace("\"", "").strip().split(",")
    f.close()
    print(names_scores(sorted(names)))