package code.games.hex.view.graphical;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import code.games.hex.gameMechanics.PlayerColor;

/**
 * Allows a user to choose the player's color.
 *
 */
@SuppressWarnings("serial")
public class PlayerColorPanel extends JPanel
{
	private JComboBox<PlayerColor> playerColors;
	
	/**
	 * Creates a panel allowing a user to choose a player among PlayerColors.
	 * 
	 */
	public PlayerColorPanel()
	{
		playerColors = new JComboBox<PlayerColor>();
		
		for (PlayerColor color : PlayerColor.values())
		{
			if (!color.equals(PlayerColor.BLANK))
			{
				playerColors.addItem(color);
			}
		}
		
		setupGUI();
	}
	
	/**
	 * Used to abstract the creation of the graphical user interface.
	 */
	private void setupGUI()
	{
		Font 					font   	 = new Font("Impact", Font.BOLD, 14);
		JLabel 					label  	 = new JLabel("Color ");
		SpringLayout 			layout 	 = new SpringLayout();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
	
		label.setFont(font);
		playerColors.setFont(font);
		playerColors.setPreferredSize(new Dimension(225, 30));
		playerColors.setRenderer(renderer);
		
		renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		add(label);
		add(playerColors);
		
		setLayout(layout);
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, playerColors, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerColors, 17, SpringLayout.EAST, label);
	}
	
	/**
	 * Returns the selected PlayerColor.
	 * 
	 * @return PlayerColor
	 */
	public PlayerColor getPlayerColorType()
	{
		return (PlayerColor) playerColors.getSelectedItem();
	}

}
