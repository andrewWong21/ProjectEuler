using System;
using System.Collections.Generic;

public class _91_RightTrianglesWithIntegerCoordinates{
	public static int Euler91(){
		int size = 50;
		var seen = new HashSet<(int, int, int, int)>();
		for (int px = 0; px <= size; px++){
			for (int py = 0; py <= size; py++){
				if (px == 0 && py == 0) continue;
				
				for (int qx = 0; qx <= size; qx++){
					for (int qy = 0; qy <= size; qy++){
						if (qx == 0 && qy == 0) continue;
						if (px == qx && py == qy) continue;
						if (seen.Contains((qx, qy, px, py))) continue;
						
						int a = px * px + py * py;
						int b = qx * qx + qy * qy;
						int c = (qx - px) * (qx - px) + (qy - py) * (qy - py);
						if (a + b == c || a + c == b || b + c == a){
							seen.Add((px, py, qx, qy));
						}
					}
				}
			}
		}
		return seen.Count;
	}
	
	public static void Main(){
		Console.WriteLine(Euler91());
	}
}
