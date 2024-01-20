import java.util.*;
import java.io.File;

public class _81_PathSumTwoWays{
    
    public static void main(String[] args){
        
        int sum = 0;
        
        try{
            File file = new File("0081_matrix.txt");
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
            
            for (int r = matrix.length - 1; r >= 0; r--){
                for (int c = matrix[0].length - 1; c >= 0; c--){
                    if (r == matrix.length - 1 && c == matrix[0].length - 1){
                        continue;
                    }
                    else if (r == matrix.length - 1){
                        matrix[r][c] += matrix[r][c+1];
                    }
                    else if (c == matrix[0].length - 1){
                        matrix[r][c] += matrix[r+1][c];
                    }
                    else{
                        matrix[r][c] += Math.min(matrix[r][c+1], matrix[r+1][c]);
                    }
                }
            }
            
            sum = matrix[0][0];
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Minimal sum from top left to bottom right, only moving right and down: " + sum); // 427337
    }
}