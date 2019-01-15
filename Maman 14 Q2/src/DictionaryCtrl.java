import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class DictionaryCtrl 
{
	
	private Dictionary	_theDictionary;
	private DictionaryPanel _thePanel;
	
	public DictionaryCtrl(Dictionary dictionary, DictionaryPanel panel)
	{
		_theDictionary = dictionary;
		_thePanel = panel; 
		
		_thePanel.buttonsAction(new buttonsActionListener());
		_thePanel.disableBtns();
	}


	
	class buttonsActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			/* ROY, Question... would it have been ok to change the buttons permissions to "protected" and then access them through _thePanel.buttonName 
			 * instead of creating a get method?
			 * i did it at the beginning but changed it because i thought it might not be a good design, but i'm not sure...
			 */
			
			//load button
			if (e.getSource().equals(_thePanel.getButton("load")))
			{
				try 
				{
					_theDictionary.loadFile(_thePanel.loadFile());
					//enabling buttons
					_thePanel.enableBtns();
				}
				
				catch (FileNotFoundException e1) 
				{
					//ignore as it mainly happens when the user clicks "cancel"
				}
				
				catch (NoSuchElementException e1)
				{
					e1.printStackTrace();
					JOptionPane.showOptionDialog(null, "Cannot Load File!", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
							null, null, e1);
					
					_theDictionary.clearDictionary();
					_thePanel.refresh(_theDictionary);
					_thePanel.disableBtns();
				}
				
				
				_thePanel.refresh(_theDictionary);
				
				
			}
			
			
			//save button
			if (e.getSource().equals(_thePanel.getButton("save")))
			{
				try 
				{
					_theDictionary.saveFile(_thePanel.saveFile());
				} 
				
				catch (IOException e1) 
				{
					//e1.printStackTrace();
					JOptionPane.showOptionDialog(null, "Cannot Save File!", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
							null, null, e1);
				}
			}
			
			
			//new button
			if (e.getSource().equals(_thePanel.getButton("new")))
			{
				try
				{
					String[] answers = _thePanel.addNewDialog();
					_theDictionary.addEntry(answers[0], answers[1]);
					
					_thePanel.refresh(_theDictionary);
					
					//enabling buttons
					_thePanel.enableBtns();
				}
				
				
				catch (NullPointerException e1)
				{
					//ignoring this error because we don't care about it
				}
			}
			
			
			//update button
			if (e.getSource().equals(_thePanel.getButton("update")))
			{
				try
				{
					String[] answers = _thePanel.updateDialog();
					
					
					if(_theDictionary.searchKey(answers[0]) != null)
					{
						_theDictionary.updateEntry(answers[0], answers[1]);
					}
					
					else
					{
						int result = _thePanel.popup("The key doesn't exist, would you like to create it?", "question");
						if (result == 1) 
							{
								_theDictionary.updateEntry(answers[0], answers[1]);
								_thePanel.popup("Key has been created successfuly", "info");
							}
						
						else
						{
							_thePanel.popup("No action performed", "info");
						}
					}
				}
				
				catch (NullPointerException e1)
				{
					
				}
				_thePanel.refresh(_theDictionary);
			}
			
			
			//remove button
			if (e.getSource().equals(_thePanel.getButton("remove")))
			{
				try
				{
					String keyToRemove =_thePanel.removeDialog();
					_theDictionary.removeEntry(keyToRemove);
				}
				
				catch (NullPointerException e1)
				{
					
				}
				
				_thePanel.refresh(_theDictionary);
			}
			
			
			//clear button
			if (e.getSource().equals(_thePanel.getButton("clear")))
			{
				_thePanel.clearSearchBar();
				_theDictionary.clearDictionary();
				_thePanel.refresh(_theDictionary);
				
				//disabling buttons
				_thePanel.disableBtns();
				
			}
			
		}
		
	}
	
}
