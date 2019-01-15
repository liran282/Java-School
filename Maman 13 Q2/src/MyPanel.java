import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Constructor
 *
 */
public class MyPanel extends JPanel implements ActionListener
{
	private int _score = 0;
	private int _timer = 10;
	private JPanel gameButtonsGrid = new JPanel();
	private JPanel optionsGrid = new JPanel();
	private JPanel leftLayout = new JPanel();
	private JPanel rightLayout = new JPanel();
	private JButton end = new JButton("End Game");
	private JButton start = new JButton("New Game");
	private JLabel scoreLabel = new JLabel("   Score   " + _score + "  ");
	private JLabel timerLabel = new JLabel("     Timer    " + _timer + "  ");
	private JLabel questionLabel = new JLabel("       ");
	private ArrayList <String> options = new ArrayList <String>();
	private ArrayList <JButton> buttons = new ArrayList <JButton>();
	private String _answer;
	Questions questions;
	Timer questionTimer;
	Timer wrongAnswerTimer;
	Timer timerLabelTimer;
	
	
	public MyPanel() throws FileNotFound
	{
		//=============== different timers START===============
		//10 sec timer between questions
		questionTimer = new Timer(10000, new QuestionTimerListener());
		
		//2 sec timer after choosing the wrong answer
		wrongAnswerTimer = new Timer(2000, new WrongAnswerTimerListener());
		
		//1 sec timer for the timer label on the right panel
		timerLabelTimer = new Timer(1000, new TimerLabelTimer());
		timerLabelTimer.start();
		
		//=============== different timers END ===============
		
		 questions = new Questions();
		
		//setup the grid
		optionsGrid.setLayout(new GridLayout(4, 1));
		
		//setup the buttons
		for (int j = 0; j < 4; j++)
		{
			buttons.add(new JButton());
			buttons.get(j).setPreferredSize(new Dimension(50, 50));
			optionsGrid.add(buttons.get(j));
			buttons.get(j).addActionListener(this);
		}
		
		
		
		//=============== grid and layouts START ===============
		
		//setting up the whole board layout
		setLayout(new BorderLayout());
		add(optionsGrid, BorderLayout.CENTER);
		
		
		gameButtonsGrid.setLayout(new GridLayout(1,2));
		gameButtonsGrid.add(end);
		gameButtonsGrid.add(start);

		add(gameButtonsGrid, BorderLayout.SOUTH);
		end.setPreferredSize(new Dimension(5, 50));
		end.addActionListener(this);
		start.addActionListener(this);
		start.setEnabled(false);
		
		questionLabel.setPreferredSize(new Dimension(70, 100));
		questionLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(questionLabel, BorderLayout.NORTH);
		
		//setting up the right panel layout
		rightLayout.setLayout(new GridLayout(10, 1));
		rightLayout.add(timerLabel);
		add(rightLayout, BorderLayout.EAST);
		
		
		//setting up the left panel layout 
		leftLayout.setLayout(new GridLayout(10, 1));
		leftLayout.add(scoreLabel);
		add(leftLayout, BorderLayout.WEST);
		
		//=============== grid and layouts END =================
		
		//present the first question
		presentQuestion();
		
		
	}
	
	
	/**
     * Presents a question on the panel
     *
     */
	private void presentQuestion()
	{
		_timer = 10;
		timerLabel.setText("     Timer    " + _timer + "  ");
		questionTimer.restart();
		wrongAnswerTimer.stop();
		questionLabel.setText("         " + questions.getQuestions(0).getQuestion());
		options.clear();

		
		
		for (int j = 0; j < 4; j++)
		{
			options.add(questions.getQuestions(0).getOptions(j));
			_answer = questions.getQuestions(0).getAnswer();
		}	
		
		Collections.shuffle(options);
		
		
		
		for (int j = 0; j < 4; j++)
			buttons.get(j).setText(options.get(j));					
	}
	
	
	/**
     * Based on the chosen option, perform a certain action
     *
     * @param	e		performed action
     */
	public void actionPerformed(ActionEvent e)
	{
				if (e.getActionCommand() == _answer)
				{
					questionTimer.stop();
					_score += 10;
					scoreLabel.setText("   Score   " + _score + "  ");
					restartGame();
				}
				
				
				else if (e.getSource().equals(end))
				{
					endGame();
					
				}
				
				
				else if (e.getSource().equals(start))
				{
					try 
					{
						startNewGame();
					}
					catch (FileNotFound e1) 
					{
						e1.printStackTrace();
					}
					
				}
				
				else
					{
					//if it's the wrong answer - stop timer, start wrong answer timer, present the correct answer, -5 score, update label
						questionTimer.stop();
						wrongAnswerTimer.start();
						_score -= 5;
						scoreLabel.setText("   Score   " + _score + "  ");
						
						
						for (int j = 0; j < 4; j++)
						{
							//dealing with buttons
							buttons.get(j).setEnabled(false);
							
							if (buttons.get(j).getText() == _answer)
								buttons.get(j).setText(buttons.get(j).getText() + " - This is the Correct Answer");
						}
						
					} 
	}
	
	
	/**
     * Restarts or ending a game, depends on if there enough questions
     *
     */
	private void restartGame()
	{
		if (questions.getLength() > 1)
		{
			questions.remove();
			presentQuestion();
		}

		else
		{
			questionTimer.stop();
			endGame();
		}		
	}
	
	
	/**
     * Starts a new game
	 * @throws FileNotFound 
     *
     */
	private void startNewGame() throws FileNotFound
	{		
		_score = 0;
		_timer = 10;
		timerLabel.setText("     Timer    " + _timer + "  ");
		scoreLabel.setText("   Score   " + _score + "  ");
		
		questions = new Questions();

		JOptionPane.showMessageDialog(null, "Starting a new game!");
		
		//dealing with buttons
		for (int j = 0; j < 4; j++)
			buttons.get(j).setEnabled(true);
		
		end.setEnabled(true);
		start.setEnabled(false);
		
		questionTimer.restart();
		timerLabelTimer.restart();
		
		restartGame();
	}
	
	
	/**
     * Finishes a game
     *
     */
	private void endGame()
	{
		//stop all timers
		questionTimer.stop();
		wrongAnswerTimer.stop();
		timerLabelTimer.stop();
		
		//dealing with buttons
		for (int j = 0; j < 4; j++)
			buttons.get(j).setEnabled(false);
		
		end.setEnabled(false);
		start.setEnabled(true);
		
		//update timer label
		timerLabel.setText("     Timer    " + 0 + "  ");
		
		//present a message to the user
		JOptionPane.showMessageDialog(null, "Game over! Your Score is " + _score);
		
	}
	
	
	/**
     * Ten second timer between questions. -5 score if timer passed, change score label accordingly 
     * and move to the next question 
     *
     */
	private class QuestionTimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			_score -= 5;
			scoreLabel.setText("   Score   " + _score + "  ");
			restartGame();
		}
	}
	
	
	/**
     * Two second timer to show the correct answer and move to the next question
     *
     */
	private class WrongAnswerTimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			restartGame();
			
			if (questions.getLength() > 1)
			{
				for (int j = 0; j < 4; j++)
					buttons.get(j).setEnabled(true);
				
			}
		}
	}
	
	
	/**
     * One second timer that updates the timer label
     *
     */
	private class TimerLabelTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			_timer--;
			timerLabel.setText("     Timer    " + _timer + "  ");
		}
	}
	
	
	/**
     * PaintComponent
     *
     */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}
}
