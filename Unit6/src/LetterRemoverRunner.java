//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		//add test cases		
						
		LetterRemover testCase1 = new LetterRemover("I am Sam I am",'a');
		LetterRemover testCase2 = new LetterRemover("sssssssssssssssssssssxssssssssesssss",'s');
		LetterRemover testCase3 = new LetterRemover("qwertyqwertyqwerty",'a');
		LetterRemover testCase4 = new LetterRemover("ababababababa",'b');
		LetterRemover testCase5 = new LetterRemover("abaababababa",'x');
		System.out.println(testCase1);
		System.out.println(testCase2);
		System.out.println(testCase3);
		System.out.println(testCase4);
		System.out.println(testCase5);
		
		
	}
}