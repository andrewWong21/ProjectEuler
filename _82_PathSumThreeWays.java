import java.util.*;
import java.io.File;

public class _82_PathSumThreeWays{
    
    public static void main(String[] args){
        
        int minSum = Integer.MAX_VALUE;
        
        try{
            File file = new File("0082_matrix.txt");
            Scanner sc = new Scanner(file);
            
            int[][] matrix = new int[80][80];
            int i = 0;
            while (sc.hasNext()){
                String[] nums = sc.next().split(",");
                for (int j = 0; j < nums.length; j++){
                    matrix[i][j] = Integer.valueOf(nums[j]);
                }
                i++;
            }
            // int[][] matrix = {
                // {131, 673, 234, 103, 18},
                // {201, 96, 342, 965, 150},
                // {630, 803, 746, 422, 111},
                // {537, 699, 497, 121, 956},
                // {805, 732, 524, 37, 331}
            // };
            
            int rows = matrix.length;
            int cols = matrix[0].length;
            
            // Keep track of the cumulative sums of the current column. 
            int[] colSums = new int[rows];
            for (int c = 0; c < cols; c++){
                
                // Obtain the resulting path sum after moving right from the cell to the left.
                for (int r = 0; r < rows; r++){
                    colSums[r] += matrix[r][c];
                }
                
                // Store the path sum after moving down from the cell above if smaller than the current sum.
                for (int r = 1; r < rows; r++){
                    colSums[r] = Math.min(colSums[r], colSums[r - 1] + matrix[r][c]);
                }
                
                // Store the path sum after moving up from the cell below if smaller than the current sum.
                for (int r = rows - 2; r >= 0; r--){
                    colSums[r] = Math.min(colSums[r], colSums[r + 1] + matrix[r][c]);
                }
            }
            
            for (int sum : colSums){
                minSum = Math.min(sum, minSum);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Minimal path sum from left column to right column: " + minSum); // 260324
    }
}