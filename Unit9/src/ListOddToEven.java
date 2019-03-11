//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int oddIndex=0;
		int evenIndex=0;
		int countOdd=-1;
		int countEven=-1;
		for(int i = 0; i<ray.size(); i++) {
			if (ray.get(i)%2 !=0 && countOdd==-1) {
				countOdd=0;
				oddIndex = i;
			}
		}
		
		for (int i = 0; i<ray.size(); i++) {
			if(ray.get(i)%2 != 1 && countEven==-1) {
				countEven=0;
				evenIndex=i;
			}
		}
		
		if (evenIndex==-1 || oddIndex==-1) {
			return -1;
			
		}
		
		return evenIndex-oddIndex;
		
		
		
		
	}
}