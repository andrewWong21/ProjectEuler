import java.util.*;
import java.io.File;

public class _98_AnagramicSquares{
    
    static Map<String, List<String>> anagramLists = new HashMap<>();
    static List<List<Integer>> squaresList = new ArrayList<>();
    
    private static String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private static int mapSquares(List<String> words){
        int len = words.size();
        int res = 0;
        // word list must have at least 2 words to form square anagram word pairs
        if (len < 2) return 0;
        
        // iterate over each possible word pair and map to squares of same length
        List<Integer> squares = squaresList.get(words.get(0).length());
        for (int s : squares){
            String sq = String.valueOf(s);
            
            for (int i = 0; i < len; i++){
                String w1 = words.get(i);
                Map<Character, Character> digitToChar = new HashMap<>();
                Map<Character, Character> charToDigit = new HashMap<>();
                
                boolean isValidMapping = true;
                for (int idx = 0; idx < w1.length(); idx++){
                    char c = w1.charAt(idx);
                    char d = sq.charAt(idx);
                    if ((charToDigit.containsKey(c) && charToDigit.get(c) != d) || 
                        (digitToChar.containsKey(d) && digitToChar.get(d) != c)
                    ){
                        isValidMapping = false;
                        break;
                    }
                    charToDigit.put(c, d);
                    digitToChar.put(d, c);
                }
                if (!isValidMapping) continue;
                
                // check if another word can be mapped to an anagram of the chosen square
                for (int j = i + 1; j < len; j++){
                    StringBuilder sq2 = new StringBuilder();
                    for (char c : words.get(j).toCharArray()){
                        if (!charToDigit.containsKey(c)) break;
                        sq2.append(charToDigit.get(c));
                    }
                    if (sq2.length() == w1.length()){
                        int s2 = Integer.valueOf(sq2.toString());
                        if (!squares.contains(s2)) break;
                        res = Math.max(res, s2);
                    }
                }
            }
        }
        return res;
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
                anagramLists.putIfAbsent(letters, new ArrayList<String>());
                anagramLists.get(letters).add(word);
                
                // update maximum length of squares to check
                if (anagramLists.get(letters).size() >= 2){
                    maxLen = Math.max(maxLen, word.length());
                }
            }
            
            for (int i = 0; i <= maxLen; i++){
                squaresList.add(new ArrayList<>());
            }
            
            // calculate squares with up to maxLen digits
            for (int i = 1; ; i++){
                int digits = (int) Math.log10(i * i) + 1;
                if (digits > maxLen) break;
                squaresList.get(digits).add(i * i);
            }
            
            for (List<String> anagramList : anagramLists.values()){
                res = Math.max(res, mapSquares(anagramList));
            }
            sc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Largest square number formed in square anagram word pairs: " + res); // 18769
    }
}
