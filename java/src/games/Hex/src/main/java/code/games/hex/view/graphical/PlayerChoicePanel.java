package code.games.hex.view.graphical;


import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import code.games.hex.gameMechanics.GameRunner;

/**
 * Allows user to choose the player type.
 *
 */
@SuppressWarnings("serial")
public class PlayerChoicePanel extends JPanel
{
	private JComboBox<String> playerTypes;
	
	/**
	 * Constructs a panel allowing a user to choose a player among the valid PlayerTypes.
	 *
	 */
	public PlayerChoicePanel()
	{
		playerTypes = new JComboBox<String>();
		
		for (String player : GameRunner.getPlayersList())
		{
			playerTypes.addItem(player);
		}
		
		setupGUI();
	}
	
	/**
	 * Used to abstract the creation of the graphical user interface.
	 * 
	 */
	private void setupGUI()
	{
		Font 					font   	 = new Font("Impact", Font.BOLD, 14);
		JLabel 					label  	 = new JLabel("Type ");
		SpringLayout 			layout 	 = new SpringLayout();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		
		label.setFont(font);
		playerTypes.setFont(font);
		playerTypes.setPreferredSize(new Dimension(225, 30));
		playerTypes.setRenderer(renderer);
		
		renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		add(label);
		add(playerTypes);
		
		setLayout(layout);
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, playerTypes, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerTypes, 20, SpringLayout.EAST, label);
	}
	
	/**
	 * Returns a String representing the selected type of the player.
	 * 
	 * @return String 
	 */
	public String getPlayerType()
	{
		return playerTypes.getSelectedItem().toString();
	}

}
