//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Scanner;
public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a string");
		
		
		String inp = keyboard.nextLine();
		StringOddOrEven testCase = new StringOddOrEven(inp);
		
		System.out.println(testCase);
	}
}