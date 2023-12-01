import java.util.*;

public class _31_CoinSums{
    
    public static void main(String[] args){
        // 0p can be made 1 way
        // 1p can be made 1 way : 1p
        // 2p can be made 2 ways: 2p, 1p+1p
        // 3p can be made 2 ways: 2p+1p, 1p+1p+1p
        // 4p can be made 3 ways: 2p+2p, 2p+1p+1p, 1p+1p+1p+1p
        // 5p can be made 4 ways: 5p, 2p+2p+1p, 2p+1p+1p+1p, 1p+1p+1p+1p+1p
        // 6p can be made 5 ways: 5p+1p, 2p+2p+2p, 2p+2p+1p+1p, 2p+1p+1p+1p+1p, 1p+1p+1p+1p+1p+1p
        // ...
        
        int[] sums = new int[201];
        sums[0] = 1;
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        
        // Examine each coin value and compare them to all coin totals up to the desired total.
        // If the coin value is at most equal to the given total, it can be used in a coin sum. 
        // Retrieve the number of currently known possible sums for the difference of the given total
        // and the current coin value and add it to the currently known sums for the given total.
        
        // Consider the process of counting possible sums for 5p using only 1p and 2p coins.
        // At this point, we know that there is only one possible sum for 5p using only 1p coins.
        // To find the number of coin sums for 5p that use coins with values of at most 2p,
        // we take the number of currently known coin sums of (5p - 2p) = 3p, which is 2,
        // and add it to our value for currently known coins sums of 5p.    1 + 2 = 3
        
        // In equation form:
        // 5p = 2p+(3p) and we know 5p = 1p+1p+1p+1p+1p
        // We also know at this point that 3p = 2p+1p, 1p+1p+1p
        // Our known sums for 5p are now 2p+(2p+1p), 2p+(1p+1p+1p), 1p+1p+1p+1p+1p (3 sums)
        
        // Later, when examining sums using 5p coins:
        // 5p = 5p+(0p) and we know 5p = 2p+2p+1p, 2p+1p+1p+1p, 1p+1p+1p+1p+1p
        // 0p has only one possible combination of coins
        // Our known sums for 5p are now 5p, 2p+2p+1p, 2p+1p+1p+1p, 1p+1p+1p+1p+1p (4 sums)
        
        for (int coin : coins){
            for (int n = 1; n < sums.length; n++){
                if (coin <= n){
                    sums[n] += sums[n - coin];
                }
                // System.out.println(coin + " " + n + " " + sums[n]);
            }
        }
        System.out.println("Number of ways to make £2 using any number of coins: " + sums[sums.length - 1]); // 73682
    }
}