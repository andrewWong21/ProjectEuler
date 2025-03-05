import java.util.*;

public class _51_PrimeDigitReplacements{
    public static HashSet<Integer> masks = new HashSet<>();
    
    public static ArrayList<Integer> sieve(int n){
        
        boolean[] sieved = new boolean[n];
        sieved[0] = sieved[1] = true;
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = 2*i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static int replace(String str, String mask, int digit){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < mask.length(); i++){
            if (mask.charAt(i) == '*'){
                sb.append(digit);
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        
        return Integer.valueOf(sb.toString());
    }
    
    public static void main(String[] args){
        // In order for the prime family to have at least 8 members,
        // The number of digits to be replaced must be a multiple of 3.
        
        // When the number of digits replaced is not a multiple of 3,
        // taking modulo 3 of the digits results in a cyclic result of 0, 1, 2, 0, 1, 2, ...
        // so that regardless of the sum of the non-replaced digits, 
        // at least three of the ten possible numbers after replacement
        // will be divisible by 3 due to the digit sum divisibility rule for 3.
        
        
        // * represents a digit to be replaced
        
        // 4 possible masks for 4-digit numbers (4C3)
        String[] masks4 = new String[]{"***.", "**.*", "*.**", ".***"};
        
        // 10 possible masks for 5-digit numbers (5C3)
        String[] masks5 = new String[]{
            "***..", "**.*.", "**..*", "*.**.", "*.*.*",
            "*..**", ".***.", ".**.*", ".*.**", "..***"
        };
        // 20 possible masks for 6-digit numbers (6C3)
        String[] masks6 = new String[]{
            "***...", "**.*..", "**..*.", "**...*", "*.**..",
            "*.*.*.", "*.*..*", "*..**.", "*..*.*", "*...**",
            ".***..", ".**.*.", ".**..*", ".*.**.", ".*.*.*",
            ".*..**", "..***.", "..**.*", "..*.**", "...***"
        };
        
        
        ArrayList<Integer> primes = sieve(1000000);
        HashSet<Integer> primesSet = new HashSet<>(primes);
        
        int result = 0;
        for (int i = 0; i < primes.size() && result == 0; i++){
            String str = String.valueOf(primes.get(i));
            String[] masks = new String[0];
            if (str.length() == 4){
                masks = masks4;
            }
            else if (str.length() == 5){
                masks = masks5;
            }
            else if (str.length() == 6){
                masks = masks6;
            }
            
            for (int j = 0; j < masks.length && result == 0; j++){
                String mask = masks[j];
                ArrayList<Integer> primeFamily = new ArrayList<>();
                
                // Replace the digits specified by the mask
                // and check if the result is prime.
                for (int digit = 0; digit <= 9; digit++){
                    
                    int newNum = replace(str, mask, digit);
                    
                    if (newNum > primes.get(i) && primesSet.contains(newNum)){
                        primeFamily.add(newNum);
                    }
                }
                if (primeFamily.size() == 8){
                    // System.out.println(mask);
                    Collections.sort(primeFamily);
                    result = primeFamily.get(0);
                    
                }
            }
        }
        
        System.out.println("Smallest prime part of an eight prime family with digit replacements: " + result); // 121313, mask *.*.*.
    }
}