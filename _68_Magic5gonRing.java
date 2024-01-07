import java.util.*;

public class _68_Magic5gonRing{
    
    public static boolean isValidRing(int[] nums){
        // string representation must have exactly 16 digits
        if (stringifyRing(nums).length() != 16) return false;
        
        // first external node must be the numerically lowest
        int[] externalNodes = new int[]{nums[0], nums[3], nums[5], nums[7], nums[9]};
        Arrays.sort(externalNodes);
        
        if (nums[0] != externalNodes[0]) return false;
        
        int sum = nums[1] + nums[8] + nums[9];
        for (int i = 0; i <= 6; i += 2){
            if (nums[i] + nums[i+1] + nums[i+2] != sum) return false;
        }
        return true;
    }
    
    public static String stringifyRing(int[] nums){
        
        StringBuilder str = new StringBuilder();
        int[] indices = new int[]{0, 1, 2, 3, 2, 4, 5, 4, 6, 7, 6, 8, 9, 8, 1};
        
        for (int i = 0; i < indices.length; i++){
            str.append(nums[indices[i]]);
        }
        
        return str.toString();
    }
    
    public static void permute(int[] nums){
        // Transform nums into its next permutation, in-place.
        
        int i = nums.length - 1;
        while (nums[i] < nums[i - 1]){
            i--;
        }
        if (i <= 0) return; // lexicographically last permutation
        
        // index of start of group of decreasing numbers: i
        // next different index in next permutation: i-1
        
        int j = i + 1;
        while (j < nums.length && nums[j] > nums[i - 1]){
            j++;
        }
        // j - 1: index of rightmost number in decreasing group
        // that is greater than number at index i-1
        
        // swap numbers at i-1 and j-1, and sort the group of numbers after i-1
        int temp = nums[j - 1];
        nums[j - 1] = nums[i - 1];
        nums[i - 1] = temp;
        
        Arrays.sort(nums, i, nums.length);
    }
    
    public static void main(String[] args){
        
        String maxRing = "";
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // index: 0123456789       012  324  546  768  981
        //   num: ABCDEFGHIJ       ABC; DCE; FEG; HGI; JIB
        
        // If 10 is not an external node in the ring, it will appear twice in the
        // string representation, resulting in a 17-digit string.
        
        int[] lastNums = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        while (!Arrays.equals(nums, lastNums)){
            if (isValidRing(nums)){
                String newRing = stringifyRing(nums);
                if (newRing.compareTo(maxRing) > 0){
                    maxRing = newRing;
                    // System.out.println(maxRing);
                }
            }
            permute(nums);
        }
        
        System.out.println("Maximum 16-digit string for a magic 5-gon ring: " + maxRing); // 6531031914842725
        // Solution set: 6,5,3; 10,3,1; 9,1,4; 8,4,2; 7,2,5
    }
}