from math import sqrt

def cyclical_figurate_numbers() -> int:
    
    triangles = set()
    squares   = set()
    pentagons = set()
    hexagons  = set()
    heptagons = set()
    octagons  = set()
    
    for i in range(1000, 10_000):
        if (is_triangle(i)):
            triangles.add(i)
        if (is_square(i)):
            squares.add(i)
        if (is_pentagon(i)):
            pentagons.add(i)
        if (is_hexagon(i)):
            hexagons.add(i)
        if (is_heptagon(i)):
            heptagons.add(i)
        if (is_octagon(i)):
            octagons.add(i)
    
    for octagon in octagons:
        cyclic = search(octagon, [heptagons, hexagons, pentagons, squares, triangles])
        if len(cyclic) != 0:
            return sum(cyclic)
    
    return 0
    
def search(p1: int, polygons: list) -> tuple:
    for set2 in polygons:
        for p2 in set2:
            if p2 == p1:
                continue
            if p1 % 100 == p2 // 100:
                for set3 in polygons:
                    if set3 == set2:
                        continue
                    for p3 in set3:
                        if p3 == p1 or p3 == p2:
                            continue
                        if p2 % 100 == p3 // 100:
                            for set4 in polygons:
                                if set4 == set2 or set4 == set3:
                                    continue
                                for p4 in set4:
                                    if p4 == p1 or p4 == p2 or p4 == p3:
                                        continue
                                    if p3 % 100 == p4 // 100:
                                        for set5 in polygons:
                                            if set5 == set2 or set5 == set3 or set5 == set4:
                                                continue
                                            for p5 in set5:
                                                if p5 == p1 or p5 == p2 or p5 == p3 or p5 == p4:
                                                    continue
                                                if p4 % 100 == p5 // 100:
                                                    for set6 in polygons:
                                                        if set6 == set2 or set6 == set3 or set6 == set4 or set6 == set5:
                                                            continue
                                                        for p6 in set6:
                                                            if p6 == p1 or p6 == p2 or p6 == p3 or p6 == p4 or p6 == p5:
                                                                continue
                                                            if p5 % 100 == p6 // 100 and p6 % 100 == p1 // 100:
                                                                return (p1, p2, p3, p4, p5, p6)
    return ()
    
def is_triangle(p: int) -> bool:
    # p = n * (n + 1) / 2
    # 2p = n^2 + n, n^2 + n - 2p = 0
    n = (sqrt(8*p + 1) - 1) / 2
    return int(n) == n

def is_square(p: int) -> bool:
    return int(sqrt(p)) == sqrt(p)

def is_pentagon(p: int) -> bool:
    # n * (3n - 1) / 2
    # 2p = 3n^2 - n, 3n^2 - n - 2p = 0
    n = (sqrt(24*p + 1) + 1) / 6
    return int(n) == n

def is_hexagon(p: int) -> bool:
    # n * (2n - 1)
    # p = 2n^2 - n, 2n^2 - n - p = 0
    n = (sqrt(8*p + 1) + 1) / 4
    return int(n) == n
    
def is_heptagon(p: int) -> bool:
    # n * (5n - 3) / 2
    # 2p = 5n^2 - 3n, 5n^2 - 3n - 2p = 0
    n = (sqrt(40*p + 9) + 3) / 10
    return int(n) == n

def is_octagon(p: int) -> bool:
    # n * (3n - 2)
    # p = 3n^2 - 2n, 3n^2 - 2n - p = 0
    # (sqrt(12*p + 4) + 2) / 6
    # (sqrt(4)*sqrt(3*p + 1) + 2) / 6
    # (sqrt(3*p + 1) * 2 + 2) / 6
    # (sqrt(3*p + 1) + 1) / 3
    n = (sqrt(3*p + 1) + 1) / 3
    return int(n) == n


if __name__ == "__main__":
    print(cyclical_figurate_numbers())