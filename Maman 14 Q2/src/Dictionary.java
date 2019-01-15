import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Dictionary 
{
	Scanner input;
	TreeMap<String, String> dictionary = new TreeMap<String, String>();
	
	/**
     * Constructor - Creates a new TreeMap
     * 	
     */
	public Dictionary()
	{
		
	}
	
	/**
     *Loads a new file 
     * 
     *@param	filePath	the path of the file we need to open
	 * @throws FileNotFoundException 
     */
	public void loadFile(String filePath) throws FileNotFoundException
	{
		input = new Scanner(new File(filePath));
		

		String line = input.nextLine();
		while (input.hasNext()) //stops before the last line is parsed
		{
			if (line.contains("  ")) 
			{
				Scanner scanLine = new Scanner(line).useDelimiter("  ");
				String key = scanLine.next();
				String val;
				
				try
				{
					val = scanLine.next();
					dictionary.put(key, val);
				}
				
				catch (NoSuchElementException e1)
				{
					dictionary.put(key, "");
					line = input.nextLine();
				}
				
			}
			
			
			line = input.nextLine();
		}
		
		if (line.contains("  ")) //parsing the last line
		{
			Scanner scanLine = new Scanner(line).useDelimiter("  ");
			dictionary.put(scanLine.next(), scanLine.next());
		}
		
		
		input.close(); 
	}
	
	
	/**
     *Save a new file
     * 
     *@param	filePath	the path of the file we need to open		
	 * @throws IOException 
     */
	public void saveFile(String filePath) throws IOException
	{
		FileWriter fw = new FileWriter(filePath); 
		BufferedWriter writer = new BufferedWriter(fw);
	    for (Map.Entry<String, String> entry : dictionary.entrySet()) 
		{
	    	writer.write(entry.getKey() + " | " + entry.getValue() +"\n");
		}
	    writer.close();		   
	}
	
	
	/**
     *Adds a new entry to the dictionary 
     * 
     *@param	key	the key of the entry to be added
     *@param	val	the value of the key		
     */
	public void addEntry(String key, String val)
	{
		dictionary.put(key, val);
	}
	
	
	/**
     *Removes an entry from the dictionary
     * 
     *@param	key	the key of the entry to be removed	
     */
	public void removeEntry(String key)
	{
		dictionary.remove(key);
	}
	
	
	/**
     *Updates a value of a specific key in the dictionary
     * 
     *@param	key	the key of the entry to be updated
     *@param	val	the new value of the key	
     */
	public void updateEntry(String key, String val)
	{
		addEntry(key, val);
	}
	
	
	/**
     *Searches for a specific key in the dictionary 
     * 
     *@param	key	the key of the entry to be searched	
     */
	public String searchKey(String key)
	{
		return dictionary.get(key);
	}
	
	
	/**
     *Returns the TreeMap
	 * @return 
     * 
     *	
     */
	public TreeMap<String, String> getMap()
	{
		return dictionary;
	}
	
	
	/**
     *Prints the dictionary for debugging purposes 
     * 
     *	
     */
	public void clearDictionary()
	{
		dictionary.clear();
	}
	
	
	/**
     *Prints the dictionary for debugging purposes 
     * 
     *	
     */
	public void printDictionary()
	{
		for (Map.Entry<String, String> entry : dictionary.entrySet()) 
		{
		     System.out.println(entry.getKey() + " | " + entry.getValue() +"\n");
		}
	}
	
}
