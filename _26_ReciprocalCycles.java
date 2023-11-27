import java.util.*;

public class _26_ReciprocalCycles{
    
    public static int getCycleLength(int num){
        int remainder = 1;
        int currStep = 0;
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        
        // Convert the fraction into a decimal and continue
        // until either a repeating set of remainders is found
        // or the decimal terminates.
        while (remainder != 0){
            remainder = (remainder * 10) % num;
            
            // If the remainder has been encountered previously,
            // there is a cycle in the decimal representation.
            if (lastSeen.containsKey(remainder)){
                return currStep - lastSeen.get(remainder);
            }
            
            // Store the digits and the current position.
            lastSeen.put(remainder, currStep);
            currStep++;
        }
        return 0; // terminating decimal
    }
    
    public static void main(String[] args){
        
        int num = 0;
        int longestCycle = 0;
        
        for (int d = 1; d < 1000; d++){
            int cycle = getCycleLength(d);
            System.out.printf("d: %d\tlen: %d\n", d, cycle);
            if (cycle > longestCycle){
                longestCycle = cycle;
                num = d;
            }
        }
        System.out.println("The integer under 1000 with the longest recurring cycle in its reciprocal is " + num); // 983
    }
}