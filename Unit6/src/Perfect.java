//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors

  	public Perfect() {
	   setNumber(0);
   	}
  	
  	public Perfect(int a ) {
  		setNumber(a);
  	}
  	
	public void setNumber(int a) {
		number = a;
	}

	public boolean isPerfect()
	{
		int factor = 1;
		int total =0;
		while (factor < number ) {
			if (number % factor == 0) {
				total = total + factor;
				
			}
			factor = factor +1;
		}
		if (total == number) {
			return true;
		}
		return false;
	}

	public String toString() {
		if(isPerfect() == true) {
			return number + " is a perfect number";
		}
		return number + " is not a perfect number";
	}
	
}