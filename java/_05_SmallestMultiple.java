import java.util.*;

public class _05_SmallestMultiple{
    
    public static long getGCD(long a, long b){
        if (b > a){
            return getGCD(b, a);
        }
        
        // If b divides a evenly, then b itself is the GCD of a and b.
        if (a % b == 0){
            return b;
        }
        
        // The GCD of two integers a,b is equal to the GCD
        // of the smaller integer and the remainder after
        // dividing the larger integer by the smaller one.
        return getGCD(b, a % b);
    }
    
    public static void main(String[] args){
        // Integer overflow occurs at the final iteration if ints are used instead.
        long num = 2520;
        
        // 2520 is the smallest positive integer divisible by
        // every integer from 1 to 10, so given this, the
        // number of additional iterations can be reduced.
        
        // iterate through integers to find the new total,
        // which will be the least common multiple of the
        // current total and the next integer.
        for (int i = 11; i <= 20; i++){
            // The least common multiple of two integers equals 
            // their product divided by their greatest common divisor.
            num = (num * i) / getGCD(num, i);
        }
        System.out.println("Smallest positive integer evenly divisible by all integers [1, 20]: " + num);
    }
}