import java.util.*;
import java.io.File;

public class _59_XORDecryption{
    
    public static int getMax(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }
    
    public static void main(String[] args){
        
        int sum = 0;
        File inputFile = new File("0059_cipher.txt");
        
        try{
            Scanner sc = new Scanner(inputFile);
            String[] splitArr = sc.next().split(",");
            int[] encrypted = new int[splitArr.length];
            
            for (int i = 0; i < splitArr.length; i++){
                encrypted[i] = Integer.valueOf(splitArr[i]);
            }
            String key = "", plaintext = "";
            
            // The encryption key is known to be three lowercase letters.
            // The 26^3 = 17576 possible keys range from "aaa" to "zzz".
            char c1 = 'a', c2 = 'a', c3 = 'a';
            while (key.compareTo("zzz") <= 0){
                
                key = "" + c1 + c2 + c3;
                int[] decrypted = new int[encrypted.length];
                plaintext = "";
                
                for (int i = 0; i < encrypted.length; i++){
                    decrypted[i] = encrypted[i]^(key.charAt(i % key.length()));
                    plaintext += (char) decrypted[i];
                }
                
                char[] chars = plaintext.toCharArray();
                int[] charCounts = new int[128];
                
                // Since the plaintext contains common English words, 
                // " the " should show up in the text when correctly decrypted.
                // Other common parts of speech may also be checked to make sure the
                // candidate key does not only occasionally produce valid words.
                if (plaintext.contains(" the ")){
                    for (int c : decrypted){
                        sum += c;
                    }
                    break;
                }
                
                if (c2 == 'z' && c3 == 'z'){
                    c2 = c3 = 'a';
                    c1++;
                }
                else if (c3 == 'z'){
                    c3 = 'a';
                    c2++;
                }
                else{
                    c3++;
                }
            }
            
            // System.out.println(key);
            // System.out.println(plaintext);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("The sum of the ASCII values in the original text is " + sum); // 129448
    }
}