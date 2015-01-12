package code.games.hex.view.graphical;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

/**
 * Allows the user to choose a size.
 *
 */
@SuppressWarnings("serial")
public class BoardSetupPanel extends JPanel
{
	public static final int DEFAULT_BOARD_SIZE = 7; 	
	public static final int MAX_SUPPORTED_BOARD_SIZE = 99;
	public static final int MIN_SUPPORTED_BOARD_SIZE = 1;
	
	private JSpinner spinner;
	
	/**
	 * Creates a panel allowing a user to choose a board size between 
	 * MIN_SUPPORTED_BOARD_SIZE and MAX_SUPPORTED_BOARD_SIZE, defaulting
	 *  to DEFAULT_BOARD_SIZE. It should be made clear to the user what value 
	 *  is being chosen and what it represents.
	 */
	public BoardSetupPanel()
	{
		spinner = new JSpinner(new SpinnerNumberModel(DEFAULT_BOARD_SIZE, MIN_SUPPORTED_BOARD_SIZE, MAX_SUPPORTED_BOARD_SIZE, 1));
		setupGUI();
	}
	
	/**
	 * Used to abstract the creation of the graphical user interface.
	 * 
	 */
	private void setupGUI()
	{
		Font font 	 		= new Font("Impact", Font.BOLD, 14);
		JLabel label 		= new JLabel("Size ");
		SpringLayout layout = new SpringLayout();
		
		label.setFont(font);
		spinner.setFont(font);
		spinner.setPreferredSize(new Dimension(50, 30));

		add(label);
		add(spinner);
		
		setLayout(layout);
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, label, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, spinner, 12, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, spinner, 26, SpringLayout.EAST, label);
	}
	
	/**
	 * Returns an integer representing the desired board size
	 * 
	 * @return int 
	 */
	public int getBoardSize()
	{
		return (int) spinner.getValue();
	}

}
