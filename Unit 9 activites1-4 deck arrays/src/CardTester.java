public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		
		Card Spade = new Card("Ace", "Spades", 1);
		
		System.out.println(Spade);
		
		Card Diamonds = new Card("Ace", "Diamonds", 1);
		
		System.out.println(Diamonds);
		
		Card Spade1 = new Card("Ace", "Spades", 2);
		
		System.out.println(Spade1);
	}
}