//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Input
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		int intOne, intTwo;
		double doubleOne, doubleTwo;
		float floatOne, floatTwo;
		short shortOne, shortTwo;


		System.out.print("Enter an integer :: ");
		intOne = keyboard.nextInt();


		System.out.print("Enter an integer :: ");
		intTwo = keyboard.nextInt();
		
		System.out.print("Enter a double :: ");
		doubleOne = keyboard.nextDouble();
		
		System.out.print("Enter a double :: ");
		doubleTwo =keyboard.nextDouble();
		
		System.out.print("Enter a float :: ");
		floatOne = keyboard.nextFloat();
		
		System.out.println("enter a float :: ");
		floatTwo = keyboard.nextFloat();
		
		System.out.println("enter a short :: ");
		shortOne = keyboard.nextShort();
		
		System.out.println("Enter a short :: ");
		shortTwo = keyboard.nextShort();
		
		
		

		//add in input for all variables


		System.out.println();
		System.out.println("integer one = " + intOne );
		System.out.println("integer two = " + intTwo );
		
		//add in output for all variables
		
		
		System.out.println("Double one = " + doubleOne );
		System.out.println("Double two = " + doubleTwo );
		System.out.println("Float one = " + floatOne);
		System.out.println("Float two = " + floatTwo);
		System.out.println("short One = " + shortOne);
		System.out.println("Short two = " + shortTwo);
	}
}