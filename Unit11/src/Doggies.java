import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		//make sure spot is in bounds
		pups[spot] = new Dog(age, name);
		
	}

	public String getNameOfOldest()
	{
		int age = pups[0].getAge();
		String name = pups[0].getName();
		for(Dog i : pups) {
			if(age<i.getAge()) {
				name = i.getName();
				age = i.getAge();
			}
		}
		return name;
	}

	public String getNameOfYoungest()
	{
		int age = pups[0].getAge();
		String name = pups[0].getName();
		for(Dog i: pups) {
			if(age>i.getAge()) {
				name = i.getName();
				age = i.getAge();
			}
		}
		return name;
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}