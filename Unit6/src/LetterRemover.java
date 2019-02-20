//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		setRemover("", 'a');
	}

	//add in second constructor
	
	public LetterRemover(String s, char rem) {
		setRemover(s,rem);
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned="";
		int loc = sentence.indexOf(lookFor);
		
		while (loc != -1) {
		
			sentence = sentence.substring(0,loc) + sentence.substring(loc +1,sentence.length());
			loc = sentence.indexOf(lookFor);
		}
		
		
		return sentence;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + " \n" + removeLetters();
	}
}