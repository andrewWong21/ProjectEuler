import java.util.*;

public class _52_PermutedMultiples{
    
    public static int[] checkDigits(int n){
        String str = String.valueOf(n);
        int[] digits = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++){
            digits[i] = str.charAt(i) - '0';
        }
        Arrays.sort(digits);
        return digits;
    }
    
    public static void main(String[] args){
        
        // Since the number to be found has the same digits as its multiples,
        // each of these numbers must be congruent to each other modulo 3.
        // By the same token, they are also congruent to each other modulo 9.
        // This can be derived from their digit sum divisibility rules.
        
        // Let the first number be n, then n must be congruent to some number m (mod 9).
        // The next multiple, 2n, having the same digits as n, must also be congruent to m (mod 9).
        // By the modular property of subtraction, 2n - n is congruent to m - m (mod 9).
        // Thus, n is congruent to 0 (mod 9) and 2n is also congruent to 0 (mod 9).
        // Therefore, n and 2n (and by extension 3n, 4n, 5n, 6n) are multiples of 9.
        
        int result = 0;
        int n = 9;
        
        while (result == 0){
            // String output = n + " " + Arrays.toString(checkDigits(n)) + " ";
            int[] digitsArr = checkDigits(n);
            boolean sameDigits = true;
            for (int j = n+n; j <= 6*n; j += n){
                // output += Arrays.toString(checkDigits(j)) + " ";
                if (!Arrays.equals(digitsArr, checkDigits(j))){
                    sameDigits = false;
                    break;
                }
            }
            // System.out.println(output);
            if (sameDigits){
                result = n;
            }
            n++;
        }
        
        System.out.println("Smallest positive integer that contains the same digits as its next 5 multiples: " + result); // 142857
        // 142857, 285714, 428571, 571428, 714285, 857142
    }
}