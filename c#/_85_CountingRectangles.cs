using System;

public class _85_CountingRectangles{
	public static int Euler85(){
		int res = 0, minDiff = 2_000_000;
		for (int gridLength = 1; gridLength <= 100; gridLength++){
			for (int gridWidth = 1; gridWidth <= gridLength; gridWidth++){
				int rectangles = 0;
				for (int len = 1; len <= gridLength; len++){
					for (int wid = 1; wid <= gridWidth; wid++){
						// number of valid rectangles with dimensions len * wid
						// count number of squares that are valid upper-left corners
						rectangles += (gridLength - len + 1) * (gridWidth - wid + 1);
					}
				}
				int diff = Math.Abs(rectangles - 2_000_000);
				if (diff < minDiff){
					minDiff = diff;
					res = gridLength * gridWidth;
				}
			}
		}
		return res;
	}
	
	public static void Main(){
		Console.WriteLine(Euler85());
	}
}
