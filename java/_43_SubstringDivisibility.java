import java.util.*;
import java.io.File;

public class _43_SubstringDivisibility{
    
    public static boolean isPandigital(long n){
        String str = String.valueOf(n);
        
        HashSet<Character> digitSet = new HashSet<>();
        
        for (Character chr : str.toCharArray()){
            digitSet.add(chr);
        }
        
        return digitSet.size() == 10;
    }
    
    public static boolean meetsDivisibilityRules(long n){
        String str = String.valueOf(n);
        
        int[] divisors = new int[]{2, 3, 5, 7, 11, 13, 17};
        
        for (int pos = 1; pos < 8; pos++){
            if (Integer.valueOf(str.substring(pos, pos + 3)) % divisors[pos - 1] != 0){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        
        // The divisibility rules restrict certain digits of the overall number.
        // Consider a 0-9 pandigital number abcdefghij that fulfills the following rules:
        // bcd % 2 = 0, cde % 3 = 0, def % 5 = 0, efg % 7 = 0, fgh % 11 = 0, ghi % 13 = 0, hij % 17 = 0
        
        // The digit f is either 0 or 5 due to the divisibility rule def % 5 = 0.
        // If f = 0, the number fgh is then 0gh, or some number less than 100 that is also divisible by 11.
        // All multiples of 11 under 100 have repeated digits, which would make the number not pandigital.
        // Knowing that f = 5, we can further narrow down fgh to be a multiple of 11 over 500.
        
        // The multiples with non-repeated digits are 506, 517, 528, 539, 561, 572, 583, 594.
        // If fgh = 506, the rule 06i % 13 = 0 forces i to be 5, which results in a repeated digit.
        // fgh cannot be 517 because there is no multiple of 13 between 170 and 180. (13*13=169, 13*14=182)
        // If fgh = 561, the rule 61i % 13 = 0 forces i to be 6, which results in a repeated digit.
        // If fgh = 594, the rule 94i % 13 = 0 forces i to be 9, which results in a repeated digit.
        
        // With fghi restricted to 5286, 5390, 5728, or 5832, we examine the divisibility rule hij % 17 = 0.
        // If fghi = 5832, the rule forces j to be 3, which results in a repeated digit.
        
        // With fghij restricted to 52867, 53901, or 57289, we examine the divisibility rule efg % 7 = 0.
        // If fg = 52, e must be 9, as using 2 results in a repeated digit.
        // If fg = 53, the rule forces e to be 5, which results in a repeated digit.
        
        // With efghij restricted to 952867 or 357289, we examine the divisibility rule bcd % 2 = 0.
        // If efghij = 952867, d may be either 0 or 4.
        // If efghij = 357289, d may be either 0, 4, or 6.
        
        // With defghij restricted to 0952867, 4952867, 0357289, 4357289, or 6357289, we examine the rule cde % 3 = 0.
        // If de = 49 or 43, c must be 2, 5, or 8, but those all result in repeated digits.
        // If de = 09, c must be 3, as using 6 results in a repeated digit.
        // If de = 03, c must be 6, as using 9 results in a repeated digit.
        // If de = 63, c must be 0, as using 9 results in a repeated digit.
        
        // Finally, cdefghij is restricted to being 30952867, 60357289, or 06357289.
        // To ensure that the full number is pandigital, a and b must be assigned the remaining digits 1 and 4 in either order.
        // The resulting six 10-digit numbers are guaranteed, by construction, to fulfill both the pandigital and divisibility properties.
        
        long sum = 0;
        
        String[] suffixes = new String[]{"30952867", "60357289", "06357289"};
        
        ArrayList<String> candidates = new ArrayList<String>();
        
        for (String suffix : suffixes){
            candidates.add("14" + suffix);
            candidates.add("41" + suffix);
        }
        
        for (String str : candidates){
            long n = Long.valueOf(str);
            // System.out.println(isPandigital(n) && meetsDivisibilityRules(n));
            // System.out.println(n);
            sum += n;
        }
        
        System.out.println("Sum of all 0-9 pandigital integers with specified divisibility rules: " + sum); // 16695334890
    }
}