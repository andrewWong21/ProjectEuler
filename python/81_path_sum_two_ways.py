def path_sum_two_ways(matrix: list) -> int:
    r = len(matrix)
    c = len(matrix[0])
    
    for row in range(0, r):
        for col in range(0, c):
            if row == 0 and col == 0: # starting cell
                continue
            elif row == 0: # can only reach cell from left neighbor
                matrix[row][col] += matrix[row][col - 1]
            elif col == 0: # can only reach cell from above neighbor
                matrix[row][col] += matrix[row - 1][col]
            else:
                matrix[row][col] += min(matrix[row][col - 1], matrix[row - 1][col])
            
    return matrix[r - 1][c - 1]
    

if __name__ == "__main__":
    f = open("81_matrix.txt", 'r')
    matrix = []
    for line in f.readlines():
        matrix.append([int(num) for num in line.strip().split(",")])
    f.close()
    
    # matrix = [
        # [131, 673, 234, 103, 18],
        # [201, 96, 342, 965, 150],
        # [630, 803, 746, 422, 111],
        # [537, 699, 497, 121, 956],
        # [805, 732, 524, 37, 331]
    # ]
    
    print(path_sum_two_ways(matrix))
