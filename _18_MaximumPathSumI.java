import java.util.*;

public class _18_MaximumPathSum{
    
    public static void main(String[] args){
        ArrayList<int[]> triangle = new ArrayList<>();
        triangle.add(new int[]{75});
        triangle.add(new int[]{95, 64});
        triangle.add(new int[]{17, 47, 82});
        triangle.add(new int[]{18, 35, 87, 10});
        triangle.add(new int[]{20,  4, 82, 47, 65});
        triangle.add(new int[]{19,  1, 23, 75,  3, 34});
        triangle.add(new int[]{88,  2, 77, 73,  7, 63, 67});
        triangle.add(new int[]{99, 65,  4, 28,  6, 16, 70, 92});
        triangle.add(new int[]{41, 41, 26, 56, 83, 40, 80, 70, 33});
        triangle.add(new int[]{41, 48, 72, 33, 47, 32, 37, 16, 94, 29});
        triangle.add(new int[]{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14});
        triangle.add(new int[]{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57});
        triangle.add(new int[]{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48});
        triangle.add(new int[]{63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31});
        triangle.add(new int[]{ 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23});
        
        // Starting from the second to last row, iterate up the triangle.
        // For each entry in the row, find the larger of the two adjacent
        // entries in the row below it and add it to the current entry.
        for (int i = triangle.size()-1; i > 0; i--){
            int[] currRow = triangle.get(i);
            int[] prevRow = triangle.get(i-1);
            for (int j = 0; j < prevRow.length; j++){
                prevRow[j] += Math.max(currRow[j], currRow[j+1]);
            }
        }
        // The resulting value at the top of the triangle will be the maximum path sum.
        System.out.println("The maximum path sum for the given triangle is " + triangle.get(0)[0]); // 1074
    }
}