import java.util.*;

public class _78_CoinPartitions{
    
    public static void main(String[] args){
        int[] partitions = new int[60001];
        partitions[0] = 1;
        
        for (int i = 1; i < partitions.length; i++){
            for (int j = i; j < partitions.length; j++){
                
                partitions[j] += partitions[j - i] % 1000000;
                partitions[j] %= 1000000;
            }
        }
        
        int ans = -1;
        for (int i = 0; i < partitions.length && ans == -1; i++){
            if (partitions[i] == 0){
                ans = i;
            }
        }

        System.out.println("Least value of n for which p(n) is divisible by 1 million: " + ans); // 55374
    }
}