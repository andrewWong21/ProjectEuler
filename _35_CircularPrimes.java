import java.util.*;

public class _35_CircularPrimes{
    
    public static ArrayList<Integer> primesList;
    
    // Sieve out primes from 2 to 1 million.
    public static ArrayList<Integer> sievePrimes(int n){
        boolean[] sieved = new boolean[n];
        sieved[0] = sieved[1] = true;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        // Sieve out multiples of found primes.
        for (int i = 2; i < n; i++){
            if (!sieved[i]){
                for (int mult = 2*i; mult < n; mult += i){
                    sieved[mult] = true;
                }
            }
        }
    
        // Collect found primes into a list.
        int i = 0;
        for (boolean composite : sieved){
            // Additional check to further reduce candidates for circular primes.
            // Primes containing the digits 0, 2, 4, 5, 6, or 8 are not considered.
            // 2 and 5 are circular primes themselves, so this check is not performed
            // if the prime being considered has only one digit.
            if (!composite && (i < 10 || !hasCompositeRotation(i))){
                primes.add(i);
            }
            i++;
        }
        return primes;
    }
    
    public static boolean hasCompositeRotation(int p){
        // precondition: p is prime and at least 10
        
        // If a number has at least two digits and contains the digits 
        // 0, 2, 4, 5, 6, or 8, then it will have a rotation that is composite.
        
        char[] digits = new char[]{'0', '2', '4', '5', '6', '8'};
        for (char digit : digits){
            if (String.valueOf(p).indexOf(digit) != -1){
                return true;
            }
        }
        return false;
    }
    
    public static int[] getRotations(int p){
        // A number with d digits will have d rotations.
        
        int[] rotations = new int[String.valueOf(p).length()];
        
        String str = String.valueOf(p);
        for (int i = 0; i < rotations.length; i++){
            rotations[i] = Integer.parseInt(str);
            str = str.substring(1) + str.charAt(0);
        }
        
        return rotations;
    }
    
    public static void main(String[] args){
        
        primesList = sievePrimes(1000000);
        
        int circularPrimes = 0;
        
        for (int prime : primesList){
            boolean isCircularPrime = true;
            
            for (int rotation : getRotations(prime)){
                if (!primesList.contains(rotation)){
                    isCircularPrime = false;
                }
                
            }
            
            if (isCircularPrime){
                circularPrimes++;
            }
        }
        
        System.out.println("# of circular primes under 1 million: " + circularPrimes); // 55
    }
}