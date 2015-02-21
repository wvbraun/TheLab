package code.apps.pace.view;

import charva.awt.BorderLayout;
import charva.awt.Color;
import charva.awt.Container;
import charva.awt.event.ActionEvent;
import charva.awt.event.ActionListener;
import charvax.swing.BoxLayout;
import charvax.swing.JFrame;
import charvax.swing.JLabel;
import charvax.swing.JPanel;

public class LiftPanel extends JFrame implements ActionListener
{

	public LiftPanel()
	{
		setForeground(Color.green);
		setBackground(Color.black);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.add(new JLabel("Use LEFT and RIGHT cursor keys to select a menu."));
        labelPanel.add(new JLabel("Use ENTER to invoke a menu or menu-item."));
        labelPanel.add(new JLabel("(You can also use the " +
                "underlined \"mnemonic key\" to invoke a menu.)"));
        labelPanel.add(new JLabel("Use BACKSPACE or ESC to dismiss a menu."));
        contentPane.add(labelPanel, BorderLayout.SOUTH);
		
        add(contentPane);
		setLocation(0,0);
		setSize(80, 24);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
