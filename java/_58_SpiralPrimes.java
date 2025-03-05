import java.util.*;

public class _58_SpiralPrimes{
    
    public static boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        
        // Corners of 3x3 square: 3, 5, 7, 9
        // Corners of 5x5 square: 13, 17, 21, 25
        // Corners of 7x7 square: 31, 37, 43, 49
        
        // Corners of nxn square: n*n, n*n - n + 1, n*n - 2*n + 2, n*n - 3*n + 3
        
        // Numbers in diagonals of 3x3 square: 5
        // Numbers in diagonals of 5x5 square: 9
        // Numbers in diagonals of 7x7 square: 13
        
        int length = 3;
        int numPrimes = 3; // 3, 5, 7
        int corner = 9;
        
        while (numPrimes * 10 >= (2*length - 1)){
            length += 2;
            
            // Check the primality of the four corners.
            for (int i = 0; i <= 3; i++){
                corner += length - 1;
                
                if (isPrime(corner)){
                    numPrimes++;
                }
            }
            // System.out.println(numPrimes + "/" + (2*length - 1) + " = " + numPrimes / (2.0*length - 1));
        }
        
        System.out.println("The ratio of primes along both diagonals first falls below 10% when the side length is " + length); // 26241
    }
}