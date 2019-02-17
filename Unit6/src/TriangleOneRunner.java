//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		TriangleOne testCase1 = new TriangleOne("hippo");
		testCase1.print();
		
		TriangleOne testCase2 = new TriangleOne("abcd");
		testCase2.print();
		
		TriangleOne testCase3 = new TriangleOne("it");
		testCase3.print();
		
		TriangleOne testCase4 = new TriangleOne("a");
		testCase4.print();
		
		TriangleOne testCase5 = new TriangleOne("chicken");
		testCase5.print();
	}
}