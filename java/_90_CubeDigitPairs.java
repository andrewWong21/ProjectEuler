import java.util.*;

public class _90_CubeDigitPairs{
    
    public static List<Set<Integer>> generateCombs(int n, int k){
        List<Set<Integer>> combs = new ArrayList<>();
        backtrack(combs, new HashSet<>(), n, k, 0);
        return combs;
    }
    
    public static void backtrack(List<Set<Integer>> combs, Set<Integer> curr, int n, int k, int start){
        if (curr.size() == k){
            combs.add(new HashSet<>(curr));
            return;
        }
        for (int i = start; i <= n; i++){
            curr.add(i);
            backtrack(combs, curr, n, k, i + 1);
            curr.remove(i);
        }
    }
    
    public static boolean canDisplay(Set<Integer> d1, Set<Integer> d2){
        // allow 6 or 9 to be turned upside-down
        if (d1.contains(6) || d1.contains(9)){
            d1.add(6);
            d1.add(9);
        }
        if (d2.contains(6) || d2.contains(9)){
            d2.add(6);
            d2.add(9);
        }
        for (int i = 1; i < 10; i++){
            int sq = i * i;
            // return false if cubes cannot display both digits of the square together
            if (
                !(d1.contains(sq / 10) && d2.contains(sq % 10)) &&
                !(d1.contains(sq % 10) && d2.contains(sq / 10))
            ){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        int res = 0;
        List<Set<Integer>> combs = generateCombs(9, 6);
        for (int i = 0; i < combs.size(); i++){
            for (int j = i + 1; j < combs.size(); j++){
                if (canDisplay(combs.get(i), combs.get(j))){
                    res++;
                }
            }
        }
        
        System.out.println("Number of distinct arrangments that can display the first 9 square numbers: " + res); // 1217
    }
}
