import java.util.*;

public class _32_PandigitalSums{
    
    public static boolean isPandigital(int a, int b){
        String str = "" + a + b + (a*b);
        if (str.length() != 9){
            return false;
        }
        
        HashSet<Character> digits = new HashSet<>();
        for (char c : str.toCharArray()){
            digits.add(c);
        }
        
        // The identities to be considered must be 1-9 pandigital, 
        // so none of the numbers involved may have a 0 as any of their digits.
        return digits.size() == 9 && !digits.contains('0');
    }
    
    public static void main(String[] args){
        
        HashSet<Integer> products = new HashSet<>();
        int sum = 0;
        
        // In order for the number of digits in the identity to equal 9,
        // either a 1-digit number is multiplied by a 4-digit number to get a 4-digit number
        for (int a = 1; a <= 9; a++){
            for (int b = 1000; b <= 9999; b++){
                if (isPandigital(a, b) && !products.contains(a*b)){
                    products.add(a*b);
                }
            }
        }
        // or a 2-digit number is multiplied by a 3-digit number to get a 4-digit number
        for (int a = 10; a <= 99; a++){
            for (int b = 100; b <= 999; b++){
                if (isPandigital(a, b) && !products.contains(a*b)){
                    products.add(a*b);
                }
            }
        }
        for (int product : products){
            sum += product;
        }
        System.out.println("Sum of all numbers that can be written as a 1-9 pandigital product identity: " + sum); // 45228
    }
}