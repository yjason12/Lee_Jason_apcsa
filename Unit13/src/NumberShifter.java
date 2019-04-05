import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] ray = new int[size];
		int range = 10;
		for(int i = 0; i < size; i++) {
			ray[i] = (int)(range * Math.random());
		}
		shiftEm(ray);
		return ray;
	}
	
	public static void shiftEm(int[] array)
	{
		int cnt = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 7) {
				int temp = array[i];
				array[i] = array[cnt];
				array[cnt] = temp; 
				cnt++;
			}
		}
		
	}
}