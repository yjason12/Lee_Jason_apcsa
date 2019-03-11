//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public static boolean go(List<Integer> numArray)
	{
		int curr;
		int count=0;
		for(int i = 0; i<numArray.size()-1; i++) {
			curr = numArray.get(i+1);
			if(curr< numArray.get(i)) {
				count++;
			}
		}
		if (count == numArray.size()-1) {
			return true;
		}
		return false;
	}	
}