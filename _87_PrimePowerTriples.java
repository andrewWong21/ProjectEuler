import java.util.*;

public class _87_PrimePowerTriples{
    
    public static void main(String[] args){
        
        int n = 50000000;
        
        ArrayList<Integer> squares = new ArrayList<>();
        ArrayList<Integer> cubes = new ArrayList<>();
        ArrayList<Integer> fourths = new ArrayList<>();
        
        int maxSqrt = (int) Math.floor(Math.sqrt(n));
        int maxCbrt = (int) Math.floor(Math.cbrt(n));
        int max4th  = (int) Math.floor(Math.sqrt(Math.sqrt(n)));
        
        boolean[] sieved = new boolean[maxSqrt];
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = i+i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
                if (i <= max4th) fourths.add(i*i*i*i);
                if (i <= maxCbrt) cubes.add(i*i*i);
                squares.add(i*i);
            }
        }
        
        HashSet<Integer> triples = new HashSet<>();
        for (int square : squares){
            for (int cube : cubes){
                for (int fourth : fourths){
                    int sum = square + cube + fourth;
                    if (sum >= n){
                        break;
                    }
                    else{
                        triples.add(sum);
                    }
                }
            }
        }
        
        System.out.println("Numbers below fifty million that can be expressed as a sum of a prime square, cube, and fourth power: " + triples.size()); // 1097343
    }
}