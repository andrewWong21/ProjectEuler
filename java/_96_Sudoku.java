import java.util.*;
import java.io.File;

public class _96_Sudoku{
    
    private static int[][] formatBoard(String puzzle){
        int[][] board = new int[9][9];
        for (int i = 0; i < puzzle.length(); i++){
            char c = puzzle.charAt(i);
            if (c != '0'){
                board[i / 9][i % 9] = c - '0';
            }
        }
        return board;
    }
    
    private static int solve(int[][] board){
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            rows.add(new HashSet<Integer>());
            cols.add(new HashSet<Integer>());
            boxes.add(new HashSet<Integer>());
        }
        
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (board[r][c] != 0){
                    rows.get(r).add(board[r][c]);
                    cols.get(c).add(board[r][c]);
                    int b = 3 * (r / 3) + (c / 3);
                    boxes.get(b).add(board[r][c]);
                }
            }
        }
        backtrack(board, rows, cols, boxes);
        return 100 * board[0][0] + 10 * board[0][1] + board[0][2];
    }
    
    private static boolean backtrack(int[][] board, List<Set<Integer>> rows, List<Set<Integer>> cols, List<Set<Integer>> boxes){
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (board[r][c] == 0){
                    int b = 3 * (r / 3) + (c / 3);
                    for (int d = 1; d <= 9; d++){
                        if (!rows.get(r).contains(d) && !cols.get(c).contains(d) &&
                            !boxes.get(b).contains(d)
                        ){
                            board[r][c] = d;
                            rows.get(r).add(board[r][c]);
                            cols.get(c).add(board[r][c]);
                            boxes.get(b).add(board[r][c]);
                            if (backtrack(board, rows, cols, boxes)) return true;
                            
                            board[r][c] = 0;
                            rows.get(r).remove(d);
                            cols.get(c).remove(d);
                            boxes.get(b).remove(d);
                        }
                    }
                    // no valid placement - digit in previous cell is incorrect
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        int res = 0;
        try{
            File file = new File("0096_sudoku.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            
            StringBuilder sb = new StringBuilder();
            List<String> puzzles = new ArrayList<>();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.startsWith("Grid")){
                    puzzles.add(sb.toString());
                    sb.setLength(0);
                }
                else sb.append(line);
            }
            puzzles.add(sb.toString());
            sc.close();
            
            for (String puzzle : puzzles){
                res += solve(formatBoard(puzzle));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Sum of 3-digit numbers in top left corners of solved puzzles: " + res); // 
    }
}
