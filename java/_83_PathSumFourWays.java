import java.util.*;
import java.io.File;

public class _82_PathSumFourWays{
    
    public static void main(String[] args){
        
        int minSum = Integer.MAX_VALUE;
        
        try{
            File file = new File("0083_matrix.txt");
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
            // }; // 2297
            
            int rows = matrix.length;
            int cols = matrix[0].length;
            HashSet<Integer> s = new HashSet<>();
            
            // Use Djikstra's algorithm to find the shortest path.
            int[][] weights = new int[rows][cols];
            for (int[] row : weights){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            
            // Initialize the source node as the corresponding entry,
            // as the sum also includes the value of the top left cell.
            weights[0][0] = matrix[0][0];
            
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>(){
                public int compare(List<Integer> o1, List<Integer> o2){
                    return o1.get(0) - o2.get(0);
                }
            });
            pq.add(List.of(0, 0, 0));
            
            while (!pq.isEmpty()){
                List<Integer> cell = pq.poll();
                int r = cell.get(1);
                int c = cell.get(2);
                
                // Check the 4-adjacent neighboring cells that are within array bounds.
                int[] nX = {r - 1, r, r, r + 1};
                int[] nY = {c, c - 1, c + 1, c};
                for (int n = 0; n < nX.length; n++){
                    if (nX[n] < 0 || nX[n] >= rows || nY[n] < 0 || nY[n] >= cols) continue;
                    
                    // Update weight if smaller sum is found and recheck its neighbors.
                    int newWeight = weights[r][c] + matrix[nX[n]][nY[n]];
                    if (newWeight < weights[nX[n]][nY[n]]){
                        weights[nX[n]][nY[n]] = newWeight;
                        pq.add(List.of(weights[nX[n]][nY[n]], nX[n], nY[n]));
                    }
                }
            }
            
            minSum = weights[rows - 1][cols - 1];
            
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Minimal path sum from top left to bottom right: " + minSum); // 425185
    }
}