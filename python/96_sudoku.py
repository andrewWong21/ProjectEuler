def sudoku(boards: list) -> int:
    total: int = 0
    for board in boards:
        solve(board)
        # add 3-digit number at top left corner of solved board to total
        total += board[0][0] * 100 + board[0][1] * 10 + board[0][2]
    return total

def solve(board) -> bool:
    for r in range(9):
        for c in range(9):
            if board[r][c] == 0: # empty cell
                for d in range(1, 10):
                    # check if digit d can be placed at board[r][c]
                    if check(board, r, c, d):
                        board[r][c] = d
                        if solve(board):
                            return True
                        else:
                            board[r][c] = 0
                # current board state is not solvable
                # backtrack to earlier filled position
                return False
    return True
    
def check(board, r, c, d) -> bool:
    # digit d cannot be placed at board[r][c] 
    # if it already exists in the same row or column
    if any([board[i][c] == d for i in range(9)]) or any([board[r][j] == d for j in range(9)]):
        return False
    # check if other cells in same box as board[r][c] already contain digit d
    top, left = 3 * (r // 3), 3 * (c // 3)
    if any(board[row][col] == d for row in range(top, top + 3) for col in range(left, left + 3)):
        return False
    # digit d can be placed at board[r][c] without conflicts
    return True
    
if __name__ == "__main__":
    boards = []
    
    f = open("96_sudoku.txt", 'r')
    lines = f.readlines()
    board = []
    for line in lines:
        # skip lines with "Grid"
        if "Grid" not in line:
            # convert string into list of ints
            board.append([ord(c) - ord('0') for c in line.strip()])
            if len(board) == 9: # one sudoku grid formatted
                boards.append(board)
                board = []
    f.close()
    print(sudoku(boards))
