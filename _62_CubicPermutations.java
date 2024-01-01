import java.util.*;

public class _62_CubicPermutations{
    
    public static void main(String[] args){
        
        long minCube = Long.MAX_VALUE;
        int maxLen = 8; // 345^3 = 41063625, 8 digits
        
        // Generate cubes up to a maximum specified length, grouping cubes together by the digits they use.
        // This ensures that all potential cubic permutations of a given group of digits
        // will be found before the number of cubes belonging to that group is checked.
        // If no group has exactly five members, increment the maximum length and repeat until the answer is found.
        
        while (minCube == Long.MAX_VALUE){
            HashMap<String, ArrayList<Long>> cubeDigits = new HashMap<>();
            
            for (long n = 345; Math.log10(n*n*n) <= maxLen; n++){
                
                long cube = n*n*n;
                // System.out.println(cube);
                char[] chars = String.valueOf(cube).toCharArray();
                Arrays.sort(chars);
                String str = String.valueOf(chars);
                
                if (!cubeDigits.containsKey(str)){
                    cubeDigits.put(str, new ArrayList<Long>());
                }
                cubeDigits.get(str).add(cube);
            }
        
            for (String key : cubeDigits.keySet()){
                ArrayList<Long> val = cubeDigits.get(key);
                if (val.size() != 5) continue;
                
                // System.out.println(val);
                minCube = val.get(0) < minCube ? val.get(0) : minCube;
            }
            
            maxLen++;
        }
        
        System.out.println("Smallest cube that can be permuted to produce exactly four other cubes: " + minCube); // 127035954683
    }
}