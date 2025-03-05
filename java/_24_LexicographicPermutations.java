import java.util.*;

public class _24_LexicographicPermutations{
    
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static String getNthPerm(String digits, int n){
        
        if (digits.length() == 1 || n == 0){
            return digits;
        }
        
        // For a given number of digits N, there are N! permutations,
        // with (N-1)! possible permutations for each starting digit.
        // By determining which group of (N-1)! permutations the desired
        // permutation belongs to, the initial digit can be determined.
        // This process is then repeated with the remaining N-1 digits
        // until all digits are used and the full permutation is found.
        
        int fact = factorial(digits.length() - 1);
        String remDigits = digits.substring(0, n / fact) + digits.substring(n / fact + 1);
        return digits.charAt(n / fact) + getNthPerm(remDigits, n % fact);
    }
    
    public static void main(String[] args){
        // n = 0 corresponds to the first lexicographic permutation.
        
        System.out.println("The millionth lexicographic permutation of the digits 0-9 is " + getNthPerm("0123456789", 999999)); // 2783915460
    }
}