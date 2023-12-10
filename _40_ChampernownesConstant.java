import java.util.*;

public class _40_ChampernownesConstant{
    
    public static void main(String[] args){
        // d_1 * d_10 * d_100 * d_1000 * d_10000 * d_100000 * d_1000000
        
        // 0.123456789101112131415...
        
        // d_1 = 1, d_10 = 1
        int result = 1;
        
        // 9 one-digit integers      (1-9),           string length       9
        // 90 two-digit integers     (10-99),         string length     180       (begins at digit 10)
        // 900 three-digit integers  (100-999),       string length    2700     (begins at digit 2890)
        // 9000 four-digit integers  (1000-9999),     string length   36000    (begins at digit 38890)
        // 90000 five-digit integers (10000-99999),   string length  450000   (begins at digit 488890)
        // 900000 six-digit integers (100000-999999), string length 5400000  (begins at digit 5888890)
        int[] digitStarts = new int[]{1, 10, 190, 2890, 38890, 488890, 5888890};
        
        for (int pos = 1; pos <= 1000000; pos *= 10){
            
            // Determine which group of integers the given position is in.
            
            int numDigits = 0;
            for (int j = 0; digitStarts[j] <= pos; j++){
                numDigits = j + 1;
            }
            // e.g. for position 100, 10 < 100 < 2890,
            // and position 10 is where the 2-digit integers start,
            // so position 100 is in the group of 2-digit integers.
            
            
            // Determine which integer the given position is a digit of.
            // Find the number of digits between the starting position
            // and the given position, and divide by numDigits to get k,
            // where k = 0, 1, 2, 3, ...
            // The given position will be one of the digits of the integer
            // that is k numbers after the starting integer in this group.
            
            int startPos = digitStarts[numDigits - 1];
            int k = (pos - startPos) / numDigits;
            int n = (int) Math.pow(10, numDigits - 1) + k;
            // k = (100 - 10) / 2 = 90 / 2 = 45
            // Position 100 is in the number 
            // n = 10 + 45 = 55
            
            // Get the corresponding digit of the number.
            int digitPos = pos - (startPos + numDigits * k);
            int digit = String.valueOf(n).charAt(digitPos) - '0';
            
            result *= digit;
            
            System.out.printf("digit %d of %d: %d\n", digitPos, n, digit);
        }
        
        System.out.println("The product of the specified digits is " + result);
    }
}