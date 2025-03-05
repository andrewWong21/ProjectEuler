import java.util.*;

public class _86_CuboidRoute{
    
    public static int getMinM(int minSolutions){
        int count = 0;
        
        for (int a = 1; ; a++){
            for (int b = 1; b <= a; b++){
                for (int c = 1; c <= b; c++){
                    double length = Math.sqrt(a*a + (b+c)*(b+c));
                    if (Math.floor(length) == length) count++;
                    if (count >= minSolutions) return a;
                }
            }
        }
    }
    
    public static void main(String[] args){
        
        // The length of a straight line L drawn between opposite corners
        // on a cuboid measuring a by b by c is equal to sqrt(a^2 + (b+c)^2).
        // This can be visualized by unfolding the cuboid in a way
        // that the aligns the three faces between the corners.
        // If a is the longest side, then L is minimized for that cuboid.
        
        // The shortest straight line distance between opposite corners of a 6 by 5 by 3 cuboid is 10.
        // sqrt(6^2 + (5 + 3)^2) = sqrt(36 + 64) = sqrt(100) = 10
        // sqrt(5^2 + (6 + 3)^2) = sqrt(25 + 81) = sqrt(106)
        // sqrt(3^2 + (6 + 5)^2) = sqrt(9 + 121) = sqrt(130)
        
        int minM = getMinM(1000000);
        
        System.out.println("Least value of M with number of solutions exceeding one million: " + minM); // 1818
    }
}