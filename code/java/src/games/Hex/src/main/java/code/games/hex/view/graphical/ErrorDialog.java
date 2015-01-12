package code.games.hex.view.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Is displayed whenever the user does something they cannot do.
 *
 */
@SuppressWarnings("serial")
public class ErrorDialog extends JDialog
{
	String message;
	
	public ErrorDialog(JFrame parent, String title, String message)
	{
		super(parent, title);
		this.message = message;
		setupGUI();
	}
	
	private void setupGUI()
	{
		Font   font  = new Font("Impact", Font.BOLD, 14);
		JLabel label = new JLabel(message);
		JPanel panel = new JPanel();
		
		label.setFont(font);
		label.setForeground(Color.RED);
		panel.add(label);
		add(panel);
		setLocation(new Point(600, 300));
		setMinimumSize(new Dimension(400, 50));
		setMaximumSize(new Dimension(400, 50));
		setPreferredSize(new Dimension(400, 50));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
