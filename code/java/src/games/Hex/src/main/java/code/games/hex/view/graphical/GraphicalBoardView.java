package code.games.hex.view.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import code.games.hex.gameMechanics.GameRunner;
import code.games.hex.gameMechanics.PlayerColor;

/**
 * Represents all GUI aspects of the game using a JFrame.
 *
 */
@SuppressWarnings("serial")
public class GraphicalBoardView extends JFrame implements ActionListener, Runnable
{
	private BoardPanel        boardPanel;
	private RulesPanel        rulesPanel;
	private TurnViewer        oneTurnViewer;
	private TurnViewer 		  twoTurnViewer;
	private GameRunner 		  game;
	private BoardSetupPanel   boardSetupPanel;
	private PlayerColorPanel  oneColorPanel, twoColorPanel;
	private PlayerChoicePanel oneChoicePanel, twoChoicePanel;

	private JButton 		  startButton, resetButton;
	
	public GraphicalBoardView()
	{
		setTitle("Hex");
	}
	
	private void prepareGame()
	{
		PlayerColor oneColor = oneColorPanel.getPlayerColorType();
		PlayerColor twoColor = twoColorPanel.getPlayerColorType();
		
		if (oneColor == twoColor)
		{
			ErrorDialog errorPanel = new ErrorDialog(this, "Error", "Players Cannot Have The Same Color");
			errorPanel.setVisible(true);
		}
		else
		{
			game = new GameRunner(
					boardSetupPanel.getBoardSize(), 
					oneChoicePanel.getPlayerType(),
					twoChoicePanel.getPlayerType(), 
					rulesPanel.getRuleType(),
					oneColorPanel.getPlayerColorType(),
					twoColorPanel.getPlayerColorType());
			
			oneTurnViewer.setGame(game);
			oneTurnViewer.setColor(oneColorPanel.getPlayerColorType());
			twoTurnViewer.setGame(game);
			twoTurnViewer.setColor(twoColorPanel.getPlayerColorType());
	
			boardPanel.setOneColor(oneColorPanel.getPlayerColorType());
			boardPanel.setTwoColor(twoColorPanel.getPlayerColorType());
			boardPanel.setBoard(game.getBoard());
			boardPanel.setRadius(boardSetupPanel.getBoardSize());
	
			game.addObserver(boardPanel);
		}
	}
	
	private void resetGame()
	{
		setVisible(false);
		Thread t = new Thread(new GraphicalBoardView());
		t.start();
	}
	
	private void createAndShowGUI() throws IOException
	{
		Font	turnFont		   = new Font("Impact", Font.BOLD, 18);
		Font 	buttonFont 		   = new Font("Impact", Font.BOLD, 24);

		JLabel  oneTurnLabel       = new JLabel("Player One");
		JLabel  twoTurnLabel       = new JLabel("Player Two");
		
		JPanel  controlPanel 	   = new JPanel();
		JPanel  oneTurnPanel       = new JPanel();
		JPanel  twoTurnPanel 	   = new JPanel();
		JPanel  playerOnePanel 	   = new JPanel();
		JPanel  playerTwoPanel 	   = new JPanel();
		JPanel  rulesAndSizePanel  = new JPanel();
		JPanel  startAndResetPanel = new JPanel();
		
				startButton 	   = new JButton("START");
				resetButton 	   = new JButton("RESET");
		
				boardPanel 		   = new BoardPanel();
				rulesPanel 	       = new RulesPanel();
				oneTurnViewer 	   = new TurnViewer();
				twoTurnViewer	   = new TurnViewer();
				oneColorPanel 	   = new PlayerColorPanel();
				twoColorPanel 	   = new PlayerColorPanel();
				oneChoicePanel 	   = new PlayerChoicePanel();
				twoChoicePanel 	   = new PlayerChoicePanel();
				boardSetupPanel    = new BoardSetupPanel();
		
		startButton.setFont(buttonFont);
		startButton.setPreferredSize(new Dimension(100, 50));
		startButton.addActionListener(this);
		
		resetButton.setFont(buttonFont);
		resetButton.setPreferredSize(new Dimension(100, 50));
		resetButton.addActionListener(this);
		
		oneTurnLabel.setFont(turnFont);
		twoTurnLabel.setFont(turnFont);
		
		oneTurnPanel.add(oneTurnLabel);
		oneTurnPanel.add(oneTurnViewer);
		twoTurnPanel.add(twoTurnLabel);
		twoTurnPanel.add(twoTurnViewer);
	

		startAndResetPanel.setLayout(new GridLayout(2, 0));
		startAndResetPanel.add(resetButton);
		startAndResetPanel.add(startButton);
		startAndResetPanel.setBorder(BorderFactory.createRaisedBevelBorder());
				
		playerOnePanel.setLayout(new GridLayout(3,0));
		playerOnePanel.add(oneTurnPanel);
		playerOnePanel.add(oneChoicePanel);
		playerOnePanel.add(oneColorPanel);
		playerOnePanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		playerTwoPanel.setLayout(new GridLayout(3,0));
		playerTwoPanel.add(twoTurnPanel);
		playerTwoPanel.add(twoChoicePanel);
		playerTwoPanel.add(twoColorPanel);
		playerTwoPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		rulesAndSizePanel.setLayout(new GridLayout(2,0));
		rulesAndSizePanel.add(rulesPanel);
		rulesAndSizePanel.add(boardSetupPanel);
		rulesAndSizePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		controlPanel.setLayout(new GridLayout(4,0));
		controlPanel.add(playerOnePanel);
		controlPanel.add(playerTwoPanel);
		controlPanel.add(rulesAndSizePanel);
		controlPanel.add(startAndResetPanel);
	
		JScrollPane boardScrollPane = new JScrollPane(boardPanel);
		JSplitPane  splitPane       = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
											controlPanel,
											boardScrollPane);
		
		splitPane.setDividerLocation(298);
		splitPane.setDividerSize(5);
		boardScrollPane.setBackground(Color.BLACK);

		add(splitPane);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(1500,1000);
		setResizable(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if (src == startButton)
		{
			prepareGame();
			Thread t = new Thread(game);
			t.start();
		}
		else if (src == resetButton)
		{
			resetGame();
		}
	}
	

	@Override
	public void run() 
	{
		try {
			createAndShowGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
