import java.util.*;
import java.math.BigInteger;

public class _56_PowerfulDigitSum{
    
    public static int getDigitSum(BigInteger bigInt){
        int sum = 0;
        String s = bigInt.toString();
        
        for (int i = 0; i < s.length(); i++){
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
    
    public static void main(String[] args){
        
        int maxSum = 0;
        
        for (int a = 1; a < 100; a++){
            BigInteger bigInt = BigInteger.ONE;
            
            for (int b = 1; b < 100; b++){
                bigInt = bigInt.multiply(BigInteger.valueOf(a));
                int sum = getDigitSum(bigInt);
                // System.out.println(String.format("%d^%d = %s: %d", a, b, bigInt, sum));
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }
        
        System.out.println("Maximum digital sum of a^b where a,b are natural numbers < 100: " + maxSum); // 972
    }
}