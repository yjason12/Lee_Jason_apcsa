//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int total = 0;
		for(int val: ray) {
			if (val >ray[ray.length-1]) {
				total += val;
			}
		}
		if(total==0) {
			return -1;
		}
		return total;
	}
}