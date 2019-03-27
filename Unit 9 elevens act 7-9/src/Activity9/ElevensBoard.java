package Activity9;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) 
	{
		/*if (selectedCards.size() == 2)
		{
			return containsPairSum11(selectedCards);
		}
		else if (selectedCards.size() == 3)
		{
			return containsJQK(selectedCards);
		}
		return false;*/
		
		
		if (selectedCards.size()==2)
			return containsPairSum11(selectedCards);
		else if (selectedCards.size()==3)
			return containsJQK(selectedCards);
		return false;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public boolean anotherPlayIsPossible() 
	{
		List<Integer> index = cardIndexes();
		if (containsPairSum11(index) || containsJQK(index))
		{
			return true;
		}
		return false;
	}

	private boolean containsPairSum11(List<Integer> selectedCards)
	{
		if (selectedCards.size() < 2)
		{
			return false;
		}
		
		for (int i = 0; i < selectedCards.size(); i++)
		{
			for (int j = i+1; j < selectedCards.size(); j++)
			{
				if (((cardAt(selectedCards.get(i)).pointValue()) + cardAt(selectedCards.get(j)).pointValue()) == 11)
				{
					return true;
				}
			}

		}
		return false;
	}

	private boolean containsJQK(List<Integer> selectedCards)
	{
		if (selectedCards.size() < 3)
		{
			return false;
		}
		
		boolean jack,queen,king;
		jack=queen=king=false;
		
		for (int i = 0; i < selectedCards.size(); i++)
		{
			if (cardAt(selectedCards.get(i)).rank() == "jack")
			{
				jack = true;
			}
			
			if (cardAt(selectedCards.get(i)).rank() == "queen")
			{
				queen = true;
			}
			
			if (cardAt(selectedCards.get(i)).rank() == "king")
			{
				king = true;
			}
		}
		
		return king && jack && queen;
	}
}