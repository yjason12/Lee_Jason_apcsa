



class TestRunner{
	
	
	public static void main(String[]args) {
		String bill = "bob";
		if (bill.substring(0,1) == "b") {
			System.out.println("yes");
		}
		
		String str = "notString";
		
		if(str.length() >= 3 && str.substring(0,3).contentEquals("not"))
		{
			System.out.println("i was right");
		}
		System.out.println("nat is right");

		
	}
}