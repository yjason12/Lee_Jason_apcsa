//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		//ask for name and size
		out.println("Enter first monster's name:");
		String name = keyboard.next();
		out.println("Enter first monster's size:");
		int size = keyboard.nextInt();
		//instantiate monster one
		Monster m = new Skeleton(size, name);
		//ask for name and size
		
		//instantiate monster two
		out.println("Enter second monster's name:");
		String name1 = keyboard.next();
		out.println("Enter second monster's size:");
		int size1 = keyboard.nextInt();
		//instantiate monster one
		Monster m1 = new Skeleton(size1, name1);
		//ask for name and size
		if(m.isBigger(m1)) {
			out.println("Monster one is bigger than Monster two.");
		}
		else if(m.isSmaller(m1)) {
			out.println("Monster one is smaller than Monster two.");
		}
		else {
			out.println("Monster one is the same size as Monster two.");
		}
		
		if(m.namesTheSame(m1)) {
			out.println("Monster one has the same name as Monster two.");
		}
		else{
			out.println("Monster one has a different name as Monster two.");
		}
	}
		
}