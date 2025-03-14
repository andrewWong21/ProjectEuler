import java.util.*;
import java.math.BigInteger;

public class _97_LargeNonMersennePrime{
    
    // private static long 
    
    public static void main(String[] args){
        // 28433 * (2 ^ 7830457) + 1
        BigInteger nmp = BigInteger.valueOf(2)
            .pow(7830457)
            .multiply(BigInteger.valueOf(28433))
            .mod(BigInteger.valueOf(10_000_000_000L))
            .add(BigInteger.ONE);
        
        System.out.println("Last 10 digits of given non-Mersenne prime: " + nmp); // 
    }
}
