import javax.swing.JFrame;

public class Main 
{
	public static void main (String[] args) throws FileNotFound
	{		
		MyPanel panel = new MyPanel();
		
		JFrame window = new JFrame("Trivia");
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 500);
		
		

		window.add(panel);
		window.setVisible(true);
	}
	
	
}
