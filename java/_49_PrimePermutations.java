import java.util.*;

public class _49_PrimePermutations{
    
    public static ArrayList<Integer> sieve4Digits(){
        
        boolean[] sieved = new boolean[10000];
        sieved[0] = sieved[1] = true;
        
        for (int i = 2; i < sieved.length; i++){
            if (!sieved[i]){
                for (int j = 2*i; j < sieved.length; j += i){
                    sieved[j] = true;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int i = 1000; i < sieved.length; i++){
            if (!sieved[i]){
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static int[] getArithmeticSequence(ArrayList<Integer> nums){
        // Check each possible pair of numbers in the list and
        // calculate the difference between each pair of numbers.
        // If the larger of the pair plus the common difference also exists in the list,
        // then a 3-term arithmetic progression can be made from the list.
        
        for (int first = 0; first < nums.size() - 2; first++){
            for (int second = first + 1; second < nums.size() - 1; second++){
                int diff = nums.get(second) - nums.get(first);
                if (nums.contains(nums.get(second) + diff)){
                    return new int[]{nums.get(first), nums.get(second), (nums.get(second) + diff)};
                }
            }
        }
        return new int[0];
    }
    
    public static void main(String[] args){
        
        ArrayList<Integer> primes = sieve4Digits(); // 1061 4-digit primes
        
        HashMap<String, ArrayList<Integer>> permutations = new HashMap<>();
        
        // Organize primes into a hashmap and map them to their sorted digits.
        for (int prime : primes){
            char[] charArr = String.valueOf(prime).toCharArray();
            Arrays.sort(charArr);
            String str = String.valueOf(charArr);
            if (!permutations.containsKey(str)){
                permutations.put(str, new ArrayList<Integer>());
            }
            permutations.get(str).add(prime);
        }
        
        String concatenation = "";
        
        // Check each list of primes corresponding to a group of digits.
        // If there are at least three numbers in the list, check if
        // an arithmetic sequence can be formed using 3 of the numbers in the list.
        for (String digits : permutations.keySet()){
            
            // Skip checking the known progression [1487, 4817, 8147].
            if (digits.equals("1478")) continue;
            
            ArrayList<Integer> values = permutations.get(digits);
            if (values.size() >= 3 && getArithmeticSequence(values).length != 0){
                for (int term : getArithmeticSequence(values)){
                    concatenation += term;
                }
                break;
            }
        }
        
        System.out.println("Concatenation of three 4-digit permuted primes that form an arithmetic sequence: " + concatenation); // 296962999629
    }
}