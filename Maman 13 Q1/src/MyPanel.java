import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
	
	
public class MyPanel extends JPanel implements ActionListener
{
		private final int ROW = 5;
		private final int COL = 7;
		private final int RED = 0;
		private final int BLUE = 1;
		private int _numOfMoves = 0;
		private JPanel discGrid = new JPanel();
		private JPanel buttonGrid = new JPanel();
		private JPanel gridLayout = new JPanel();
		private JPanel leftLayout = new JPanel();
		private JPanel rightLayout = new JPanel();
		private JButton clear = new JButton("New Game");
		private JLabel movesPerformedLabel = new JLabel("              0");
		private JLabel movesLabel = new JLabel("  Moves Performed  ");
		private JLabel nextColorLabel = new JLabel("  Next Turn   ");
		private JLabel playerColorLabel = new JLabel("       RED");
		

		
		//creating an array of buttons
		JButton[] buttons = new JButton[COL];
		//creating a matrix for the grid
		Disc [][] mat = new Disc[ROW][COL];
		
		
		public MyPanel()
		{
			//setting up the discs layout
			discGrid.setLayout(new GridLayout(ROW, COL));
			
			//creating our objects in each cell
			for (int row = 0; row < ROW; row++)
			{
				for (int col = 0; col < COL; col++ )
				{
					mat[row][col] = new Disc();
					discGrid.add(mat[row][col]);
				}
			}
			
			//setting up the buttons layout
			buttonGrid.setLayout(new GridLayout(1, COL));
			
			for (int i = 0; i < buttons.length; i++)
			{
				buttons[i] = new JButton("Click Here");
				buttons[i].setPreferredSize(new Dimension(50, 50));
				buttonGrid.add(buttons[i]);
				buttons[i].addActionListener(this);
			}
			
			
			
			//setting up the whole grid layout 
			gridLayout.setLayout(new BorderLayout());
			gridLayout.add(discGrid, BorderLayout.CENTER);
			gridLayout.add(buttonGrid, BorderLayout.SOUTH);
			
			
			
			//setting up the whole board layout
			setLayout(new BorderLayout());
			add(gridLayout, BorderLayout.CENTER);
			
			
			add(clear, BorderLayout.SOUTH);
			clear.setPreferredSize(new Dimension(5, 50));
			clear.addActionListener(this);
			
			
			//setting up the right panel layout
			rightLayout.setLayout(new GridLayout(10, 1));
			rightLayout.add(nextColorLabel);
			rightLayout.add(playerColorLabel);
			add(rightLayout, BorderLayout.EAST);
			
			
			//setting up the left panel layout 
			leftLayout.setLayout(new GridLayout(10, 1));
			leftLayout.add(movesLabel);
			leftLayout.add(movesPerformedLabel);
			add(leftLayout, BorderLayout.WEST);
			
			playerColorLabel.setForeground(Color.red);
		}
		
		
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
		}
		
		
		/**
	     * Based on the chosen column, checks if there's an open slot and if so, adds a new disc
	     *
	     * @param	e		performed action
	     */
		public void actionPerformed(ActionEvent e)
		{
			//dealing with the columns buttons
			for (int col = 0; col < COL; col++) 
			{
				if (e.getSource().equals(buttons[col]))
				{
					//check if there's an open slot on this column
					int avilableRow = findOpenSlot(mat, col);
					if (avilableRow != -1)
					{
						//based on the number of moves, decide which player gets to play divisible by 2 = RED player
						if (_numOfMoves % 2 == 0)
						{
							mat[avilableRow][col].addDisc(RED);
							_numOfMoves++;
							movesLabel.setText("  Moves Performed  ");
							movesPerformedLabel.setText("              " + _numOfMoves);
							playerColorLabel.setForeground(Color.blue);
							playerColorLabel.setText("       BLUE");
							
							//checking if this player is the winner
							if (doWeHaveAWinner(RED))
								JOptionPane.showMessageDialog(null, "RED Player Wins!"); 
						}
						
						else //based on the number of moves, decide which player gets to play = BLUE player
						{
							mat[avilableRow][col].addDisc(BLUE);
							_numOfMoves++;
							movesLabel.setText("  Moves Performed  ");
							movesPerformedLabel.setText("              " + _numOfMoves);
							playerColorLabel.setForeground(Color.red);
							playerColorLabel.setText("       RED");
							
							//checking if this player is the winner
							if (doWeHaveAWinner(BLUE))
								JOptionPane.showMessageDialog(null, "BLUE Player Wins!");
						}
					}
					else
						buttons[col].setEnabled(false);
					repaint();
				}
			}
			
			//dealing with the "clear" button
			if (e.getSource().equals(clear))
			{
				clearBoard();
				repaint();
			}
		}
		
		
		/**
	     * Finds an open slot on a given column
	     *
	     * @param	mat		the matrix to test
	     * @param	col		the column to test
	     * @return	int		of the open slot
	     */
		private int findOpenSlot(Disc[][] mat, int col)
		{
			for (int row = mat.length-1; row > -1; row--)
			{
				if (mat[row][col].getFill() == false)
					return row;
				
			}
			return -1;
		}
		
		
		/**
	     * Clears the board and starts a new game
	     *
	     */
		private void clearBoard()
		{
			for (int row = 0; row < ROW; row++)
			{
				for (int col = 0; col < COL; col++ )
				{
					mat[row][col].setFill(false);
					mat[row][col].setPlayer(-1);
					buttons[col].setEnabled(true);
					_numOfMoves = 0;
					movesLabel.setText("  Moves Performed  ");
					movesPerformedLabel.setText("              " + _numOfMoves);
					playerColorLabel.setForeground(Color.red);
					playerColorLabel.setText("       RED");
				}
			}
		}
		
		
		/**
	     * Checks if someone won the game
	     *
	     *@param	player		will check if this player is the winner
	     */
		private boolean doWeHaveAWinner(int player)
		{
			// checking horizontally 
		    for (int row = mat.length-1; row > -1 ; row-- )
		    {
		        for (int col = 0; col < mat[0].length-3; col++)
		        {
		            if (mat[row][col].getPlayer() == player &&  mat[row][col+1].getPlayer() == player &&
		            		mat[row][col+2].getPlayer() == player &&  mat[row][col+3].getPlayer() == player)
		                return true;
		        }
		    }
		    
		    // checking vertically 
		    for (int row = mat.length-1; row > mat.length-3 ; row-- )
		    {
		        for (int col = 0; col < mat[0].length-1; col++)
		        {
		            if ( mat[row][col].getPlayer() == player &&  mat[row-1][col].getPlayer() == player && 
		            		mat[row-2][col].getPlayer() == player &&  mat[row-3][col].getPlayer() == player)
		            	return true;        
		        }
		    }
		    
		    // checking ascending diagonal 
		    for (int row = mat.length-2; row < mat.length ; row++ )
		    {
		        for (int col = 0; col < mat[0].length-3; col++)
		        {
		            if ( mat[row][col].getPlayer() == player &&  mat[row-1][col+1].getPlayer() == player &&
		            		mat[row-2][col+2].getPlayer() == player &&  mat[row-3][col+3].getPlayer() == player)
		            	return true;
		        }
		    }
		    
		    // checking descending diagonal
		    for (int row = 1; row > -1 ; row--)
		    {
		        for (int col = 0; col < mat[0].length-3; col++)
		        {
		            if ( mat[row][col].getPlayer() == player &&  mat[row+1][col+1].getPlayer() == player &&
		            		mat[row+2][col+2].getPlayer() == player &&  mat[row+3][col+3].getPlayer() == player)
		            	return true;
		        }
		    }

		    return false;
		}
			
		
	}


