import java.util.*;
import java.math.BigInteger;

public class _16_PowerDigitSum{
    
    public static void main(String[] args){
        BigInteger bigInt = BigInteger.valueOf(2).pow(1000); // resulting number has 302 decimal digits
        
        int digitSum = 0;
        for (char c : bigInt.toString().toCharArray()){
            digitSum += Character.getNumericValue(c);
        }
        
        System.out.println("The sum of the digits of 2^1000 is " + digitSum); // 1366
        
    }
}