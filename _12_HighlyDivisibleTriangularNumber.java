import java.util.*;
import java.math.BigInteger;

public class _12_HighlyDivisibleTriangularNumber{
    
    public static int getNumDivisors(int num){
        // Factors are paired, so return double
        // the number of found factors, and add
        // 1 if num is also a square number.
        int foundFactors = 2;
        ArrayList<Integer> factors = new ArrayList<>();
        factors.add(1);
        factors.add(num);
        for (int i = 2; i < Math.sqrt(num); i++){
            if (num % i == 0){
                factors.add(i);
                foundFactors += 2;
            }
        }
        if (Math.floor(Math.sqrt(num)) * Math.floor(Math.sqrt(num)) == num){
            foundFactors++;
            factors.add((int)Math.sqrt(num));
        }
        // System.out.println(factors.toString());
        return foundFactors;
    }
    
    public static int getTriangularNum(int num){
        // T(1) = 1, T(2) = 1 + 2 = 3, T(3) = 1 + 2 + 3 = 6, ...
        // The formula for calculating the nth triangular number
        // is the sum of natural numbers from 1 to n.
        return num * (num + 1) / 2;
    }
    
    public static void main(String[] args){
        int triangle = 0;
        int divisors = 0;
        for (int n = 1; divisors < 500; n++){
            
            triangle = getTriangularNum(n);
            divisors = getNumDivisors(triangle);
            // System.out.println(triangle + " " + divisors);
        }
        System.out.println("The first triangular number with over 500 divisors is " + triangle); // 76576500
    }
}