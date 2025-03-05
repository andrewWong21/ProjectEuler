import java.util.*;

public class _76_CountingSummations{
    
    public static void main(String[] args){
        // 2 can be written in 1 way:  1+1
        // 3 can be written in 2 ways: 2+1, 1+1+1
        // 4 can be written in 4 ways: 3+1, 2+2, 2+1+1, 1+1+1+1
        // 5 can be written in 6 ways: 4+1, 3+2, 3+1+1, 2+2+1, 2+1+1+1, 1+1+1+1+1
        
        int[] sums = new int[101];
        sums[0] = 1;
        
        // i loops through every value from 1 up to, but not including, the target value n.
        // This corresponds using all integers from 1 to (n - 1) to sum to n.
        for (int i = 1; i < sums.length - 1; i++){
            // For every positive integer j from i to n, add to the number of currently known ways to write j
            // the number of ways to write the difference of i and j using positive integers at most equal to i.
            
            // e.g. 6 can be written as
            // 1+1+1+1+1+1               with [1]
            // 2+2+2, 2+2+1+1, 2+1+1+1+1 with [1, 2]
            // 3+3, 3+2+1, 3+1+1+1       with [1, 2, 3]
            // 4+2, 4+1+1                with [1, 2, 3, 4]
            // 5+1                       with [1, 2, 3, 4, 5]
            // 6                         with [1, 2, 3, 4, 5, 6]
            // This last way is not counted for the target value n.
            
            for (int j = i; j < sums.length; j++){
                sums[j] += sums[j - i];
            }
        }
        
        System.out.println("Number of ways to write 100 as a sum of at least two positive integers: " + sums[100]); // 190569291
    }
}