import java.util.*;

public class _85_CountingRectangles{
    
    public static void main(String[] args){
        
        // A rectangle measuring 3 by 2 contains 18 rectangles.
        // 1x1 rectangles: 6        (3*2)
        // 2x1 rectangles: 4        (2*2)
        // 3x1 rectangles: 2        (1*2)
        // 1x2 rectangles: 3        (3*1)
        // 2x2 rectangles: 2        (2*1)
        // 3x2 rectangles: 1        (1*1)
        
        // Given a rectangle measuring L by W, it contains L*W types of rectangles with dimensions ranging from (1,1) to (L,W).
        // The number of (a,b) rectangles the large rectangle contains is (L - a + 1) * (W - b + 1).
        
        int area = 0;
        int diff = 1000;
        
        for (int length = 1; length < 100; length++){
            for (int width = 1; width <= length; width++){
                int rectangles = 0;
                
                for (int i = 1; i <= length; i++){
                    for (int j = 1; j <= width; j++){
                        rectangles += (length - i + 1) * (width - j + 1);
                    }
                }
                
                if (Math.abs(2000000 - rectangles) < diff){
                    diff = Math.abs(2000000 - rectangles);
                    area = length * width;
                }
            }
        }

        System.out.println("Area of grid with number of rectangles closest to 2 million: " + area); // 2772
        // A rectangle measuring 77 by 36 has an area of 2772 and contains 1,999,998 rectangles.
    }
}