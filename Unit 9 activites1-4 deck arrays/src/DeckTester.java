public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] rankOne = {"Jack", "Queen", "King"};
		String[] suitOne = {"Hearts", "Spades", "Diamonds"};
		int[] value1 = {11, 12, 13};
		
		Deck deckOne = new Deck(rankOne, suitOne, value1);
		System.out.println("deckOne size should be 9: " + deckOne.size());
		
		String[] rankTwo = {"Ace", "2", "3"};
		String[] suitTwo = {"Clubs", "Spades", "Hearts"};
		int[] value2 = {1, 2, 3};
		
		Deck deckTwo = new Deck(rankTwo, suitTwo, value2);
		System.out.println("deckTwo should not be empty: " + !deckTwo.isEmpty());
		
		String[] rankThree = {"4", "Jack", "King"};
		String[] suitThree = {"Diamonds", "Clubs", "Spades"};
		int[] value3 = {4, 11, 13};
		
		Deck deckThree = new Deck(rankThree, suitThree, value3);
		System.out.println("deckThree dealt card is " + deckThree.deal());
		System.out.println(deckThree);
		
		String[] rankFour = {"Ace", "Queen", "King"};
		String[] suitFour = {"Clubs", "Diamonds", "Hearts", "Spades"};
		int[] value4 = {1, 12, 13};
		
		Deck deckFour = new Deck(rankFour, suitFour, value4);
		deckFour.shuffle();
		System.out.println(deckFour);
	}
}