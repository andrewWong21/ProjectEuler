def largest_product(grid: list) -> int:
    max_product: int = 0
    
    # horizontal products starting from leftmost element
    for i in range(0, len(grid)):
        for j in range(0, len(grid[0]) - 4):
            product = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3]
            max_product = max(max_product, product)
    
    # vertical products starting from top element
    for i in range(0, len(grid) - 4):
        for j in range(0, len(grid[0])):
            product = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j]
            max_product = max(max_product, product)
    
    # left-diagonal products starting from top left
    for i in range(0, len(grid) - 4):
        for j in range(0, len(grid[0]) - 4):
            product = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3]
            max_product = max(max_product, product)
    
    # right-diagonal products starting from top right
    for i in range(0, len(grid) - 4):
        for j in range(4, len(grid[0])):
            product = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3]
            max_product = max(max_product, product)
    
    return max_product
 
if __name__ == "__main__":
    f = open("11_largestproduct.txt", 'r')
    grid = []
    for line in f.readlines():
        grid.append([int(num) for num in line.strip().split(" ")])
    f.close()
    print("Largest product in grid:", largest_product(grid))