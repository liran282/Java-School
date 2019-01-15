import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main 
{	
	
	public static void main (String[] args)
	{
		JFrame window = new JFrame("Your BEAUTIFUL Drawing");
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		
		
		Data points = new Data();
		
		MyPanel drawing = new MyPanel(points);
		window.add(drawing);
		window.setVisible(true);
		
		boolean flag = true;
		String input = "";
		String delims = "[ ,]";
		
		
		//getting the user's input
		while (flag)
		{
			input = JOptionPane.showInputDialog("Choose a point in the form of x,y. x and y should be between 0 and 400");
			
			//dealing with space and an input that is too short 
			if (input.length() < 3)
			{
				flag = false;
				break;
			}
				
			
			
			String tokens[] = input.split(delims);
			
			
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			
			if (x >= 0 && x <= 400 && y >= 0 && y <= 400)
			{
				if (points.getSize() == 0)
				{
					Point p = new Point(x, y);
					points.addPoint(p);
					drawing.repaint();
				}
				else
				{	
					Point p = new Point(x, y);
					points.addPoint(p);
					drawing.repaint();
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "You've entered one or more illegal values (smaller than 0 or larger than 400. \nPlease try again");
			}
			
			
		}
		//JOptionPane.showMessageDialog(null, "The points are:" + points);
		
	}
}
