import java.util.*;
import java.io.File;

public class _22_NamesScores{
    
    public static int getNameScore(String name){
        int nameSum = 0;
        for (char c : name.toCharArray()){
            // Calculate the alphabetical value of the character.
            // e.g. A=1, B=2, C=3, ..., Z=26
            nameSum += (int)(c) - 'A' + 1;
        }
        return nameSum;
    }
    
    public static void main(String[] args){
        int scoreSum = 0;
        
        File inputFile = new File("0022_names.txt");
        
        try{
            Scanner reader = new Scanner(inputFile);
            String[] names = new String[0];
            while (reader.hasNextLine()) {
                names = reader.nextLine().replaceAll("\"", "").split(",");
            }
            Arrays.sort(names);
            
            for (int i = 0; i < names.length; i++){
                // Add the name score, multiplied by its
                // 1-based alphabetical position in the list,
                // to the total sum.
                scoreSum += (i + 1) * getNameScore(names[i]);
                // System.out.println(names[i] + " " + getNameScore(names[i]));
            }
            reader.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("The total of all the name scores in the file is " + scoreSum); // 871198282
    }
}