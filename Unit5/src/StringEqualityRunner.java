//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		//add test cases
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input two strings");
		
		String inp1 = keyboard.nextLine();
		String inp2 = keyboard.nextLine();
		
		StringEquality testCase = new StringEquality(inp1,inp2);
		
		
		
		System.out.println(testCase);
	}
}