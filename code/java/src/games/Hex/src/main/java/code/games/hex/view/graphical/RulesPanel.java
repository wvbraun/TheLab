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
 * Allows the user to select the game's rules.
 *
 */
@SuppressWarnings("serial")
public class RulesPanel extends JPanel {
	
	private JComboBox<String> rules;
	
	/**
	 * Creates a panel allowing users to select the game's rule set.
	 * 
	 */
	public RulesPanel()
	{
		rules = new JComboBox<String>();
		
		for (String rule : GameRunner.getRuleSets())
		{
			rules.addItem(rule);
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
		JLabel 					label  	 = new JLabel("Rules ");
		SpringLayout 			layout 	 = new SpringLayout();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		
		label.setFont(font);
		rules.setFont(font);
		rules.setRenderer(renderer);
		rules.setPreferredSize(new Dimension(225, 30));

		renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		add(label);
		add(rules);
	
		setLayout(layout);	
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, label, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, rules, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, rules, 16, SpringLayout.EAST, label);
	}
	
	/**
	 * Returns a String representing the selected rule.
	 * 
	 * @return String
	 */
	public String getRuleType()
	{
		return rules.getSelectedItem().toString();
	}

}
