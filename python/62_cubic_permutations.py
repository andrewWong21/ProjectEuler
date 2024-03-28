def cubic_permutations() -> int:
    
    cubes_dict = {}
    
    for i in range(1, 10000):
        cube = i ** 3
        digits = "".join(sorted(str(cube)))
        if digits in cubes_dict:
            cubes_dict[digits].append(cube)
        else:
            cubes_dict[digits] = [cube]
    
    for i in range(1, 10000):
        digits = "".join(sorted(str(i ** 3)))
        if len(cubes_dict[digits]) == 5:
            return i ** 3
    
    return 0
    
if __name__ == "__main__":
    print(cubic_permutations())