
public class Point 
{
	private int _x;
	private int _y;
	
	
	/**
     * Constructs a point 
     *
     * @param	x	the x of a point
     * @param	y	the y of a point
     */
	Point(int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	
	/**
     * Get X 
     *
     * @return	_x	the x of the point
     */
	public int getX()
	{
		return _x;
	}
	
	
	/**
     * Get Y 
     *
     * @return	_y	the y of the point
     */
	public int getY()
	{
		return _y;
	}
	
	
	/**
     * String representation of a point 
     *
     * @return	String	in the form of (x, y)
     */
	public String toString()
	{
		return (" ("+_x+", "+_y+")");
	}
	
}
