//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;
	private int length;

	public Word( String s )
	{
		word = s;
		length = s.length();
	}

	public int compareTo( Word rhs )
	{	

		int aSize = length;
		int bSize = rhs.word.length();
		
		if (aSize > bSize) {
			return 1;
		}
		else if (bSize > aSize) {
			return -1;
		}
		else {
			return word.compareTo(rhs.word);
		}
	}

	public String toString()
	{
		return word;
	}
}