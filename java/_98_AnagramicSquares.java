import java.util.*;
import java.io.File;

public class _98_AnagramicSquares{
    
    static Map<String, List<String>> anagrams = new HashMap<>();
    static List<List<Integer>> squaresList = new ArrayList<>();
    
    private static String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private static int mapSquares(List<String> words){
        int len = anagramList.size();
        // word list must have at least 2 words to form square anagram word pairs
        if (len < 2) return 0;
        
        // iterate over each possible word pair and map to squares of same length
        for (int i = 0; i < len; i++){
            for (int sq : squaresLists.get()){
                // TODO: create square-word and word-square mappings and check validity
            }
            for (int j = i + 1; j < len; j++){
                int sq = mapSquares(anagramList.get(i), anagramList.get(j));
                res = Math.max(res, sq);
            }
        }
    }
    
    public static void main(String[] args){
        int res = 0, maxLen = 0;
        
        try{
            File file = new File("0098_words.txt");
            Scanner sc = new Scanner(file);
            
            String[] words = sc.next().replace("\"", "").split(",");
            for (String word : words){
                // group words according to used letters
                String letters = sortString(word);
                anagrams.putIfAbsent(letters, new ArrayList<String>());
                anagrams.get(letters).add(word);
                
                // update maximum length of squares to check
                if (anagrams.get(letters).size() >= 2){
                    maxLen = Math.max(maxLen, word.length());
                }
            }
            
            for (int i = 0; i < maxLen; i++){
                squaresList.add(new ArrayList<>());
            }
            
            // calculate squares with up to maxLen digits
            for (int i = 1; ; i++){
                int digits = (int) Math.log10(i * i) + 1;
                System.out.println((i * i) + " " + digits);
                if (digits > maxLen) break;
            }
            
            for (List<String> anagramList : anagrams){
                res = Math.max(res, mapSquares(anagramList));
            }
            sc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Largest square number formed in square anagram word pairs: " + res); // 
    }
}
