using System;
using System.Linq;
using System.Collections.Generic;

public class _84_MonopolyOdds{
	static string[] squares = {
        "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
        "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
        "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
        "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
    };
	static List<int> ccSquares = new List<int>{2, 17, 33};
	static List<int> chSquares = new List<int>{7, 22, 36};
	static List<int> railwaySquares = new List<int>{5, 15, 25, 35};
	static List<int> utilitySquares = new List<int>{12, 28};
	static Random random = new Random();
	
	public static string Euler84(){
		Dictionary<string, int> modalTests = new Dictionary<string, int>();
		int trials = 100, games = 100, turns = 1000, sides = 4;
		for (int i = 0; i < trials; i++){
			Dictionary<string, int> modalStrings = new Dictionary<string, int>();
			
			for (int j = 0; j < games; j++){
				string modalStr = Simulate(turns, sides);
				modalStrings[modalStr] = modalStrings.GetValueOrDefault(modalStr, 0) + 1;
			}
			string mostFrequentModal = modalStrings.OrderByDescending(kv => kv.Value).FirstOrDefault().Key;
			modalTests[mostFrequentModal] = modalTests.GetValueOrDefault(mostFrequentModal, 0) + 1;
		}
		return modalTests.OrderByDescending(kv => kv.Value).FirstOrDefault().Key;
	}
	
	public static string GetModalString(Dictionary<int, int> modalStrings){
		string res = "";
		var keys = modalStrings.OrderByDescending(kv => kv.Value).Take(3).Select(kv => kv.Key);
		foreach (int square in keys){
			if (square < 10){
				res += "0";
			}
			res += square;
		}
		return res;
	}
	
	public static string Simulate(int turns, int sides){
		List<int> communityChestCards = new List<int>{0, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        List<int> chanceCards = new List<int>{0, 10, 11, 24, 39, 5, -5, -5, -12, -3, -1, -1, -1, -1, -1, -1};
		Shuffle(communityChestCards);
		Shuffle(chanceCards);
		Queue<int> ccq = new Queue<int>(communityChestCards);
		Queue<int> chq = new Queue<int>(chanceCards);
		
		int curr = 0, doubles = 0;
		Dictionary<int, int> visited = new Dictionary<int, int>();
		for (int i = 0; i < turns; i++){
			int roll1 = random.Next(1, sides + 1);
            int roll2 = random.Next(1, sides + 1);
			if (roll1 == roll2){
				// rolling 3 doubles in a row sends player to Jail
				if (++doubles == 3){
					doubles = 0;
					curr = 10;
					visited[curr] = visited.GetValueOrDefault(curr, 0) + 1;
					continue;
				}
			}
			else doubles = 0;
			
			curr = (curr + roll1 + roll2) % squares.Length;
			if (curr == 30) curr = 10; // landed on Go to Jail, move to Jail
			else if (ccSquares.Contains(curr)){
				int card = ccq.Dequeue();
                if (card > -1){
                    curr = card;
                }
                ccq.Enqueue(card);
			}
			else if (chSquares.Contains(curr)){
				int card = chq.Dequeue();
                if (card > -1){
                    curr = card;
                }
				else if (card == -3){
					curr = (curr - 3) % squares.Length;
				}
				else if (card == -5){
					curr = nextSquare(curr, railwaySquares);
				}
				else if (card == -12){
					curr = nextSquare(curr, utilitySquares);
				}
                chq.Enqueue(card);
			}
			visited[curr] = visited.GetValueOrDefault(curr, 0) + 1;
		}
		return GetModalString(visited);
	}
	
	private static int nextSquare(int curr, List<int> spaces){
		foreach (int space in spaces){
			if (curr < space){
				return space;
			}
		}
		return spaces[0];
	}
	
	private static void Shuffle(List<int> nums){
		// Fisher-Yates shuffle algorithm
		int n = nums.Count;
		for (int i = n - 1; i >= 0; i--) {  
			int k = random.Next(i + 1);
			int val = nums[k];
			nums[k] = nums[i];
			nums[i] = val;
		}  
	}
	
	public static void Main(){
		Console.WriteLine(Euler84());
	}
}
