import java.util.*;
import java.math.BigInteger;

public class _20_FactorialDigitSum{
    
    public static void main(String[] args){
        BigInteger fact = BigInteger.valueOf(100);
        for (int i = 99; i > 0; i--){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        
        // System.out.println(fact);
        
        int digitSum = 0;
        for (char c : fact.toString().toCharArray()){
            digitSum += Character.getNumericValue(c);
        }
        
        System.out.println("The sum of the digits in 100! is " + digitSum); // 648
    }
}