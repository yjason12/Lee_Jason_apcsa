public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		
		
		
		String [] suits =  {"Hearts","Clubs", "Dimaonds", "Spades "};
		String [] ranks =  { "A","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		int [ ] values = {1,2,3,4,5,6,7,8,9,10,0,0,0};
		
		
		Deck deck = new Deck ( ranks,suits,values);
		System.out.println("Deck has [" + deck.size() + "] cards");
		
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		System.out.println("I just got dealt a " + deck.deal());
		
		System.out.println("Deck has [" + deck.size() + "] cards");
		System.out.println(deck);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}