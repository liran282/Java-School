import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Questions 
{
	Scanner input;
    ArrayList <Question> questions = new ArrayList<Question>(); 
    
    

    
    
    public Questions() throws FileNotFound
	{
    	//opening the file and dealing with the possible "file not found" exception 
		try 
		{
			input = new Scanner(new File("/Users/ltamam16/Documents/trivia.txt"));
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("Oops! Cannot open the trivia file.\n");
			JOptionPane.showMessageDialog(null, "Oops! Cannot open the trivia file. Please make sure the path is correct ");

		}
		
		//parsing and adding the questions into an array of strings
		while (input.hasNext())
		{
			String [] options = new String[4];
	    	String _answer;
	    	String _question;
			String line = input.nextLine(); 
			
			if (line.contains("?"))
			{
				_question = line;
				_answer = input.nextLine();
				options[0] = _answer;
				
				for(int i = 1; i < 4; i++) 
				{
					line = input.nextLine();
					options[i] = line;
					
				}
				//adding the new question to the questions ArrayList
				questions.add(new Question(_question, _answer, options));
				
			}	
		}
		
		input.close(); 
	
	//shuffle the list of questions
	Collections.shuffle(questions); 
	
	}
    
    
    /**
     * Gets a question from a given cell
     * 
     *@param	cell	the cell of the question asked
     */
    public Question getQuestions(int cell)
    {
    	return questions.get(cell);
    }
    
    
    /**
     * Gets the length of the ArrayList
     *
     */
    public int getLength()
    {
    	return questions.size();
    }
    
    
    /**
     * Deletes the first cell in the ArrayList
     *
     */
    public void remove()
    {
    	questions.remove(0);
    }
    
    
  
}

 
   
