import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class _80_SquareRootDigitalExpansion{
    
    public static int getDigitalSum(int n){
        
        BigDecimal root = BigDecimal.valueOf(n);
        root = root.sqrt(new MathContext(102));
        char[] digits = root.toString().toCharArray();
        
        int digitSum = 0;
        int count = 0;
        for (int i = 0; count < 100; i++){
            if (digits[i] != '.'){
                digitSum += digits[i] - '0';
                count++;
            }
        }
        return digitSum;
    }
    
    public static void main(String[] args){
        
        // Digital sum for the first 100 decimal digits of sqrt(2): 475
        // This counts 1 + 4 + 1 + 4 + 2 + ... + 4 + 1 + 5 + 7 + 2
        int sum = 0;
        
        for (int n = 1; n <= 100; n++){
            if (Math.floor(Math.sqrt(n)) != Math.sqrt(n)){
                sum += getDigitalSum(n);
            }
        }

        System.out.println("Total of digital sums for first 100 decimal digits of all irrational square roots of n from 1 to 100: " + sum); // 
    }
}