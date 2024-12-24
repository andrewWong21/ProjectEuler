using System;

public class _31_CoinSums{
	public static int Euler31(){
		int amount = 200;
		int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		foreach (int coin in coins){
			for (int i = coin; i <= amount; i++){
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
	
	public static void Main(){
		Console.WriteLine(Euler31());
	}
}
