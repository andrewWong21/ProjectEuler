import java.util.*;

public class _28_NumberSpiralDiagonals{
    
    public static void main(String[] args){
        // Sum for 1x1 spiral: 1 = 1
        // Sum for 3x3 spiral: 1 + 3 + 5 + 7 + 9 = 25
        // Sum for 5x5 spiral: 1 + 3 + 5 + 7 + 9 + 13 + 17 + 21 + 25 = 101
        
        // Looking at the 5x5 spiral:
        // 21 22 23 24 25           21          25
        // 20  7  8  9 10               7     9
        // 19  6  1  2 11                  1
        // 18  5  4  3 12               5     3
        // 17 16 15 14 13           17          13
        
        // Every time the spiral increases in size, another 4 terms are added.
        // These terms correspond to the entries in each corner of the spiral.
        
        // Top right corner   : n*n                 (9, 25)     3*3 = 9, 5*5 = 25
        // Top left corner    : n*n -   n + 1       (7, 21)     9 - 2 = 7, 25 - 4 = 21
        // Bottom left corner : n*n - 2*n + 2       (5, 17)     7 - 2 = 5, 21 - 4 = 17
        // Bottom right corner: n*n - 3*n + 3       (3, 13)     5 - 2 = 3, 17 - 4 = 13
        // Sum: 4*n*n - 6*n + 6
        
        // The four terms form an arithmetic sequence with a common difference of n - 1.
        // n = 3: 3, 5, 7, 9        common difference of 2
        // n = 5: 13, 17, 21, 25    common difference of 4
        
        int sum = 1; // initial 1x1 spiral has only one term
        for (int n = 3; n <= 1001; n += 2){
            sum += 4*n*n - 6*n + 6;
        }
        
        System.out.println("The sum of the numbers on the diagonals in a 1001x1001 spiral is " + sum); // 669171001
    }
}