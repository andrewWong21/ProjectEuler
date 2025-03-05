import java.util.*;
import java.io.File;

public class _44_PentagonalNumbers{
    
    public static boolean isPentagonal(int p){
        // The formula for a pentagonal number is p = n * (3n - 1) / 2.
        // To check if a given number is pentagonal, rewrite the formula as
        // 2p = 3n^2 - n    -->    3n^2 - n - 2p = 0
        // The roots of this quadratic equation are n = (1 +- sqrt(1 + 24p)) / 6
        // n must be positive, so it is sufficient to check if (1 + sqrt(24p + 1)) / 6 is an integer.
        
        double n = (1 + Math.sqrt(24*p + 1)) / 6;
        
        return n == Math.floor(n);
    }
    
    public static int getPentagon(int n){
        return (3*n*n - n) / 2;
    }
    
    public static void main(String[] args){
        
        // The goal is to find the minimum difference D of two pentagonal numbers whose difference and sum are both pentagonal.
        
        // The first 10 pentagonal numbers are 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
        // Since D must be pentagonal, we can check pairs of higher pentagonal numbers to see if their difference is D.
        // The smallest pentagonal number that is also a difference of two pentagonal numbers is 22 = 92 - 70 (P_4 = P_8 - P_7).
        
        // Once a pair of pentagonal numbers with difference D has been found, their sum is checked.
        // If the sum is pentagonal, the current value for D is the minimum value and the search is complete.
        
        // As the pentagonal numbers get larger, the difference between consecutive numbers also increases.
        // When this difference exceeds the current value for D, all possible pairs have been checked.
        
        // To efficiently search pairs, more needs to be known about the possible indices of
        // the smaller pentagonal number and how far ahead the larger pentagonal number may be.
        
        // D = P_k - P_j, k > j
        // Rewrite P_k and P_j using the pentagonal formula.
        // D = (k * (3k - 1)) / 2 - (j * (3j - 1)) / 2 = (3k^2 - k - 3j^2 + j) / 2
        // Since k > j, k can be written as j + x.
        // 3k^2 - k = 3(j + x)^2 - (j + x) = 3j^2 + 3x^2 + 6jx - j - x
        // D = (3j^2 + 3x^2 + 6jx - j - x - 3j^2 + j) / 2
        // D = (3x^2 + 6jx - x) / 2 = 3jx + (P_x)
        // D = 3jx + P_x    -->    3jx = D - P_x
        // The index of the smaller pentagonal number can be written as j = (D - P_x) / (3x)
        // D is by definition pentagonal, so D = P_n where n > x, as j = 1, 2, 3, ...
        // The difference D - P_x must be a multiple of 3x for j to be an integer.
        
        int minDiff = 0;
        
        int n = 4;
        while (minDiff == 0){
            int pentD = getPentagon(n);
            
            for (int x = 1; x < n; x++){
                int pentX = getPentagon(x);
                
                if ((pentD - pentX) % (3*x) == 0){
                    int j = (pentD - pentX) / (3*x);
                    int pentJ = getPentagon(j);
                    int pentK = getPentagon(j + x);
                    
                    if (isPentagonal(pentJ + pentK)){
                        minDiff = pentD;
                        break;
                    }
                }
            }
            
            n++;
        }
        
        // System.out.println(getPentagon(2167) + getPentagon(1020) == getPentagon(2395));
        // System.out.println(getPentagon(2167) - getPentagon(1020) == getPentagon(1912));
        
        System.out.println("Minimal difference of pentagonal numbers that is also pentagonal: " + minDiff); // 5482660
        // 5482660 = 7042750 - 1560090 (P_1912 = P_2167 - P_1020)
        // 7042750 + 1560090 = 8602840 (P_2167 + P_1020 = P_2395)
    }
}