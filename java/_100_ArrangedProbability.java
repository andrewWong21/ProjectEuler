import java.util.*;

public class _100_ArrangedProbability{
    
    public static void main(String[] args){
        long res = 0, max = (long) 1e12;
        
        // b / (b + r) * (b - 1) / (b + r - 1) = 1/2
        // 2b^2 - 2b = (b + r) * (b + r - 1)
        // 2b^2 - 2b = b^2 + br - b + br + r^2 - r
        // b^2 - b = 2br + r^2 - r
        // b^2 + (-2r - 1) * b + (r - r^2) = 0
        
        // b = ((2r + 1) +/- sqrt(4r^2 + 4r + 1 - 4r + 4r^2)) / 2
        // b = ((2r + 1) +/- sqrt(8r^2 + 1)) / 2
        // b = r + (1 +/- sqrt(8r^2 + 1)) / 2
        // remove negative solution  - sqrt(8r^2 + 1) > 1 for all r > 0
        // arrangement must have red discs to have a 50% chance of picking two blue discs
        
        // b = r + (1 + sqrt(8r^2 + 1)) / 2
        // b is a positive integer, so sqrt(8r^2 + 1) must be an odd integer x
        // x = sqrt(8r^2 + 1), x^2 = 8r^2 + 1, x^2 - 8r^2 = 1
        
        // fundamental solution (x_f, r_f) = (3, 1): 9 - 8 = 1
        long x_f = 3, r_f = 1;
        long x = x_f, r = r_f;
        
        while (true){
            double discSqrt = Math.sqrt(8.0 * r * r + 1);
            // check if sqrt(8r^2 + 1) is an odd integer
            if (discSqrt % 1 == 0 && discSqrt % 2 == 1){
                long b = r + (1 + (long) discSqrt) / 2;
                if (b + r >= max){
                    res = b;
                    break;
                }
            }
            
            // generate next solution to x^2 - 8r^2 = 1 using recurrence relation
            long x_n = x_f * x + 8 * r_f * r;
            long r_n = x_f * r + r_f * x;
            x = x_n;
            r = r_n;
        }
        
        System.out.println("Number of blue discs in first arrangement with over 1 trillion discs: " + res); // 
    }
}
