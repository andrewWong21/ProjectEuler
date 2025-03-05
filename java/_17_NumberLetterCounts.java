import java.util.*;

public class _17_NumberLetterCounts{
    
    public static void main(String[] args){
        int letterCount = 0;
        
        // ones are counted 10*9 times
        // (01-09, 21-29, 31-39, 41-49, ..., 961-69, 971-79, 981-89, 991-99)
        // plus another 100 times (100-199, 200-299, ..., 900-999) for a total of 190 times
        String ones = "onetwothreefourfivesixseveneightnine";
        letterCount += ones.length() * 190;
        
        // teens are counted 10 times (10-19, 110-119, 210-219, ..., 910-919)
        String teens = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
        letterCount += teens.length() * 10;
            
        // tens are counted 10*10 times (120-129, 130-139, ..., 980-989, 990-999)
        String tens = "twentythirtyfortyfiftysixtyseventyeightyninety";
        letterCount += tens.length() * 100;
        
        // "hundred" is counted 9*100 times (100-199, 200-299, ..., 900-999)
        String hundred = "hundred";
        letterCount += hundred.length() * 900;
        
        // "and" is counted 9*99 times (101-199, 201-299, ..., 901-999)
        String andStr = "and";
        letterCount += andStr.length() * 891;
        
        // 1000 is included in the full count
        String thousand = "onethousand";
        letterCount += thousand.length();
        
        System.out.println("The number of letters needed to write out all numbers from 1-1000 inclusive is " + letterCount); // 21124
    }
}