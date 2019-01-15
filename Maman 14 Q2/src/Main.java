import java.awt.Color;

import javax.swing.JFrame;

public class Main 
{
	public static void main(String [] args)
	{	
		DictionaryPanel myPanel = new DictionaryPanel();
		Dictionary dictionary = new Dictionary();
		DictionaryCtrl controler = new DictionaryCtrl(dictionary, myPanel);
		//myPanel.setBackground(Color.GRAY);
		
		JFrame window = new JFrame("Dictionary");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(670, 530);
		window.setBackground(Color.BLUE);
		window.add(myPanel);
		window.setVisible(true);

	}
}
