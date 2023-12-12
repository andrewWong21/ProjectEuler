import java.util.*;
import java.io.File;

public class _42_CodedTriangleNumbers{
    
    public static boolean isTriangleNumber(int score){
        // The formula for a triangle number is t = n/2 * (n + 1), where n = 1, 2, 3,...
        // To check if a given number is a triangle number, rewrite the formula as
        // 2t = n * (n + 1) = n^2 + n    -->    n^2 + n - 2t = 0
        // The roots of this quadratic equation are n = (-1 +- sqrt(1 + 8t)) / 2
        // n must be positive, so it is sufficient to check if (sqrt(8t + 1) - 1) / 2 is an integer.
        
        double n = (Math.sqrt(8 * score + 1) - 1) / 2;
        
        return n == Math.floor(n);
    }
    
    public static int getWordScore(String word){
        int score = 0;
        for (int i = 0; i < word.length(); i++){
            score += word.charAt(i) - 'A' + 1;
        }
        return score;
    }
    
    public static void main(String[] args){
        
        int count = 0;
        
        File inputFile = new File("0042_words.txt");
        
        try{
            Scanner sc = new Scanner(inputFile);
            String[] words = sc.next().replaceAll("\"", "").split(",");
            
            for (String word : words){
                int score = getWordScore(word);
                if (isTriangleNumber(score)){
                    // System.out.printf("%s: t = %d\n", word, score);
                    count++;
                }
            }
        }
        catch (Exception e){
            System.out.println("File not found.");
        }
        
        System.out.println("Number of triangle words in the file: " + count); // 162
    }
}