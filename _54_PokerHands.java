import java.util.*;
import java.io.File;

public class _54_PokerHands{
    
    static class Hand{
        
        static HashMap<Character, Integer> rankMap;
        static HashMap<Character, Integer> suitMap;
        static Hand.CardValue[] values = CardValue.values();
        
        static {
            rankMap = new HashMap<Character, Integer>();
            char[] ranks = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
            for (int i = 0; i < ranks.length; i++){
                rankMap.put(ranks[i], i);
            }
            
            suitMap = new HashMap<Character, Integer>();
            char[] suits = new char[]{'C', 'D', 'H', 'S'};
            for (int i = 0; i < suits.length; i++){
                suitMap.put(suits[i], i);
            }
        }
        
        HashMap<Integer, ArrayList<Hand.CardValue>> countOccs;
        int[] cardRanks = new int[13];
        int[] cardSuits = new int[4];
        Hand.Ranking handRank;
        Hand.CardValue kicker; // used to compare hands of the same rank
        
        public enum CardValue{
            Deuce,
            Trey,
            Four,
            Five,
            Six,
            Seven,
            Eight,
            Nine,
            Ten,
            Jack,
            Queen,
            King,
            Ace
        }
        
        public enum Ranking{
            HighCard,
            OnePair,
            TwoPair,
            ThreeOfAKind,
            Straight,
            Flush,
            FullHouse,
            FourOfAKind,
            StraightFlush,
            RoyalFlush
        }
        
        public Hand(String[] cards){
            for (String card : cards){
                cardRanks[rankMap.get(card.charAt(0))]++;
                cardSuits[suitMap.get(card.charAt(1))]++;
            }
            
            countOccs = new HashMap<Integer, ArrayList<Hand.CardValue>>();
            
            for (int i = 0; i < cardRanks.length; i++){
                if (cardRanks[i] != 0){
                    if (!countOccs.containsKey(cardRanks[i])){
                        countOccs.put(cardRanks[i], new ArrayList<Hand.CardValue>());
                    }
                    countOccs.get(cardRanks[i]).add(values[i]);
                }
            }
            // System.out.println(countOccs);
            // System.out.println(Arrays.toString(cardRanks));
            // System.out.println(Arrays.toString(cardSuits));
            
            handRank = this.evaluate();
            // System.out.println(handRank);
        }
        
        public boolean isStraight(){ // five consecutive values
            int count = 0;
            int maxCount = 0;

            for (int rank : cardRanks){
                if (rank > 1) return false;
                if (rank == 1){
                    count++;
                    maxCount = count > maxCount ? count : maxCount;
                    if (maxCount == 5) return true;
                }
                else{
                    count = 0;
                }
            }
            
            // special case - five-high straight
            boolean lowestFour = true;
            for (int i = 0; i <= 3; i++){
                if (cardRanks[i] != 1){
                    lowestFour = false;
                    break;
                }
            }
            
            return lowestFour && (cardRanks[12] == 1);
        }
        
        public boolean isFlush(){ // all 5 cards of same suit
            for (int suit : cardSuits){
                if (suit == 5) return true;
            }
            return false;
        }
        
        public boolean isFourOfAKind(){ // 4 of one value
            return countOccs.containsKey(4);
        }
        
        public boolean isFullHouse(){ // 3 of one value and 2 of another
            return countOccs.containsKey(3) && countOccs.containsKey(2);
        }
        
        public boolean isThreeOfAKind(){ // 3 of one value
            return countOccs.containsKey(3);
        }
        
        public boolean isTwoPair(){ // 2 of two values
            return countOccs.containsKey(2) && countOccs.get(2).size() == 2;
        }
        
        public boolean isOnePair(){ // 2 of one value
            return countOccs.containsKey(2);
        }
        
        public Hand.Ranking evaluate(){
            if (isStraight() && isFlush()){
                if (cardRanks[8] == 1 && cardRanks[12] == 1) return Hand.Ranking.RoyalFlush;
                return Hand.Ranking.StraightFlush;
            }
            
            if (isFourOfAKind()){
                kicker = countOccs.get(4).get(0);
                return Hand.Ranking.FourOfAKind;
            }
            
            if (isFullHouse()){
                kicker = countOccs.get(3).get(0);
                return Hand.Ranking.FullHouse;
            }
            
            if (isFlush()){
                return Hand.Ranking.Flush;
            }
            
            if (isStraight()){
                return Hand.Ranking.Straight;
            }
            
            if (isThreeOfAKind()){
                kicker = countOccs.get(3).get(0);
                return Hand.Ranking.ThreeOfAKind;
            }
            
            if (isTwoPair()){
                kicker = countOccs.get(2).get(1);
                return Hand.Ranking.TwoPair;
            }
            
            if (isOnePair()){
                kicker = countOccs.get(2).get(0);
                return Hand.Ranking.OnePair;
            }
            
            return Hand.Ranking.HighCard;
        }
        
        public int compareTo(Hand other){
            if (this.handRank != other.handRank){
                return this.handRank.compareTo(other.handRank);
            }
            else{ // same ranking for both hands
                if (this.handRank == Hand.Ranking.OnePair || this.handRank == Hand.Ranking.TwoPair
                || this.handRank == Hand.Ranking.ThreeOfAKind || this.handRank == Hand.Ranking.FullHouse
                || this.handRank == Hand.Ranking.FourOfAKind){
                    return this.kicker.compareTo(other.kicker);
                }
                
                // find highest value for straight, flush, high card
                for (int i = cardRanks.length - 1; i >= 0; i--){
                    // System.out.println(values[i] + " " + this.cardRanks[i] + " " + other.cardRanks[i]);
                    if (this.cardRanks[i] > other.cardRanks[i]){
                        this.kicker = values[i];
                        return 1;
                    }
                    else if (this.cardRanks[i] < other.cardRanks[i]){
                        other.kicker = values[i];
                        return -1;
                    }
                }
            }
            return 0; // hands are identical, tie
        }
        
    }
    
    public static void main(String[] args){
        
        int wins = 0;
        File inputFile = new File("0054_poker.txt");
        
        try{
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNext()){
                String[] cards = sc.nextLine().split(" ");
                
                Hand h1 = new Hand(Arrays.copyOfRange(cards, 0, 5));
                Hand h2 = new Hand(Arrays.copyOfRange(cards, 5, 10));
                String[] c1 = Arrays.copyOfRange(cards, 0, 5);
                String[] c2 = Arrays.copyOfRange(cards, 5, 10);
                Arrays.sort(c1);
                Arrays.sort(c2);
                
                if (h1.handRank == h2.handRank){
                    System.out.print(Arrays.toString(c1) + " " + Arrays.toString(c2) + "\t");
                }
                if (h1.compareTo(h2) > 0){
                    System.out.print(h1.handRank + " " + h2.handRank + " Win " + h1.kicker + " " + h2.kicker);
                    wins++;
                }
                else if (h1.compareTo(h2) == 0){
                    System.out.print(Arrays.toString(c1) + " " + Arrays.toString(c2));
                    System.out.print(h1.handRank + " " + h2.handRank + " Tie " + h1.kicker + " " + h2.kicker);
                }
                else if (h1.compareTo(h2) < 0){
                    System.out.print(h1.handRank + " " + h2.handRank + " Lose " + h1.kicker + " " + h2.kicker);
                }
                System.out.println();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        System.out.println("\nNumber of hands Player 1 wins: " + wins); // 376
    }
}