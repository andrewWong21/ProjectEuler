import java.util.*;

public class _36_DoubleBasePalindromes{
    
    public static boolean isPalindrome(String str){
        // Check if the original string is equal to the reverse of itself.
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    
    public static void main(String[] args){
        
        int sum = 0;
        
        for (int n = 1; n < 1000000; n++){
            if (isPalindrome(String.valueOf(n)) && isPalindrome(Integer.toBinaryString(n))){
                // System.out.print(n);
                sum += n;
            }
        }
        
        System.out.println("Sum of all numbers under 1 million palindromic in both binary and decimal: " + sum); // 872187
        // Numbers under 1 million palindromic in base 2 and base 10:
        // 1, 3, 5, 7, 9, 33, 99, 313, 585, 717, 7447, 9009, 15351, 32223, 39993, 53235, 53835, 73737, 585585
    }
}