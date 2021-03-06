package code.util.timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Timer extends JFrame implements Runnable, ActionListener
{
	private Date   date;
	private String time;
	
	private JButton startButton;
	
	public Timer()
	{
		date = new Date(0);
	}
	
	private void createAndShowGui() throws IOException
	{
		JPanel 			 buttonPanel = new JPanel();
		Font  			 font 	     = new Font("Impact", Font.BOLD, 14);
		SimpleDateFormat formatter   = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
						 time        = formatter.format(date);
						 startButton = new JButton("START");

			 
		startButton.setFont(font);
		buttonPanel.add(startButton);
		setBackground(Color.WHITE);
		
		add(buttonPanel);
		setVisible(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawString(time, 10, 10);
	}

	@Override
	public void run() 
	{
		try
		{
			while (true)
			{
				createAndShowGui();
				repaint();
				date.setTime(date.getTime() + 1000);
				Thread.sleep(1000);
			}
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Thread t = new Thread(this);
		t.start();
	}
}
 	 	