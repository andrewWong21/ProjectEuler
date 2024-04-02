def maximum_path_sum(triangle: list) -> int:
    
    # build the maximum path sum from the bottom of the triangle
    # maximum path sum starting at a node is equal to the value at that node
    # plus the larger of the maximum path sums that start at its left and right children
    
    for n in range(len(triangle) - 2, -1, -1):
        for i in range(0, len(triangle[n])):
            triangle[n][i] += max(triangle[n + 1][i], triangle[n + 1][i + 1])
        
    return triangle[0][0]
    
if __name__ == "__main__":
    f = open("67_triangle.txt", 'r')
    triangle = []
    for line in f.readlines():
        triangle.append([int(num) for num in line.strip().split(" ")])
    
    print(maximum_path_sum(triangle))