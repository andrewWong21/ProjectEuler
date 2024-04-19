import heapq as hq

def path_sum_four_ways(matrix: list) -> int:
    rows = len(matrix)
    cols = len(matrix[0])
    weights = [[float("inf")] * rows for _ in range(cols)]
    weights[0][0] = matrix[0][0]
    
    # Djikstra's algorithm
    pq = [(matrix[0][0], 0, 0)]
    dirs = [-1, 0, 1, 0, -1]
    
    while len(pq) > 0:
        cell = hq.heappop(pq)
        r = cell[1]
        c = cell[2]
        
        for i in range(4):
            new_row = r + dirs[i]
            new_col = c + dirs[i + 1]
            
            if new_row < 0 or new_row >= rows or new_col < 0 or new_col >= cols:
                continue
                
            new_weight = weights[r][c] + matrix[new_row][new_col] 
            
            if new_weight < weights[new_row][new_col]:
                weights[new_row][new_col] = new_weight
                hq.heappush(pq, (new_weight, new_row, new_col))
    
    return weights[-1][-1]
    

if __name__ == "__main__":
    f = open("83_matrix.txt", 'r')
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
    
    print(path_sum_four_ways(matrix))
