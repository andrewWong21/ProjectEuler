import java.util.*;

public class _84_MonopolyOdds{
    
    static String[] squares = {
        "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
        "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
        "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
        "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
    }; // 40 squares
    static List<Integer> communityChestSquares = new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 17, 33}));
    static List<Integer> chanceSquares = new ArrayList<Integer>(Arrays.asList(new Integer[]{7, 22, 36}));
    
    private static String getModalString(int[] visited){
        // get top 3 most visited squares during game
        // square 30 is Go to Jail, visited[30] is never incremented during game simulation
        // as current square is set to 10 (jail) if current square becomes 30 after rolling
        int first = 30, second = 30, third = 30;
        for (int i = 0; i < visited.length; i++){
            if (visited[i] > visited[first]){ // new most visited square
                third = second;
                second = first;
                first = i;
            }
            else if (visited[i] > visited[second]){ // new second most visited square
                third = second;
                second = i;
            }
            else if (visited[i] > visited[third]){ // new third most visited square
                third = i;
            }
        }
        // concatenate square numberings, left-padded with 0 if needed to get 2-digit number
        return String.format("%02d", first) + String.format("%02d", second) + String.format("%02d", third);
    }
    
    private static String mostFrequentString(Map<String, Integer> map){
        // get string with maximum value (frequency) in map
        String res = "";
        int count = 0;
        for (String modalStr : map.keySet()){
            if (map.get(modalStr) > count){
                res = modalStr;
                count = map.get(modalStr);
            }
        }
        return res;
    }
    
    private static int nextSquare(int curr, int[] squares){
        // move from curr to next position in squares
        for (int sq : squares){
            if (sq > curr){
                return sq;
            }
        }
        return squares[0];
    }
    
    private static String simulate(int sides, int turns){
        Random rand = new Random();
        
        // -1 indicates no change in position after drawing card.
        // Values greater than -1 are valid positions to move to.
        // Values less than -1 are cases where destination depends on current square.
        List<Integer> communityChestCards = Arrays.asList(0, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        List<Integer> chanceCards = Arrays.asList(0, 10, 11, 24, 39, 5, -5, -5, -12, -3, -1, -1, -1, -1, -1, -1);
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
        Deque<Integer> communityChestQueue = new ArrayDeque<Integer>(communityChestCards);
        Deque<Integer> chanceQueue = new ArrayDeque<Integer>(chanceCards);
        
        // Keep track of current position and consecutive double rolls.
        int curr = 0, doubles = 0;
        // Keep track of number of times each square was visited during the game.
        int[] visited = new int[squares.length];
        
        for (int i = 0; i < turns; i++){
            int roll1 = rand.nextInt(sides) + 1;
            int roll2 = rand.nextInt(sides) + 1;
            if (roll1 == roll2){
                doubles++;
                if (doubles == 3){
                    // Proceed directly to jail if three consecutive doubles are rolled.
                    curr = 10;
                    doubles = 0;
                    visited[10]++;
                    continue;
                }
            }
            else{ // reset doubles streak
                doubles = 0;
            }
            
            curr = (curr + roll1 + roll2) % squares.length;
            
            if (curr == 30){ // Go to Jail
                curr = 10;
            }
            else if (communityChestSquares.contains(curr)){
                int card = communityChestQueue.pop();
                if (card > -1){
                    curr = card;
                }
                communityChestQueue.add(card);
            }
            else if (chanceSquares.contains(curr)){
                int card = chanceQueue.pop();
                if (card > -1){
                    curr = card;
                }
                else if (card == -3){ // move back 3 spaces
                    curr = (curr - 3) % squares.length;
                }
                else if (card == -5){ // move to next railway
                    curr = nextSquare(curr, new int[]{5, 15, 25, 35});
                }
                else if (card == -12){ // move to next utility
                    curr = nextSquare(curr, new int[]{12, 28});
                }
                chanceQueue.add(card);
            }
            visited[curr]++;
        }
        return getModalString(visited);
    }
    
    public static void main(String[] args){
        // Approach: Simulate a large number of games for enough turns
        // and return the most common modal string generated from this sample set.
        // During each game, count how many times a square is landed on.
        
        // One test is composed of a number of games each lasting for some large number of turns.
        int tests = 10, games = 200, turns = 5000;
        // Store frequencies of most frequent modal strings obtained from each test.
        Map<String, Integer> results = new HashMap<>();
        for (int i = 0; i < tests; i++){
            // Store frequencies of modal strings obtained from each game.
            Map<String, Integer> modalStrings = new HashMap<>();
            for (int j = 0; j < games; j++){
                String modalStr = simulate(4, turns);
                modalStrings.put(modalStr, modalStrings.getOrDefault(modalStr, 0) + 1);
            }
            // Identify most frequent modal string obtained during test.
            String testModal = mostFrequentString(modalStrings);
            results.put(testModal, results.getOrDefault(testModal, 0) + 1);
        }
        // Aggregate results of tests and return majority result.
        System.out.println("Six-digit modal string when using two 4-sided dice: " + mostFrequentString(results)); // 101524
    }
}
