def maximum_path_sum(triangle) -> int:
    length: int = len(triangle)
    dp = [[0 for i in range(0, length)] for j in range(0, length)]
    return helper(triangle, dp, 0, 0)
    
def helper(triangle, dp, i: int, j: int) -> int:
    if i == len(dp) - 1:
        return triangle[i][j]
    if dp[i][j] != 0:
        return dp[i][j]
    down: int = helper(triangle, dp, i + 1, j)
    diag: int = helper(triangle, dp, i + 1, j + 1)
    dp[i][j] = triangle[i][j] + max(down, diag)
    return dp[i][j]

if __name__ == "__main__":
    f = open("18_maximumpathsum.txt", 'r')
    triangle = []
    for line in f.readlines():
        triangle += [[int(num) for num in line.strip().split()]]
    f.close()
    print(maximum_path_sum(triangle))