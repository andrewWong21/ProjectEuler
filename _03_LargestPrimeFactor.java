import java.util.*;
import java.math.BigInteger;

public class _03_LargestPrimeFactor{
    public static boolean isPrime(BigInteger num){
        // Base case prime checking
        if (num.equals(BigInteger.valueOf(2)) || num.equals(BigInteger.valueOf(3))){
            return true;
        }
        // Every prime greater than 3 can be 
        // expressed as 6k + 1 or 6k - 1,
        // where k is a natural number.
        
        // This reduces the number of potential candidates 
        // for checking divisors of a given integer N, as
        // all integers greater than 1 are either prime or
        // factorable into a product of primes.
        
        // Checking all integers of the form 6k-1 or 6k+1
        // up to sqrt(N) guarantees that all possible primes
        // will be checked, however it will also catch some
        // composite numbers (e.g. 25, 49, 91).
        
        // Only integers up to sqrt(N) need to be checked, as
        // N being composite suggests the factorization form
        // N = a * b. If one of the integers a,b is greater
        // than sqrt(N), the other integer must therefore be
        // less than sqrt(N).
        
        for (int k = 1; (BigInteger.valueOf(6*k-1)).compareTo(num.sqrt()) < 1; k++){
            // Check if there is a (most likely) prime integer
            // that evenly divides the integer N.
            if (num.mod(BigInteger.valueOf(6*k-1)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(6*k+1)).equals(BigInteger.ZERO)){
                return false;
            }
        }
        return true;
    }
    
    public static List<BigInteger> getPrimes(BigInteger n){
        // Return a list of all primes less than or equal to n.
        List<BigInteger> primes = new ArrayList<BigInteger>();
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) < 1; i = i.add(BigInteger.ONE)){
            if (isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }
    
    public static BigInteger getMaxPrimeFactor(BigInteger n){
        BigInteger maxPrimeFactor = BigInteger.ZERO;
        
        // Generate a list of primes to test divisibility.
        List<BigInteger> primes = getPrimes(n.sqrt());
        for (BigInteger p : primes){
            if (n.mod(p).equals(BigInteger.ZERO)){
                maxPrimeFactor = p;
            }
        }
        return maxPrimeFactor;
    }
    
    public static void main(String[] args){
        System.out.print("Largest prime factor of 13195: ");
        System.out.println(getMaxPrimeFactor(new BigInteger("13195"))); // 29
        System.out.print("Largest prime factor of 600851475143: ");
        System.out.println(getMaxPrimeFactor(new BigInteger("600851475143"))); // 6857
    }
}