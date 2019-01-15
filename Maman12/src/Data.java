import java.util.ArrayList;

public class Data 
{
	private ArrayList <Point> _points;

	
	/**
     * Constructs an arrayList of Point objects
     *
     */
	Data()
	{
		_points = new ArrayList <Point>();
	}
	
	
	/**
     * Adds a point to an arrayList
     *
     * @param	point	a point to be added to the arrayList
     */
	public void addPoint(Point point)
	{
		_points.add(point);
	}
	
	
	/**
     * Get a point from an arrayList
     *
     * @param	index	the index of the point to be returned
     * @return	point 	the point in the requested index
     */
	public Point getPoint(int index)
	{
		return _points.get(index);
	}
	
	
	/**
     * Get the middle point between two points
     *
     * @param	p1			the first point
     * @param	p2			the second point
     * @return	midPoint 	the middle point
     */
	public Point getMidPoint(Point p1, Point p2)
	{
		int x = (p1.getX() + p2.getX()) / 2;
		int y = (p1.getY() + p2.getY()) / 2;
		
		Point midPoint = new Point(x, y);
		
		return midPoint;
	}
	
	
	/**
     * Calculates the distance between two given points
     *
     * @param	p1			the first point
     * @param	p2			the second point
     * @return	distance 	the distance between the two points
     */
	public double getDistance(Point p1, Point p2)
	{
		double deltaX = (p2.getX() - p1.getX());
		double deltaY = (p2.getY() - p1.getY());
		
		double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		
		return distance;
	}
	
	
	/**
     * Get the length of the arrayList
     *
     * @return	the length (size)
     */
	public int getSize()
	{
		return _points.size();
	}
	
	
	/**
     * Overriding toString
     *
     * @return	the String representation of the arrayList
     */
	public String toString()
	{
		return (""+_points);
	}
}
