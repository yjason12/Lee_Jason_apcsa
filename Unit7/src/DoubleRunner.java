//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class DoubleRunner
{
	public static void main(String[] args)
	{
		BiggestDouble run = new BiggestDouble(4.5,6.7,7.8,9.0);
		System.out.println(run);
		System.out.println("biggest = " + run.getBiggest() + "\n");

		//add more test cases
			
		BiggestDouble testCase1 = new BiggestDouble(4.5,6.7,7.8,9.0);
		BiggestDouble testCase2 = new BiggestDouble(14.51,6.17,71.8,1.0);
		BiggestDouble testCase3 = new BiggestDouble(41.15,816.7,17.8,19.0);
		BiggestDouble testCase4 = new BiggestDouble(884.5,16.7,7.8,9.0);
		BiggestDouble testCase5 = new BiggestDouble(4.5,-456.7,677.8,9.0);
		BiggestDouble testCase6 = new BiggestDouble(4.5,16.7,-7.8,-9.0);
		System.out.println(testCase1);
		System.out.println(testCase2);
		System.out.println(testCase3);
		System.out.println(testCase4);
		System.out.println(testCase5);
		System.out.println(testCase6);
	}
}