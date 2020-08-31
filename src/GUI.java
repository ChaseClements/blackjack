import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame
{
	// Data fields
	private JButton Hit, Stand; 									// Buttons user presses
	private ArrayList<ImageIcon> cards = new ArrayList<>(); 		// Holds pictures of cards
	private Backend deal = new Backend(); 							// Used to keep scores and deal cards
	private JLabel C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22; // Cards seen on screen
	
	public GUI()
	{
		// Set the title, size, location of the window
		setTitle("BlackJack");
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Call methods to create the deck and the panel
		createDeck();
		createPanel();
		
		// Makes everything visible
		setVisible(true);
	}
	
	private void createDeck()
	{
		try 
		{
			// Add aces to list
			cards.add(new ImageIcon("src\\Cards\\AceOfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\AceOfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\AceOfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\AceOfDiamonds.png"));
			
			// Add 2s to list
			cards.add(new ImageIcon("src\\Cards\\2OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\2OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\2OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\2OfDiamonds.png"));
			
			// Add 3s to list
			cards.add(new ImageIcon("src\\Cards\\3OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\3OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\3OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\3OfDiamonds.png"));
			
			// Add 4s to list
			cards.add(new ImageIcon("src\\Cards\\4OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\4OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\4OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\4OfDiamonds.png"));
			
			// Add 5s to list
			cards.add(new ImageIcon("src\\Cards\\5OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\5OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\5OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\5OfDiamonds.png"));
			
			// Add 6s to list
			cards.add(new ImageIcon("src\\Cards\\6OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\6OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\6OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\6OfDiamonds.png"));
			
			// Add 7s to list
			cards.add(new ImageIcon("src\\Cards\\7OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\7OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\7OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\7OfDiamonds.png"));
			
			// Add 8s to list
			cards.add(new ImageIcon("src\\Cards\\8OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\8OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\8OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\8OfDiamonds.png"));
			
			// Add 9s to list
			cards.add(new ImageIcon("src\\Cards\\9OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\9OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\9OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\9OfDiamonds.png"));
			
			// Add 10s to list
			cards.add(new ImageIcon("src\\Cards\\10OfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\10OfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\10OfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\10OfDiamonds.png"));
			
			// Add jacks to list
			cards.add(new ImageIcon("src\\Cards\\JackOfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\JackOfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\JackOfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\JackOfDiamonds.png"));
			
			// Add queens to list
			cards.add(new ImageIcon("src\\Cards\\QueenOfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\QueenOfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\QueenOfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\QueenOfDiamonds.png"));
			
			// Add kings to list
			cards.add(new ImageIcon("src\\Cards\\KingOfClubs.png"));
			cards.add(new ImageIcon("src\\Cards\\KingOfHearts.png"));
			cards.add(new ImageIcon("src\\Cards\\KingOfSpades.png"));
			cards.add(new ImageIcon("src\\Cards\\KingOfDiamonds.png"));
	      
	    }
	    catch (Exception ex)
		{
	    	System.out.println("Oop image is missing");
		}
	}
	
	private void createPanel()
	{
		// Create labels
		C1 = new JLabel();
		C2 = new JLabel();
		C3 = new JLabel();
		C4 = new JLabel();
		C5 = new JLabel();
		C6 = new JLabel();
		C7 = new JLabel();
		C8 = new JLabel();
		C9 = new JLabel();
		C10 = new JLabel();
		C11 = new JLabel();
		C12 = new JLabel();
		C13 = new JLabel();
		C14 = new JLabel();
		C15 = new JLabel();
		C16 = new JLabel();
		C17 = new JLabel();
		C18 = new JLabel();
		C19 = new JLabel();
		C20 = new JLabel();
		C21 = new JLabel();
		C22 = new JLabel();
		
		// Deal initial cards
		dealInitial();
		
		// Create buttons and action listener
		ButtonPressed listener = new ButtonPressed();
		Hit = new JButton("Hit");
		Hit.addActionListener(listener);
		Stand = new JButton("Stand");
		Stand.addActionListener(listener);
		
		// Holds dealer's cards
		JPanel dealerPanel = new JPanel();
		dealerPanel.add(C3);
		dealerPanel.add(C13);
		dealerPanel.add(C14);
		dealerPanel.add(C15);
		dealerPanel.add(C16);
		dealerPanel.add(C17);
		dealerPanel.add(C18);
		dealerPanel.add(C19);
		dealerPanel.add(C20);
		dealerPanel.add(C21);
		dealerPanel.add(C22);

		// Panel to hold the cards
		JPanel cardsPanel = new JPanel();
		cardsPanel.setLayout(new GridLayout(2,1));
		
		// Holds players cards
		JPanel playerPanel = new JPanel();
		playerPanel.add(C1);
		playerPanel.add(C2);
		playerPanel.add(C4);
		playerPanel.add(C5);
		playerPanel.add(C6);
		playerPanel.add(C7);
		playerPanel.add(C8);
		playerPanel.add(C9);
		playerPanel.add(C10);
		playerPanel.add(C11);
		playerPanel.add(C12);
		
		// Panel holds buttons at bottom of screen
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Hit);
		buttonPanel.add(Stand);
		
		// Panel to hold other panels
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// Add dealer and player cards to cards panel
		cardsPanel.add(dealerPanel);
		cardsPanel.add(playerPanel);
		
		panel.add(cardsPanel);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		// Add panel to the frame
		add(panel);
	}
	
	private void dealInitial()
	{
		// Give player first two cards
		int index = deal.getCard(true);
		C1.setIcon(cards.get(index));
		cards.remove(index);
		index = deal.getCard(true);
		C2.setIcon(cards.get(index));
		cards.remove(index);
		
		// Give dealer first card
		index = deal.getCard(false);
		C3.setIcon(cards.get(index));
		cards.remove(index);
	}
	
	private void getWinner()
	{
		// Create a panel to display whether the user won, and a button
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		// Create a text field to display more details about the conclusion of the hand
		JTextField winner = new JTextField();
		winner.setEditable(false);
		
		// Decision structure that determines winner
		if (deal.getPlayerPoints() > 21 && deal.getDealerPoints() > 21)
		{
			winner.setText("Both you and the dealer went bust, the dealer wins!");
			panel.add(new JLabel(new ImageIcon("src\\Cards\\YouLose.png")));
		}
		else if (deal.getDealerPoints() > 21 && deal.getPlayerPoints() <= 21)
		{
			winner.setText("The dealer went bust, you win!");
			panel.add(new JLabel(new ImageIcon("src\\Cards\\YouWin.png")));
		}
		else if (deal.getDealerPoints() <= 21 && deal.getPlayerPoints() > 21)
		{
			winner.setText("You went bust, the dealer wins!");
			panel.add(new JLabel(new ImageIcon("src\\Cards\\YouLose.png")));
		}
		else if (deal.getDealerPoints() <= 21 && deal.getPlayerPoints() <= 21 && deal.getDealerPoints() < deal.getPlayerPoints())
		{
			winner.setText("You are closer to 21! You win!");
			panel.add(new JLabel(new ImageIcon("src\\Cards\\YouWin.png")));
		}
		else if (deal.getDealerPoints() <= 21 && deal.getPlayerPoints() <= 21 && deal.getDealerPoints() > deal.getPlayerPoints())
		{
			winner.setText("The dealer is closer to 21! The dealer wins!");
			panel.add(new JLabel(new ImageIcon("src\\Cards\\YouLose.png")));
		}
		else if (deal.getDealerPoints() == deal.getPlayerPoints() && deal.getDealerPoints() <= 21)
		{
			winner.setText("It is a tie!");
		}
		
		add(winner, BorderLayout.SOUTH);
		add(panel, BorderLayout.WEST);
	}
	
	private class ButtonPressed implements ActionListener 
	{
		// Data fields
		private int cardCounter = 3;									// Amount of cards
		private boolean playerFinished = false, dealerFinished = false;
		
		public void actionPerformed(ActionEvent e)
		{
			// Give player more cards if the hit button was pressed, the player has less than 21 points,
			// and the dealer has not drawn more cards yet
			if (e.getSource() == Hit && deal.getPlayerPoints() < 21 && playerFinished != true)
			{
				// Increase counter
				cardCounter++;
				
				// Get another card using code from back end file
				int index = deal.getCard(true);
				if (cardCounter == 4)
					C4.setIcon(cards.get(index));
				else if (cardCounter == 5)
					C5.setIcon(cards.get(index));
				else if (cardCounter == 6)
					C6.setIcon(cards.get(index));
				else if (cardCounter == 7)
					C7.setIcon(cards.get(index));
				else if (cardCounter == 8)
					C8.setIcon(cards.get(index));
				else if (cardCounter == 9)
					C9.setIcon(cards.get(index));
				else if (cardCounter == 10)
					C10.setIcon(cards.get(index));
				else if (cardCounter == 11)
					C11.setIcon(cards.get(index));
				else
					C12.setIcon(cards.get(index));
					
				cards.remove(index);
			}
			else if ((e.getSource() == Stand || deal.getPlayerPoints() >= 21) && dealerFinished != true)
			{
				// Disable the ability to press the "hit" and "stand" buttons
				playerFinished = true;
				dealerFinished = true;
				
				// Reset the card counter to 1 (For dealer)
				cardCounter = 1;
				
				// Give dealer the cards needed
				while (deal.getDealerPoints() < 17)
				{
					cardCounter++;
					
					int index = deal.getCard(false);
					
					if (cardCounter == 2)
						C13.setIcon(cards.get(index));
					else if (cardCounter == 3)
						C14.setIcon(cards.get(index));
					else if (cardCounter == 4)
						C15.setIcon(cards.get(index));
					else if (cardCounter == 5)
						C16.setIcon(cards.get(index));
					else if (cardCounter == 6)
						C17.setIcon(cards.get(index));
					else if (cardCounter == 7)
						C18.setIcon(cards.get(index));
					else if (cardCounter == 8)
						C19.setIcon(cards.get(index));
					else if (cardCounter == 9)
						C20.setIcon(cards.get(index));
					else if (cardCounter == 10)
						C21.setIcon(cards.get(index));
					else if (cardCounter == 11)
						C22.setIcon(cards.get(index));
					
					cards.remove(index);
				}
				
				getWinner();
			}
			
			// End the game if the player reaches 21 or more
			if (deal.getPlayerPoints() >= 21)
			{
				// Disable the ability to press the "hit" and "stand" buttons
				playerFinished = true;
				dealerFinished = true;
				
				// Reset the card counter to 1 (For dealer)
				cardCounter = 1;
				
				// Give dealer the cards needed
				while (deal.getDealerPoints() < 17)
				{
					cardCounter++;
					
					int index = deal.getCard(false);
					
					if (cardCounter == 2)
						C13.setIcon(cards.get(index));
					else if (cardCounter == 3)
						C14.setIcon(cards.get(index));
					else if (cardCounter == 4)
						C15.setIcon(cards.get(index));
					else if (cardCounter == 5)
						C16.setIcon(cards.get(index));
					else if (cardCounter == 6)
						C17.setIcon(cards.get(index));
					else if (cardCounter == 7)
						C18.setIcon(cards.get(index));
					else if (cardCounter == 8)
						C19.setIcon(cards.get(index));
					else if (cardCounter == 9)
						C20.setIcon(cards.get(index));
					else if (cardCounter == 10)
						C21.setIcon(cards.get(index));
					else if (cardCounter == 11)
						C22.setIcon(cards.get(index));
					
					cards.remove(index);
				}
				
				// Calls the getWinner method to display the winner
				getWinner();
			}
		}
	}
}
