def prime_power_triples(total: int) -> int:

    squares = set()
    cubes = set()
    fourths = set()
    sieved = [False for _ in range(total)]
    for i in range(2, total):
        if not sieved[i]:
            if i ** 2 < total:
                squares.add(i ** 2)
            if i ** 3 < total:
                cubes.add(i ** 3)
            if i ** 4 < total:
                fourths.add(i ** 4)
            for j in range(2*i, total, i):
                sieved[j] = True
            
    sums = set()
    for square in squares:
        for cube in cubes:
            for fourth in fourths:
                triple = square + cube + fourth
                if triple < total:
                    sums.add(triple)
    return len(sums)

if __name__ == "__main__":
    print(prime_power_triples(50_000_000))
