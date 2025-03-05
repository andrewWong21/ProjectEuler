import java.util.*;

public class _38_PandigitalMultiples{
    
    public static boolean isPandigital(String str){
        
        HashSet<Character> digits = new HashSet<>();
        
        for (char c : str.toCharArray()){
            digits.add(c);
        }
        
        return digits.size() == 9 && !digits.contains('0');
    }
    
    public static void main(String[] args){
        
        String result = "";
        
        // If n is a 5-digit number, then all of its multiples will also have
        // at least 5 digits, so the product cannot be 1-9 pandigital.
        // Therefore, n can be at most 4 digits if a 1-9 pandigital number is
        // created from concatenating at least two multiples of n.
        for (int num = 9876; num > 0; num--){
            
            String str = String.valueOf(num);
            
            // Concatenate multiples of the integer until the product is at least 9 digits.
            for (int i = 2; str.length() < 9; i++){
                str += num * i;
            }
            
            if (str.length() == 9 && isPandigital(str)){
                result = str;
                break;
            }
        }
        
        System.out.println("The largest 1-9 pandigital 9-digit number that can be represented as");
        System.out.println("the concatenated product of an integer and (1, 2, ..., n) where n > 1 is " + result);
        // 9327 * 2 = 18654, and 932718654 is 1-9 pandigital
        
    }
}