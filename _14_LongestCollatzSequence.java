import java.util.*;
import java.math.BigInteger;

public class _14_LongestCollatzSequence{
    
    public static int[] chains = new int[1000000];
    
    // The number may exceed Integer.MAX_VALUE as the chain progresses,
    // so a BigInteger is necessary to handle these cases.
    public static int getCollatzLength(BigInteger bigInt){
        // System.out.println(bigInt.toString());
        
        // base case
        if (bigInt.equals(BigInteger.ONE)){
            return 1;
        }
        
        // fast lookup if current number already has a recorded chain length
        if ((bigInt.compareTo(BigInteger.valueOf(1000000)) < 0) && (chains[bigInt.intValue()] != 0)){
            return chains[bigInt.intValue()];
        }
        
        // n is odd -> 3*n + 1
        if (bigInt.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)){
            return getCollatzLength(bigInt.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE)) + 1;
        }
        
        // n is even -> 2*n
        return getCollatzLength(bigInt.divide(BigInteger.valueOf(2))) + 1;
    }
    
    public static void main(String[] args){
        // System.out.println(getCollatzLength(new BigInteger("13"))); // 10
        // System.out.println(getCollatzLength(new BigInteger("113383")));
        int longestChain = 0;
        int startNum = 0;
        for (int i = 1; i < 1000000; i++){
            int chain = getCollatzLength(new BigInteger(String.valueOf(i)));
            // System.out.println(i + " " + chain);
            
            // Save chain length to lookup array in case this number 
            // is reached again from a larger starting number.
            chains[i] = chain;
            
            if (chain > longestChain){
                startNum = i;
                longestChain = chain;
            }
        }
        
        System.out.printf("The starting number under 1 million that produces the longest Collatz chain is %d with a chain length of %d\n", startNum, longestChain); 
        // n = 837799, length = 525
    }
}