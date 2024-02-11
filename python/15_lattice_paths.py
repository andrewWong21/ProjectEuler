from math import factorial

def lattice_paths(n: int) -> int:
    # given an nxn grid, it takes 2n movements to reach the opposite corner
    # each route is composed of n movements right and n movements down,
    # so there are 2n choose n possible routes, or (2n)! / (n! * n!)
    return factorial(2 * n) // factorial(n) ** 2

if __name__ == "__main__":
    print(lattice_paths(20))