import java.util.*;
import java.io.File;

public class _89_RomanNumerals{
    
    static String[] symbols = new String[]{
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV", "I"
    };
    static int[] numerals = new int[]{
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4, 1
    };
    
    public static int romToDec(String rom){
        int res = 0;
        for (int i = 0; i < symbols.length && !rom.isEmpty(); i++){
            while (rom.startsWith(symbols[i])){
                res += numerals[i];
                rom = rom.substring(symbols[i].length());
            }
        }
        return res;
    }
    
    public static String decToRom(int dec){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length && dec > 0; i++){
            while (dec >= numerals[i]){
                sb.append(symbols[i]);
                dec -= numerals[i];
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        int res = 0;
        File inputFile = new File("0089_roman.txt");
        
        try{
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNext()){
                String rom = reader.nextLine();
                int minLen = decToRom(romToDec(rom)).length();
                res += rom.length() - minLen;
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Number of characters saved: " + res); // 743
    }
}
