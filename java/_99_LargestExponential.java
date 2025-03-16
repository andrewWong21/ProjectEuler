import java.util.*;
import java.io.File;

public class _99_LargestExponential{
    
    public static void main(String[] args){
        int line = 0;
        double logRes = 0;
        
        try{
            File file = new File("0099_base_exp.txt");
            Scanner sc = new Scanner(file);
            
            int i = 1;
            while (sc.hasNextLine()){
                String[] nums = sc.nextLine().split(",");
                double curr = Integer.valueOf(nums[1]) * Math.log10(Integer.valueOf(nums[0]));
                if (curr > logRes){
                    logRes = curr;
                    line = i;
                }
                i++;
            }
            sc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Line number with greatest numerical value: " + line); // 709
    }
}
