def right_triangles_with_integer_coordinates(max_coord: int) -> int:
    triangles = set()
    for x1 in range(max_coord + 1):
        for y1 in range(max_coord + 1):
            # P(x1, y1) cannot lie at the origin
            if x1 == 0 and y1 == 0:
                continue
            for x2 in range(max_coord + 1):
                for y2 in range(max_coord + 1):
                    # Q(x2, y2) cannot lie at the origin
                    if x2 == 0 and y2 == 0:
                        continue
                    # P and Q must be distinct
                    if x2 == x1 and y2 == y1:
                        continue
                    # avoid double-counting triangles
                    if (x2, y2, x1, y1) in triangles:
                        continue
                    if is_right_triangle(x1, y1, x2, y2):
                        triangles.add((x1, y1, x2, y2))
    
    return len(triangles)
    
def is_right_triangle(x1: int, y1: int, x2: int, y2: int) -> bool:
    # calculate squares of side lengths
    s1: int = x1 * x1 + y1 * y1
    s2: int = x2 * x2 + y2 * y2
    s3: int = (y2 - y1) ** 2 + (x2 - x1) ** 2
    
    # check if an arrangement of sides fulfills a^2 + b^2 = c^2
    return (s1 + s2 == s3) or (s2 + s3 == s1) or (s1 + s3 == s2)

if __name__ == "__main__":
    print(right_triangles_with_integer_coordinates(50))
