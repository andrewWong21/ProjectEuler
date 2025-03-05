import java.util.*;

public class _45_TriangularPentagonalHexagonal{
    
    public static boolean isTriangular(long t){
        // t = n * (n + 1) / 2    n = 1, 2, 3, ...
        // 2t = n^2 + n    -->    n^2 + n - 2t = 0
        // The positive root is n = (sqrt(8t + 1) - 1) / 2
        
        double n = (Math.sqrt(8*t + 1) - 1) / 2;
        return n == Math.floor(n);
    }
    
    public static boolean isPentagonal(long p){
        // p = n * (3n - 1) / 2    n = 1, 2, 3, ...
        // 2p = 3n^2 - n    -->    3n^2 - n - 2p = 0
        // The positive root is n = (sqrt(1 + 24p) + 1) / 6
        
        double n = (Math.sqrt(24*p + 1) + 1) / 6;
        return n == Math.floor(n);
    }
    
    public static boolean isHexagonal(long h){
        // h = n * (2n - 1)       n = 1, 2, 3, ...
        // h = 2n^2 - n    -->    2n^2 - n - h = 0
        // The positive root is n = (sqrt(8h + 1) + 1) / 4
        
        double n = (Math.sqrt(8*h + 1) + 1) / 4;
        return n == Math.floor(n);
    }
    
    public static long getTriangle(long n){
        return n * (n + 1) / 2;
    }
    
    public static long getPentagon(long n){
        return (3*n*n - n) / 2;
    }
    
    public static long getHexagon(long n){
        return 2*n*n - n;
    }
    
    public static void main(String[] args){
        
        // The first 10 triangular numbers are 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
        // The first 10 pentagonal numbers are 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
        // The first 10 hexagonal numbers are 1, 6, 15, 28, 45, 66, 91, 120, 153, 190, ...
        
        // At a glance, it can be seen that the first 5 hexagonal numbers are also triangular.
        // (H_1 = T_1, H_2 = T_3, H_3 = T_5, H_4 = T_7, H_5 = T_9)
        // This suggests the relation H_n = T_(2n - 1).
        // Examining and comparing their respective formulas:
        // H_n = n * (2n - 1) = 2n^2 - n
        // T_(2n - 1) = (2n - 1) * (2n - 1 + 1) / 2 = (2n - 1) * (2n)/2 = (2n - 1) * n = 2n^2 * n
        // This relation holds true for all positive integers n.
        
        // To find the next integer that is simultaneously triangular, pentagonal, and hexagonal,
        // it is sufficient to iterate though subsequent hexagonal numbers and check if they are pentagonal.
        
        long nextTPH = 0;
        
        // starting from H_144
        int n = 144;  
        while (nextTPH == 0){
            long h = getHexagon(n);
            if (isPentagonal(h)){
                nextTPH = h;
            }
            n++;
        }
        
        System.out.println("Next triangular number that is also pentagonal and hexagonal: " + nextTPH); // 1533776805
        // 1533776805 = H_27693 = P_31977 = T_55385
        // System.out.println(getTriangle(55385));
        // System.out.println(getPentagon(31977));
        // System.out.println(getHexagon(27693));
    }
}