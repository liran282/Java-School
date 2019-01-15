import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DictionaryPanel extends JPanel 
{
	
	protected JTextField searchBar	= new JTextField();
	private JPanel topPanel			= new JPanel();
	private JPanel centerPanel 		= new JPanel();
	private JPanel bottomPanel 		= new JPanel();
	private JPanel leftPanel 		= new JPanel();
	private JPanel rightPanel		= new JPanel();
	private JButton addBtn 			= new JButton("New Entry");
	private JButton updateBtn		= new JButton("Update Entry");
	private JButton removeBtn		= new JButton("Delete Entry");
	private JButton clearBtn 		= new JButton("Clear Form");
	private JButton loadBtn 		= new JButton("Load File");
	private JButton saveBtn 		= new JButton("Save File");
	private JLabel seachLbl 		= new JLabel("Search");	
	private String[][] data 		= {};
	private String[] columns		= {"Key", "Value"};
	private JTable mainTable;	 
	
	
	/**
     * Constructor - Creates a new panel
     * 
     *	
     */
	public DictionaryPanel()
	{
		//creating the table
		mainTable = new JTable(data, columns)
		{//locking table cells
			public boolean isCellEditable(int data, int columns)
			{
				return false;
			}
		};
		
		//setting up the main layout
		setLayout(new BorderLayout());
		
		//setting up the center panel
		JScrollPane scroll = new JScrollPane(mainTable);
		mainTable.setFillsViewportHeight(true);
		centerPanel.add(scroll);
		add(centerPanel, BorderLayout.CENTER);
		
		
		//setting up the bottom layout
		bottomPanel.setLayout(new GridLayout(1, 3));
		bottomPanel.add(addBtn);
		bottomPanel.add(updateBtn);
		bottomPanel.add(removeBtn);
		addBtn.setPreferredSize(new Dimension(40, 40));
		add(bottomPanel, BorderLayout.SOUTH);
		
		
		//setting up the top layout
		topPanel.add(seachLbl);
		topPanel.add(searchBar);
		topPanel.add(clearBtn);
		searchBar.setPreferredSize(new Dimension(350, 25));
		add(topPanel, BorderLayout.NORTH);
		

		//setting up the left layout
		leftPanel.setLayout(new GridLayout(12,2, 0, 5));
		leftPanel.add(loadBtn);
		add(leftPanel, BorderLayout.WEST);
		
		
		//setting up the right layout
		rightPanel.setLayout(new GridLayout(12,2, 0, 5));
		rightPanel.add(saveBtn);
		add(rightPanel, BorderLayout.EAST);
		
	}
	
	
	/**
     * Button listener setup
     * 
     *	
     */
	public void buttonsAction(ActionListener e)
	{
		loadBtn.addActionListener(e);
		saveBtn.addActionListener(e);
		addBtn.addActionListener(e);
		updateBtn.addActionListener(e);
		removeBtn.addActionListener(e);
		clearBtn.addActionListener(e);
	}
	
	
	/**
     *Loads a new file
     *
     *@return	filePath	string representation of the chosen file file-path 
     */
	public String loadFile()
	{
		String filePath = "";
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = file.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
		    File selectedFile = file.getSelectedFile();
		    filePath = selectedFile.getAbsolutePath();
		}
		return filePath;
	}
	
	
	/**
     *Saves a file
     * 
     * @return	filePath	string representation of the chosen file file-path 
     */
	public String saveFile()
	{
		String filePath = "";
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = file.showSaveDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
		    File selectedFile = file.getSelectedFile();
		    filePath = selectedFile.getAbsolutePath();
		}
		
		
		return filePath;
	}
	
	
	
	/**
     *Refreshes the JTable
     * 
     */
	public void refresh(Dictionary dictionary)
	{   
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		String [] row = new String[2];
		for (Map.Entry<String, String> entry : dictionary.getMap().entrySet()) 
		{
			row[0] = entry.getKey();
			row[1] = entry.getValue();
		    model.addRow(row);
		}
		mainTable.setModel(model);
		
		
		//setting up the columns width
		TableColumnModel columnModel = mainTable.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(200);
		
		
		//filtering our rows based on the search bar
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(mainTable.getModel());
		mainTable.setRowSorter(rowSorter);
		searchBar.getDocument().addDocumentListener(new DocumentListener()
		{

            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                String text = searchBar.getText();

                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) 
            {
                String text = searchBar.getText();

                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                }
                
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
		
	}
	
	
	/**
     *Dialog box for adding new values
     * 
     * @return	answers	an array of strings with key and value
     */
	public String[] addNewDialog()
	{
		String[] answers = new String[2];
		JTextField key = new JTextField();
		JTextField value = new JTextField();
		Object[] message = {"Key:", key, "Value:", value};
				
		int result = JOptionPane.showConfirmDialog(null, message, "New Entry", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION)
		{
			
			answers[0] = key.getText();
			answers[1] = value.getText();
			
			
		}
		return answers;
		
	}
	
	
	/**
     *Dialog box for adding new values
     * 
     * @return	answers	an array of strings with key and value
     */
	public String[] updateDialog()
	{
		String[] answers = new String[2];
		answers[0] = JOptionPane.showInputDialog("Please choose a key to update");
		if (answers[0] != null)
			answers[1] = JOptionPane.showInputDialog("Please input the new value");
		
		return answers;
	}
	
	
	/**
     *Dialog box for removing a value
     * 
     * @return	a string with the key to remove
     */
	public String removeDialog()
	{
		String key = JOptionPane.showInputDialog("Please choose a key to remove");
		
		if (key != null)
		{
			int result = JOptionPane.showInternalConfirmDialog(null,
					"Are you sure you would like to proceed?", "information",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			
			if (result == JOptionPane.YES_OPTION)
			{
				JOptionPane.showInternalMessageDialog(null, key + " was removed successfuly!",
						"information", JOptionPane.INFORMATION_MESSAGE);
				return key;
			}
			
		}
		return "";
	}
	
	
	/**
     *Get a button
     *
     *@param	btnName	the name of the button to get 
     */
	public JButton getButton(String btnName)
	{
		JButton btn = new JButton();
		switch (btnName)
		{
		case "load":
			return loadBtn;
			
		case "save":
			return saveBtn;
			
		case "new":
			return addBtn;
			
		case "update":
			return updateBtn;
			
		case "remove":
			return removeBtn;
			
		case "clear":
			return clearBtn;
			
		default:
			break;
		}
		return btn;
	}
	
	
	/**
     *Popup
     *
     *@param	str		the message  
     *@param	type	question or info
     */
	public int popup(String str, String type)
	{
		if (type == "question")
		{
			int result = JOptionPane.showInternalConfirmDialog(null,
				str, "Question",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
			if (result == JOptionPane.YES_OPTION)
			{
				return 1;
			}
				
			else
			{
				return 0;
			}
		}
		
		if (type == "info")
		{
			int result = JOptionPane.showInternalConfirmDialog(null,
					str, "Information",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return 0;
	}
	
	
	/**
     *Clears the searchbar
     * 
     */
	public void clearSearchBar()
	{
		searchBar.setText("");
	}
	
	/**
     *Enables buttons clear, remove and update
     * 
     */
	public void enableBtns()
	{
		clearBtn.setEnabled(true);
		removeBtn.setEnabled(true);
		updateBtn.setEnabled(true);

	}
	
	
	/**
     *Disable buttons clear, remove and update
     * 
     */
	public void disableBtns()
	{
		clearBtn.setEnabled(false);
		removeBtn.setEnabled(false);
		updateBtn.setEnabled(false);
	}
}
