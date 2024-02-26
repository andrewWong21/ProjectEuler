def coin_sums(coins, target) -> int:
    coins.sort()
    # dp[i] represents the number of ways to sum to i
    # using the given denominations in coins
    dp = [0] * (target + 1)
    dp[0] = 1
    for coin in coins:
        # only target values at least equal to the new coin value
        # will have their values in dp updated
        for i in range(coin, target + 1):
            dp[i] += dp[i - coin]
    
    return dp[target]

if __name__ == "__main__":
    print(coin_sums([1, 2, 5, 10, 20, 50, 100, 200], 200))