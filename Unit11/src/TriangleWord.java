//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		int x = 1;
		String letter = word.substring(0,1);
		for(int i = 1; i<=word.length();i++) {
			letter = word.substring(0,i);
			for(int j = 0; j<x ;j++) {
				System.out.print(letter);
			}
			System.out.println();
			x++;
		}
	}
}