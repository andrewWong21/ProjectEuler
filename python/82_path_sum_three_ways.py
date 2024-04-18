def path_sum_three_ways(matrix: list) -> int:
    r = len(matrix)
    c = len(matrix[0])
    min_sums = [matrix[row][0] for row in range(r)]
    
    for col in range(1, c):
        for row in range(0, r):
            # calculate path sum after moving right
            min_sums[row] += matrix[row][col] 
            
            if row > 0:
                # compare with path sum after moving down
                min_sums[row] = min(min_sums[row], min_sums[row - 1] + matrix[row][col])
        
        for row in range(r - 2, -1, -1):
            # compare with path sum after moving up
            min_sums[row] = min(min_sums[row], min_sums[row + 1] + matrix[row][col])
    
    return min(min_sums)
    

if __name__ == "__main__":
    f = open("82_matrix.txt", 'r')
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
    
    print(path_sum_three_ways(matrix))
