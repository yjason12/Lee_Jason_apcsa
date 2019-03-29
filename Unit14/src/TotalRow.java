//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	//add code here
    	int total = 0;
    	List<Integer> listTotals = new ArrayList<Integer>();
    	for (int i =0;i < m.length; i++) {
    		for(int j = 0; j<m[i].length; j++) {
    			total = m[i][j] + total;
    			
    		}
    		listTotals.add(total);
    		total = 0;
    	}
		return listTotals;
    }
}
