def large_non_mersenne_prime() -> int:

    return (28433 * 2 ** 7830457 + 1) % 10_000_000_000


if __name__ == "__main__":
    print(large_non_mersenne_prime())
