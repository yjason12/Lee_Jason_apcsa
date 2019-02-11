//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;

	public StringOddOrEven()
	{
		setString("");
	}

	public StringOddOrEven(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

 	public boolean isEven()
 	{
		if (word.length() % 2 == 0) {
			return true;
		}
		return false;
	}

 	public String toString()
 	{
 		if (isEven() == false) {
 			return word + " is odd"; 
 		}
 		return word + " is even";
 		
	}
}