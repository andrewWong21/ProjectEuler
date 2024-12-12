using System;

public class _19_CountingSundays{
	public static int Euler19(){
		DateTime date = new DateTime(1901, 1, 1);
		int count = 0;
		while (date.Year != 2001){
			if (date.DayOfWeek.Equals(DayOfWeek.Sunday)) count++;
			date = date.AddMonths(1);
		}
		return count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler19());
	}
}
