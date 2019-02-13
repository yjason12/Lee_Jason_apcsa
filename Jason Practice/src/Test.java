

public class Test{
	
	private int num1, num2;
	
	public Test() {
		num1 =0;
		num2=0;
	}
	
	
	public void setNums(int a, int b) {
		num1 = a;
		num2 = b;
		mathTest();
	}
	
	public int mathTest() {
		return num1 - num2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}