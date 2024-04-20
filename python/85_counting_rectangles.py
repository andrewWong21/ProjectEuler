def counting_rectangles() -> int:
    
    result: int = 0
    area: int = 0
    
    for length in range(1, 81):
        for width in range(1, 81):
            
            count: int = 0
            
            # length * width possible types of inner rectangles
            for inner_length in range(1, length + 1):
                for inner_width in range(1, width + 1):
                    # number of valid inner rectangles is equal to
                    # number of cells that can be the top-left corner of the inner rectangle
                    
                    # e.g. 3x2 outer rectangle
                    # 1x1 rectangles: 6 = (3 - 1 + 1) * (2 - 1 + 1)
                    # 2x1 rectangles  3 = (3 - 2 + 1) * (2 - 1 + 1)
                    # 3x1 rectangles: 2 = (3 - 3 + 1) * (2 - 1 + 1)
                    # 1x2 rectangles: 4 = (3 - 1 + 1) * (2 - 2 + 1)
                    # 2x2 rectangles: 2 = (3 - 2 + 1) * (2 - 2 + 1)
                    # 3x2 rectangles: 1 = (3 - 3 + 1) * (2 - 2 + 1)
                    count += (length - inner_length + 1) * (width - inner_width + 1)
            
            if abs(2_000_000 - count) < abs(2_000_000 - result):
                result = count
                area = length * width
    
    return area

if __name__ == "__main__":
    print(counting_rectangles())
