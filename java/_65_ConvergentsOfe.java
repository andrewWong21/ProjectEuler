import java.util.*;
import java.math.BigInteger;

public class _65_ConvergentsOfe{
    
    public static int getDigitSum(BigInteger n){
        int sum = 0;
        char[] chars = n.toString().toCharArray();
        for (char c : chars){
            sum += c - '0';
        }
        return sum;
    }
    
    public static void main(String[] args){
        
        // e = 2 + e - 2
        // e = 2 + 1/(1/(e-2))
        // e = 2 + 1/(1 + 1/(1/e - 2))
        
        // [2; 1, 2, 1, 1, 4, 1, 1, 6, 1, ..., 1, 2k, 1, ...]
        
        // 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465
        // 2 = 2
        // 2 + 1/(1) = 3
        // 2 + 1/(2 + 1/(2)) = 2 + 1/(3/2) = 2 + 2/3 = 8/3
        // 2 + 1/(1 + 1/(2 + 1/(1))) = 2 + 1/(1+1/3) = 2 + 1/(4/3) = 2 + 3/4 = 11/4
        // 2 + 1/(1 + 1/(2 + 1/(1 + 1/(1)))) = 2 + 5/7 = 19/7
        // 2 + 1/(1 + 1/(2 + 1/(1 + 1/(1 + 1/(4))))) = 2 + 25/32 = 87/32
        
        //    3 = 2(1) + 1
        //    8 = 3(2) + 2
        //   11 = 8(1) + 3
        //   19 = 11(1) + 8
        //   87 = 19(4) + 11
        //  106 = 87(1) + 19
        //  193 = 106(1) + 87
        // 1264 = 193(6) + 106
        
        BigInteger prevNum = BigInteger.ONE; 
        BigInteger num = BigInteger.valueOf(2);
        
        int k = 1;
        for (int i = 1; i < 100; i++){
            
            int r = 1;
            if (i % 3 == 2){
                r = 2*k++;
            }
            BigInteger newNum = num.multiply(BigInteger.valueOf(r)).add(prevNum);
            prevNum = num;
            num = newNum;
            System.out.println(newNum);
            
        }
        
        System.out.println("Sum of digits in the numerator of the 100th convergent of the continued fraction for e: " + getDigitSum(num)); // 1322
    }
}