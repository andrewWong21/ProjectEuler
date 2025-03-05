import java.util.*;
import java.time.*;

public class _19_CountingSundays{
    
    public static void main(String[] args){
        
        int numSundays = 0;
        
        LocalDate date = LocalDate.of(1901, 1, 1);
        
        while (date.getYear() < 2001){
            // System.out.println(date + " " + date.getDayOfWeek());
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY){
                numSundays++;
            }
            date = date.plusMonths(1);
        }
        
        System.out.println("The number of months that started on a Sunday from 1901 until 2001 is " + numSundays); // 171
    }
}