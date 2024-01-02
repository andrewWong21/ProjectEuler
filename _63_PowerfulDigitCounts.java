import java.util.*;
import java.math.BigInteger;

public class _63_PowerfulDigitCounts{
    
    public static void main(String[] args){
        
        // Find all integers p with n digits that are also nth powers.
        // Rewriting p as x^n, these integers must fulfill the following condition:
        // 10^(n-1) <= x^n < 10^n
        
        // Since 10^0 has 1 digit, 10^1 has 2 digits, 10^2 has 3 digits, ...,
        // fulfilling the condition x^n < 10^n requires x to be at most 9.
        // Only nth powers of x = 1, 2, 3, ..., 9 need to be checked.
        // The nth powers of x are then iterated until 10^(n-1) > x^n.
        
        int numPowers = 0;
        
        for (int x = 1; x < 10; x++){
            for (int n = 1; BigInteger.valueOf(10).pow(n-1).compareTo(BigInteger.valueOf(x).pow(n)) <= 0; n++){
                // System.out.println(String.format("%d^%d = %s", x, n, BigInteger.valueOf(x).pow(n)));
                numPowers++;
            }
        }
        
        System.out.println("n-digit powers that are also nth powers: " + numPowers); // 49
    }
}