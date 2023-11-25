import java.util.*;
import java.math.BigInteger;

public class _25_1000DigitFibonacciNumber{
    
    public static void main(String[] args){
        int index = 2; // F_1 = 1, F_2 = 1, F_3 = 2, ...
        BigInteger prevFib = BigInteger.ONE;
        BigInteger currFib = BigInteger.ONE;
        while (currFib.toString().length() < 1000){
            BigInteger temp = currFib;
            currFib = currFib.add(prevFib);
            prevFib = temp;
            index++;
        }
        System.out.println("The index of the first Fibonacci term to contain at least 1000 digits is " + index); // 4782
    }
}