import java.util.*;
import java.math.BigInteger;

public class _30_DigitFifthPowers{
    
    public static int digitFifthPowerSum(int n){
        int sum = 0;
        while (n > 0){
            sum += (int) Math.pow(n % 10, 5);
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args){
        
        // As n increases, at some point it will become large enough that
        // its digit fifth power sum (DFPS) will always be less than n.
        
        // The minimum value for a d-digit number is 10^(d - 1).
        // The maximum DFPS of a d-digit number is d * 9^5.
        
        // If the DFPS for the maximum value for a d-digit number
        // is less than the minimum value for a d-digit number,
        // it is not possible to write any number with d digits
        // as the sum of the fifth powers of its digits.
        
        // Using 9^5 = 59049:
        // DFPS(99999)   = 5 * 9^5 = 295245 > 10000
        // DFPS(999999)  = 6 * 9^5 = 354294 > 100000
        // DFPS(9999999) = 7 * 9^5 = 413343 < 1000000
        
        // The maximum DFPS of a 7-digit number is 413343, which is only 6 digits.
        // There are no 7-digit numbers that can be written as the sum of the 
        // fifth powers of their digits, so we can stop checking equality when n = 10^7.
        
        int sum = 0;
        for (int n = 2; n <= 999999; n++){
            if (n == digitFifthPowerSum(n)){
                // System.out.println(n);
                sum += n;
            }
        }
        System.out.println("The sum of all numbers that can be written as the sum of the fifth powers of their digits is " + sum); // 443839
    }
}