import java.util.*;

public class _09_SpecialPythagoreanTriplet{
    
    // The constraints a < b < c and a + b + c = 1000 
    // allow upper bounds to be defined for a and b.
    
    // Suppose that a = 333.
    // Then b must be at least 334 and c at least 335.
    // However, this violates the condition that a + b + c = 1000.
    // Therefore, the maximum value of a must be 332.
    
    // Suppose that b = 500, then c must be at least 501.
    // However, this violates the condition that a + b + c = 1000.
    // Therefore, the maximum value of b must be 499.
    
    public static int[] getTriplet(){
        for (int a = 1; a < 333; a++){
            for (int b = a + 1; b < 500; b++){
                // If a and b are too large, there may not be a c 
                // that is strictly greater than both a and b
                // and also sums to 1000 with them.
                if (1000 - a - b > b){
                    // Instead of having a third loop to iterate for values of c,
                    // define c in terms of a, b, and 1000.
                    int c = 1000 - a - b; // a + b + c = 1000
                    if (a*a + b*b == c*c){
                        // System.out.println(a + ", " + b + ", " + c + "\t" + (a*a + b*b) + " " + c*c);
                        return new int[]{a, b, c};
                    }
                }
            }
        }
        return new int[3];
    }
    
    public static void main(String[] args){
        
        int[] triplet = getTriplet();
        
        System.out.println("The Pythagorean triplet that adds up to 1000 is " + Arrays.toString(triplet)); // [200, 375, 425]
        System.out.println("The product of these numbers is " + triplet[0] * triplet[1] * triplet[2]); // 31875000
    }
}