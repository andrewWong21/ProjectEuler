import java.util.*;
import java.math.BigInteger;

public class _10_SummationOfPrimes{
    
    // Using the Sieve of Eratosthenes to
    // generate a list of prime integers.
    public static boolean[] sieve(int num){
        
        // Initialize an array of booleans
        // that correspond to the primality
        // of their zero-based index.
        // A value of true indicates that
        // the 0-based index is not prime.
        boolean[] sieved = new boolean[num];
        
        // Remove 0 and 1 from primality consideration.
        sieved[0] = true;
        sieved[1] = true;
        
        for (int i = 2; i < sieved.length; i++){
            // Skip over all non-prime integers.
            if (!sieved[i]){
                // Sieve out all multiples of the current prime,
                // marking greater multiples as composite.
                for (int mult = 2*i; mult < num; mult += i){
                    sieved[mult] = true;
                }
            }
        }
        return sieved;
    }
    
    public static void main(String[] args){
        
        BigInteger sum = BigInteger.ZERO;
        
        int maxNum = 2000000;
        boolean[] integers = sieve(maxNum);
        for (int i = 2; i < integers.length; i++){
            if (!integers[i]){
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        
        System.out.println("The sum of all prime numbers less than " + maxNum + " is " + sum.toString()); // 142913828922
        //System.out.println((sum.compareTo(new BigInteger("142913828922"))) == 0); // true
    }
}