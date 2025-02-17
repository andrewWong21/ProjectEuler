using System;

public class _86_CuboidRoute{
	public static int Euler86(){
		int solutions = 0;
		for (int a = 1; ; a++){
			for (int b = 1; b <= a; b++){
				for (int c = 1; c <= b; c++){
					double len = Math.Sqrt(a * a + (b + c) * (b + c));
					if (len == (int) len){
						if (++solutions > 1_000_000) return a;
					}
				}
			}
		}
	}
	
	public static void Main(){
		Console.WriteLine(Euler86());
	}
}
