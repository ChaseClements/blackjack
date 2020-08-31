import java.util.ArrayList;
import java.util.Random;

public class Backend
{
	// Data fields
	private ArrayList<Integer> cards = new ArrayList<>();
	private int player;
	private int dealer;
	
	public Backend()
	{
		// Creates the deck
		createList();
	}
	
	private void createList()
	{
		// Add aces to list
		cards.add(11);
		cards.add(11);
		cards.add(11);
		cards.add(11);
		
		// Add 2s to list
		cards.add(2);
		cards.add(2);
		cards.add(2);
		cards.add(2);
		
		// Add 3s to list
		cards.add(3);
		cards.add(3);
		cards.add(3);
		cards.add(3);
		
		// Add 4s to list
		cards.add(4);
		cards.add(4);
		cards.add(4);
		cards.add(4);
		
		// Add 5s to list
		cards.add(5);
		cards.add(5);
		cards.add(5);
		cards.add(5);
		
		// Add 6s to list
		cards.add(6);
		cards.add(6);
		cards.add(6);
		cards.add(6);
		
		// Add 7s to list
		cards.add(7);
		cards.add(7);
		cards.add(7);
		cards.add(7);
		
		// Add 8s to list
		cards.add(8);
		cards.add(8);
		cards.add(8);
		cards.add(8);
		
		// Add 9s to list
		cards.add(9);
		cards.add(9);
		cards.add(9);
		cards.add(9);
		
		// Add 10s to list
		cards.add(10);
		cards.add(10);
		cards.add(10);
		cards.add(10);
		
		// Add jacks to list
		cards.add(10);
		cards.add(10);
		cards.add(10);
		cards.add(10);
		
		// Add queens to list
		cards.add(10);
		cards.add(10);
		cards.add(10);
		cards.add(10);
		
		// Add kings to list
		cards.add(10);
		cards.add(10);
		cards.add(10);
		cards.add(10);
	}
	
	public int getCard(boolean playerCard)
	{
		// Generate a random card
		Random rand = new Random();
		int index = rand.nextInt(cards.size());
		
		if (playerCard)
		{
			// If the card drawn was an ace, and would make the player go over 21, make it add only 1
			if (index < 4 && (player + 11 > 21))
			{
				player += 1;
			}
			else
			{
				player += cards.get(index);
			}
		}
		else
		{
			// If the card drawn was an ace, and would make the dealer go over 21, make it add only 1
			if (index < 4 && (dealer + 11 > 21))
			{
				dealer += 1;
			}
			else
			{
				dealer += cards.get(index);
			}
		}
		
		// Remove card from deck
		cards.remove(index);
		
		// Return the index location of the card
		return index;
	}
	
	// Return the amount of points the dealer has
	public int getDealerPoints()
	{
		return dealer;
	}
	
	// Return the amount of points the player has
	public int getPlayerPoints()
	{
		return player;
	}
}