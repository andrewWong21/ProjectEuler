import java.util.*;
import java.math.BigInteger;

public class _29_DistinctPowers{
    
    public static void main(String[] args){
        
        int distinctTerms = 99 * 99;
        // a and b both have 99 possible values, so there are 99 * 99 possible combinations in total.
        // However, not all combinations will result in distinct terms.
        // When a is a power of a smaller integer, certain b values will result in duplicates.
        
        HashSet<Integer> perfectPowers = new HashSet<>();
        
        // Sixth powers contribute 62 duplicates to the total.
        // e.g. a = 64 = 2^6:
        // 64^2  =  8^4,  64^3  =  8^6,  64^4  =  8^8,  ..., 64^50 =  8^100    (b =  2,  3,  4, ..., 50)
        // 64^52 = 16^78, 64^54 = 16^81, 64^56 = 16^84, ..., 64^66 = 16^99     (b = 52, 54, 56, ..., 66)
        // 64^55 = 32^66, 64^60 = 32^72, 64^65 = 32^78, ..., 64^80 = 32^96     (b = 55, 60, 65, ..., 80)
        // Making sure not to count b = 60 twice, there are 62 values of b that result in duplicates.
        
        // 3^6 > 3^5 > 100, so the only sixth power that will contribute duplicates is 2^6 = 64.
        perfectPowers.add((int) Math.pow(2, 6));
        distinctTerms -= 62; // sixth power duplicates
        
        // Fifth powers contribute 48 duplicates to the total.
        // e.g. a = 32 = 2^5:
        // 32^2  =  2^10, 32^3  =  2^15, 32^4  =  2^20, ..., 32^20 =  2^100    (b =  2,  3,  4, ..., 20)
        // 32^22 =  4^55, 32^24 =  4^60, 32^26 =  4^65, ..., 32^40 =  4^100    (b = 22, 24, 26, ..., 40)
        // 32^21 =  8^35, 32^24 =  8^40, 32^27 =  8^45, ..., 32^60 =  8^100    (b = 21, 24, 27, ..., 60)
        // 32^24 = 16^30, 32^28 = 16^35, 32^32 = 16^40, ..., 32^80 = 16^100    (b = 24, 28, 32, ..., 80)
        // b = 24, 28, 30, 32, 36, 40, 48, 60 appears multiple times but should only be counted once.
        
        // 3^5 > 100, so the only fifth power that will contribute duplicates is 2^5 = 32.
        
        perfectPowers.add((int) Math.pow(2, 5));
        distinctTerms -= 48; // fifth power duplicates
        
        // Fourth powers contribute 58 duplicates to the total.
        // e.g. a = 16 = 2^4: 
        // 16^2  = 4^4,  16^3  = 4^6,  16^4  = 4^8,  ..., 16^50 = 4^100    (b =  2,  3,  4, ..., 50)    49
        // 16^51 = 8^68, 16^54 = 8^72, 16^57 = 8^76, ..., 16^75 = 8^100    (b = 51, 54, 57, ..., 75)     9
        // a is a fourth power when a = 16 or a = 81.
        HashSet<Integer> fourthPowers = new HashSet<>();
        for (int i = 2; i*i*i*i <= 100; i++){
            int power = i*i*i*i;
            if (!perfectPowers.contains(power)){
                fourthPowers.add(power);
                perfectPowers.add(power);
            }
        }
        distinctTerms -= 58 * fourthPowers.size();
        
        // Perfect cubes each contribute 49 duplicate powers to the total.
        // e.g. a = 8 = 2^3: 
        // 8^2  = 2^6,  8^3  = 2^9,  8^4  = 2^12, ..., 8^33 = 2^99    (b =   2,  3,  4, ..., 33)    32
        // 8^34 = 4^51, 8^36 = 4^54, 8^38 = 4^57, ..., 8^66 = 4^99    (b =  34, 36, 38, ..., 66)    17
        // a is a perfect cube when a = 8, 27, 64.
        
        HashSet<Integer> cubes = new HashSet<>();
        for (int i = 2; i*i*i <= 100; i++){
            int power = i*i*i;
            
            if (!perfectPowers.contains(power)){
                cubes.add(power);
                perfectPowers.add(power);
            }
        }
        distinctTerms -= 49 * cubes.size();
        
        // Perfect squares each contribute 49 duplicates to the total.
        // e.g. a = 4 = 2^2:
        // 4^2 = 2^4, 4^3 = 2^6, 4^4 = 2^8, ..., 4^50 = 2^100    (b = 2, 3, 4, ..., 50)
        // This occurs when a = 4, 9, 16, 25, 36, 49, 64, 81, 100.
        // Some of these perfect squares are also higher powers (16, 81),
        // so we remove them to prevent double-counting their duplicates.
        HashSet<Integer> squares = new HashSet<>();
        for (int i = 2; i*i <= 100; i++){
            int power = i*i;
            if (!perfectPowers.contains(power)){
                squares.add(power);
                perfectPowers.add(power);
            }
        }
        distinctTerms -= 49 * squares.size();
        
        // All seventh powers for n >= 2 are greater than 100, so they will not contribute any duplicates.
        
        
        // Brute force method for finding the distinct terms:
        // calculate all 9801 combinations of a and b,
        // store them in a set, and return the size of the set.
        
        // HashSet<BigInteger> distinctPowers = new HashSet<>();
        // for (int a = 2; a <= 100; a++){
            // for (int b = 2; b <= 100; b++){
                // // The maximum possible power is 100^100, which cannot fit into a 32-bit integer.
                // BigInteger result = BigInteger.valueOf(a).pow(b);
                // powers.add(result);
            // }
        // }
        
        System.out.println("The number of distinct terms generated by a^b, 2 <= a,b <= 100 is " + distinctTerms); // 9183
    }
}