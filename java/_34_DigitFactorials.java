import java.util.*;
import java.math.BigInteger;

public class _34_DigitFactorials{
    
    // 0! = 1, 1! = 1, 2! = 2, ..., 8! = 40320, 9! = 362880
    public static int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    public static int getDigitFactSum(int n){
        int factSum = 0;
        
        while (n > 0){
            factSum += factorials[n % 10];
            n /= 10;
        }
        return factSum;
    }
    
    public static void main(String[] args){
        
        // The maximum possible digit factorial sum for a number with d digits is d * 9!
        // The minimum value for a number with d digits is 10^(d - 1)
        
        // If 10^(d - 1) > d * 9!, the digit factorial sum for a number with at least d digits
        // can never be equal to the original number. The upper bound for numbers to check
        // against their digit factorial sum is then d * 9!, where d is the smallest integer
        // value that makes the inequality true. This occurs when d is at least 8.
        // Thus, it is sufficient to check all integers up to 8 * 9!.
        
        
        int sum = 0;
        
        // 1! = 1 and 2! = 2 are not counted.
        for (int num = 10; num < 8 * factorials[9]; num++){
            if (getDigitFactSum(num) == num){
                System.out.println(num);
                sum += num;
            }
        }
        
        System.out.println("Sum of all numbers equal to the factorials of their digits: " + sum); // 40730
        // 145 and 40585 are the only numbers equal to the factorials of their digits.
    }
}