import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanel extends JPanel 
{
	Data _points;
	
	/**
     * Constructor
     *
     * @return	a pointer to the arrayList
     */
	public MyPanel(Data points)
	{
		_points = points;
	}
	
	
	/**
     * Painting everything on the screen
     *
     * @param	g			the graphics object
     */
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		
		for (int i = 0; i < _points.getSize()-1; i++)
		{
			//drawing a line between two points
			g.drawLine(_points.getPoint(i).getX(), _points.getPoint(i).getY(), _points.getPoint(i+1).getX(), _points.getPoint(i+1).getY());
			
			//calculate the mid point between two points
			int midX = (_points.getMidPoint(_points.getPoint(i), _points.getPoint(i+1))).getX();
			int midY = (_points.getMidPoint(_points.getPoint(i), _points.getPoint(i+1))).getY();
			
			//calculate the distance between the two points and converting it to a string
			double distance = _points.getDistance(_points.getPoint(i), _points.getPoint(i+1));	
			String distanceSTR = String.valueOf(distance);
			distanceSTR = distanceSTR.substring(0, Math.min(distanceSTR.length(), 7));
			
			//writing the distance in the middle of the line
			g.drawString(distanceSTR, midX, midY);
		}
	}
}
