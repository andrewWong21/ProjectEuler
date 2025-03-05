import java.util.*;
import java.io.File;

public class _67_MaximumPathSumII{
    
    public static void main(String[] args){
        
        File inputFile = new File("0067_triangle.txt");
        int maxTotal = 0;
        
        try{
            Scanner sc = new Scanner(inputFile);
            ArrayList<int[]> triangle = new ArrayList<>();
            
            int count = 1;
            while (sc.hasNext()){
                String[] nums = sc.nextLine().split(" ");
                int[] row = new int[count];
                for (int i = 0; i < row.length; i++){
                    row[i] = Integer.valueOf(nums[i]);
                }
                triangle.add(row);
                count++;
            }
            
            for (int i = triangle.size() - 2; i >= 0; i--){
                int[] row = triangle.get(i);
                int[] nextRow = triangle.get(i + 1);
                
                for (int j = 0; j < row.length; j++){
                    row[j] += Math.max(nextRow[j], nextRow[j+1]);
                }
                // System.out.println(Arrays.toString(triangle.get(i)));
            }
            maxTotal = triangle.get(0)[0];
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Maximum path sum: " + maxTotal); // 7273
    }
}