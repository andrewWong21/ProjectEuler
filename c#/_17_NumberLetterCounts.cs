using System;

public class _17_NumberLetterCounts{
	public static int Euler17(){
		int res = 0;
		res += "onetwothreefourfivesixseveneightnine".Length * 190;
		res += "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".Length * 10;
		res += "twentythirtyfortyfiftysixtyseventyeightyninety".Length * 100;
		res += "hundred".Length * 900;
		res += "and".Length * 891;
		res += "onethousand".Length;
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler17());
	}
}
