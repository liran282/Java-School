import javax.swing.JFrame;

public class Tester 
{
	public static void main (String[] args)
	{
		MyPanel panel = new MyPanel();
	
		JFrame window = new JFrame("Four in a Row");
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 500);
		
		

		window.add(panel);
		window.setVisible(true);
	}
}
