import java.util.*;

public class _84_MonopolyOdds{
    
    static String[] squares = {
        "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
        "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
        "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
        "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
    }; // 40 squares
    
    public static String game(){
        int p1 = 0;
        int p2 = 0;
        int[] occs = new int[squares.length];
        
        // Keep track of consecutive double rolls for each player.
        
        // Community Chest cards have a 1/8 chance to move the player to another square.
        
        // Chance cards have a 10/16 chance to move the player to another square.
        // One of these cards sends the player back 3 squares from their current square.
        
        // No distinction is made between Just Visiting and In Jail.
        // Players in jail are assumed to pay to get out on their next turn.
        
        return getModalString(occs);
    }
    
    public static String getModalString(int[] occs){
        String modalStr = "";
        
        return modalStr;
    }
    
    public static void main(String[] args){
        
        Random rand = new Random();
        
        String modalStr = "";
        
        // Approach: Simulate a large number of games for enough turns
        // and return the most common modal string generated from this sample set.
        // During each game, count how many times a square is landed on.
        // Roll dice for each player and keep track of how many consecutive doubles they have rolled.

        System.out.println("Six-digit modal string when using two 4-sided dice: " + modalStr); // 
    }
}