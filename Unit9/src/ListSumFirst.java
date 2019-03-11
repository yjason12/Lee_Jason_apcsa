//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -
import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	public static int go(List<Integer> ray)
	{
		if (ray.size()==0)
		{
			return -1;
		}
		int sum=0;
		int checker = ray.get(0);
		for (int num : ray)
		{
			if (num>checker)
			{
				sum+=num;
			}
		}
		if (sum==0)
			return -1;
		return sum;
	}
}