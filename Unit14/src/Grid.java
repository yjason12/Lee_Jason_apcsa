public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		int range = vals.length;
		for (int outer = 0; outer < rows; outer++) {
			for (int inner = 0; inner < cols; inner++) {
				grid[outer][inner] = vals[(int) (range * Math.random())];
			}
		}
		
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		String max = "";
		for(int i = 0; i < vals.length; i++) {
			if( countVals(max) < countVals(vals[i])) {
				max = vals[i];
			}
		}
		return max + " occurs the most";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int cnt = 0;
		for (int outer = 0; outer < grid.length; outer++) {
			for (int inner = 0; inner < grid[outer].length; inner++) {
				if(grid[outer][inner].equals(val)) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for (int outer = 0; outer < grid.length; outer++) {
			for (int inner = 0; inner < grid[outer].length; inner++) {
				output += grid[outer][inner] + " ";
			}
			output += "\n";
		}
		return output;
	}
}