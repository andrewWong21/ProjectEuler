using System;

public class _43_SubstringDivisibility{
	public static long Euler43(){
		// 0-9 pandigital number abcdefghij
		// bcd % 2 = 0, cde % 3 = 0,
		// def % 5 = 0, efg % 7 = 0,
		// fgh % 11 = 0, ghi % 13 = 0,
		// hij % 17 = 0
		
		// def % 5 = 0: f is either 0 or 5
		// 0gh % 11 = 0 requires g = h, number will not be pandigital
		// therefore f must be 5
		
		// 5gh % 11 = 0: check multiples of 11 over 500
		// (506), (517), 528, 539, (550), (561), 572, 583, (594)
		// 06i % 13 = 0: i = 5, not possible since f is already 5
		// 17i % 13 = 0: not possible, 169 and 182 are consecutive multiples of 13
		// 28i % 13 = 0: i = 6
		// 39i % 13 = 0: i = 0
		// 61i % 13 = 0: i = 1, repeated digit
		// 72i % 13 = 0: i = 8
		// 83i % 13 = 0: i = 2
		// 94i % 13 = 0: i = 9, repeated digit
		
		// fghi = 5286, 5390, 5728, (5832), hij % 17 = 0
		// 86j % 17 = 0: j = 7
		// 90j % 17 = 0: j = 1
		// 28j % 17 = 0: j = 9
		// 32j % 17 = 0: j = 2, repeated digit
		
		// fghij = 52867, 53901, 57289, efg % 7 = 0
		// e52 % 7 = 0: e = (2), 9
		// e53 % 7 = 0: e = 5, repeated digit
		// e57 % 7 = 0: e = 3
		
		// efghij = 952867, 357289, bcd % 2 = 0, d % 2 = 0
		// d952867: d = 0, 4
		// d357289: d = 0, 4, 6
		
		// defghij = 0952867, 4952867, 0357289, 4357289, 6357289, cde % 3 = 0
		// c09 % 3 = 0: c = (0), 3, (6), (9)
		// c49 % 3 = 0: c = (2), (5), (8)
		// c03 % 3 = 0: c = (0), (3), 6, (9)
		// c43 % 3 = 0: c = (2), (5), (8)
		// c63 % 3 = 0: c = 0, (3), (6), (9)
		
		// cdefghij: 30952867, 60357289, 06357289
		// remaining digits 1, 4
		long sum = 0;
		string[] prefixes = {"14", "41"};
		string[] suffixes = {"30952867", "60357289", "06357289"};
		foreach (string prefix in prefixes){
			foreach (string suffix in suffixes){
				sum += long.Parse(prefix + suffix);
			}
		}
		return sum;
	}
	
	public static void Main(){
		Console.WriteLine(Euler43());
	}
}
