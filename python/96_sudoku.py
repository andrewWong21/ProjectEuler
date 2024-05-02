def sudoku(grids: list) -> int:

    total: int = 0
    for grid in grids:
        total += corner_sum(solve(grid))
    
    return total

def solve(grid_str: str) -> str:

    # approach: iterate through each empty cell in grid, marked by a 0
    # test valid candidates and continue until grid becomes impossible (empty set for cell's corresponding row, column, and box)
    # or end of grid is reached with filled-in grid marked as valid under sudoku rules
    
    # potential issues: recursion limit, implementing backtracking after tested value for cell results in invalid grid

    # unpack string into 2D array
    grid = []
    
    # keep track of used numbers in given row, column, and box
    rows  = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]
    cols  = [set() for _ in range(9)]
    
    return grid_str
    
def corner_sum(grid_str: str) -> int:
    return int(grid_str[0:3]) + int(grid_str[27:30]) + int(grid_str[54:57])

if __name__ == "__main__":
    grids = []
    
    # f = open("96_sudoku.txt", 'r')
    # lines = f.readlines()
    # for i in range(0, len(lines), 10):
        # grids.append("".join([row.strip() for row in lines[i+1:i+10]]))
    # f.close()
    # grids = grids[:1]
    
    grids.append("003020600900305001001806400008102900700000008006708200002609500800203009005010300")
    
    print(sudoku(grids))
