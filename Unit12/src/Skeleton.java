//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Skeleton implements Monster
{
	String name;
	int size;
	
	public Skeleton(int a, String s) {
		name = s;
		size = a;
	}
	@Override
	public int getHowBig() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public Monster clone ()
	{
		return this;
	}

	@Override
	public boolean isBigger(Monster other) {
		// TODO Auto-generated method stub
		
		return size>other.getHowBig();
	}

	@Override
	public boolean isSmaller(Monster other) {
		// TODO Auto-generated method stub
		return size<other.getHowBig();
	}

	@Override
	public boolean namesTheSame(Monster other) {
		// TODO Auto-generated method stub
		return other.getName().equals(name);
	}
	public String toString() {
		return name + " " + size;
	}
	

	//add code to implement the Monster interface

	//add a toString
}