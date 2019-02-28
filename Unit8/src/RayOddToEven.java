//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		//int l = ray.length;
	//	for (int i = 0; i < l; i++) {
	//		if (ray[i] % 2 == 1) {
		//		for(int a = 1; a < l; a++) {
	//				if (ray[a] % 2 == 0) {
		//				int num = a- i;
		//				return Math.abs(num);
		//			}
		//		}
	//		}
	//	}
	//	return -1;
		
		
		int firstOdd =0;
		int firstOddInterval = 0;
		int evenNum =0;
		int evenNumInterv = 0;
		for(int i = ray.length-1; i >=0; i--) {
			if(ray[i]%2 == 1|| ray[i]%2 ==-1) {
				firstOdd = ray[i];
				firstOddInterval = i;
			}
		}
		if(firstOdd==0) {
			return -1;
		}
		for(int j = ray.length-1; j>firstOddInterval; j--) {
			if (ray[j]%2==0) {
				evenNum = ray[j];
				evenNumInterv = j;
			}
		}
		if(evenNum==0) {
			return -1;
		}
		return evenNumInterv - firstOddInterval;
	}
}