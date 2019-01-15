import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Disc extends JPanel
{		
	private boolean _fill = false;//flag to determine if there's already a disk in a disc cell
	private int _player = -1; //defines the player. 0=RED, 1=BLUE and -1=NULL 
	
	
	/**
     * Constructor that sets poetries to the cell
     *
     */
	public Disc()
	{
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	

	/**
     * Overriding paintComponent
     *
     * @param	g		the graphics object
     */
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		//set the color and paint the disc for the blue player
		if (_fill && _player == 1)
		{
			g.setColor(Color.BLUE);
			g.fillOval(15, 15, 50, 50);
		}
		
		//set the color and paint the disc for the red player
		if (_fill && _player == 0)
		{
			g.setColor(Color.RED);
			g.fillOval(15, 15, 50, 50);
		}
		
	}
	
	
	/**
     * Sets the fill of a Disc cell
     *
     * @param	value		true=there's a disc, false=no disc
     */
	public void setFill(boolean value)
	{
		_fill = value;
	}
	
	
	/**
     * Gets the fill of a Disc cell
     *
     * @return	_fill		true=there's a disc, false=no disc
     */
	public boolean getFill()
	{
		return _fill;
	}
	
	
	/**
     * Adds a disc to a certain cell
     *
     * @param	player		the player we need to add the disc to
     */
	public void addDisc(int player)
	{
		_fill = true;
		_player = player;
	}
	
	
	/**
     * Gets the player number. 0=RED, 1=BLUE and -1=NULL
     *
     * @return	_player		the assigned player number
     */
	public int getPlayer()
	{
		return _player;
	}
	
	
	/**
     * Sets the player number based on the input. 0=RED, 1=BLUE and -1=NULL
     *
     * @param	player		the player number to be assigned
     */
	public void setPlayer(int player)
	{
		_player = player;
	}

	
}
