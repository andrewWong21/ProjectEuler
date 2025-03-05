import java.util.*;

public class _27_QuadraticPrimes{
    
    static ArrayList<Integer> primes = new ArrayList<>();
    
    public static ArrayList<Integer> sieve(int num){
        boolean[] sieved = new boolean[num];
        sieved[0] = sieved[1] = true;
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int mult = 2*i; mult < num; mult += i){
                    sieved[mult] = true;
                }
            }
        }
        
        int i = 0;
        for (boolean composite : sieved){
            if (!composite){
                primes.add(i);
            }
            i++;
        }
        
        return primes;
    }
    
    public static boolean isPrime(int num){
        if (num == 2 || num == 3){
            return true;
        }
        for (int i = 2; i*i <= num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int consecutivePrimes(int a, int b){
        int n = 0;
        int num = n * n + a * n + b;
        int maxSieve = primes.get(primes.size() - 1);
        
        // A large enough value for n may produce a prime that is 
        // greater than b and lies outside of the initial sieve,
        // so isPrime is used as a fallback verification.
        
        // The largest prime generated after iterating through all
        // combinations of a, b, and n is 12073.
        
        while(primes.contains(num) || (num > maxSieve && isPrime(num))){
            num = n*n + a*n + b;
            n++;
        }
        return n - 1;
    }
    
    public static void main(String[] args){
        // The quadratic formula n^2 + a*n + b should return primes
        // for consecutive values of n starting from 0.
        
        // If n = 0, the formula reduces to b, which must therefore be prime itself.
        
        // If n = b, the result is b*b + a*b + b = b(a + b + 1) which is composite.
        // Therefore, a given value pair (a, b) can generate at most b primes. (n=0 to n=b-1)
        
        // Generating a list of primes has two uses:
        // Faster (although not exhaustive) checking of the formula's result for given values of a, b, and n.
        // An iterable list for values of b that are guaranteed to yield primes for n=0.
        primes = sieve(1000);
        
        int maxFound = 0;
        int product = 0;
        
        for (int b : primes){
            for (int a = -999; a < 1000; a ++){
                int streak = consecutivePrimes(a, b);
                if (streak > maxFound){
                    maxFound = streak;
                    product = a * b;
                    // System.out.println(a + " " + b + " " + maxFound + " " + product);
                }
            }
        }
        System.out.println("Given the quadratic expression n^2 + an + b, |a| < 1000, |b| <= 1000,");
        System.out.println("the product of the values of a and b which generate the maximum number of primes is " + product); // -59231 = -61 * 971
    }
}