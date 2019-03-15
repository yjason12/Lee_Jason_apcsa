//(c) A+ Computer Science
//www.apluscompsci.com
//Name -


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore(String toysOne)
	{
		toyList = new ArrayList<Toy>();
		loadToys(toysOne);
	}

	public void loadToys( String toysOne )
	{
		Scanner scan = new Scanner(toysOne);
		while(scan.hasNext()){
			String toy = scan.next();
			Toy name = getThatToy(toy);
			if(name == null) {
				Toy newToy = new Toy(toy);
				toyList.add(newToy);
			} else {
				name.setCount(name.getCount()+1);
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for(Toy i : toyList) {
  			if(i.getName().equals(nm))
  			{
  				return i;
  			}
  		}
  		return null;
  	}
  
  	public Toy getMostFrequentToy()
  	{
  		int max = toyList.get(0).getCount();
  		Toy maxx = toyList.get(0);
  		for(Toy i: toyList) {
  			if(i.getCount()>max) {
  				max = i.getCount();
  				maxx = i;
  				
  			}
  		}
		return maxx;
  	}  
  
  	public ArrayList<Toy> sortToysByCount()
  	{
  		ArrayList<Toy> temp = new ArrayList<Toy>();
  		while(toyList.size() > 0) {
  			temp.add(getMostFrequentToy());
  			toyList.remove(getMostFrequentToy());
  		}
  		return temp;
  	}  
	public String toString()
	{
	   return toyList.toString()+"\nmax == " + getMostFrequentToy() + "\nSorted:" + sortToysByCount();
	}
}