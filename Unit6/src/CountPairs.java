//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class CountPairs
{
	public static int pairCounter( String str )
	{ 
		if (str.length() <=3) {
			return 0;
		}
		int count = 0;
		String firstChar;
		String nextChar;
		
		for(int i = 0; i <str.length()-1; i++) {
			firstChar = str.substring(i,i+1);
			nextChar = str.substring(i+1,i+2);
			if (firstChar.equals(nextChar)){
				count +=1;
			}
		}
		return count;
	}
}