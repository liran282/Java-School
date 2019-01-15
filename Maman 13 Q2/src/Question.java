
public class Question 
{
	private String _question;
    private String[] _options = new String [4];
    private String _answer;
    
    
    /**
     * Constructor
     *
     */
    public Question(String question, String answer, String[] options) 
    {
        _question = question;
        _options = options;
        _answer = answer;
    }

    
    /**
     * Gets the question
     *
     */
    public String getQuestion() 
    {
        return _question;
    }
    
    
    /**
     * Gets the options from a given cell
     * 
     *@param	cell 	the cell to get the options from
     */
    public String getOptions(int cell)
    {
        return _options[cell];
    }

    
    /**
     * Gets the answer of a question
     *
     */
    public String getAnswer() 
    {
        return _answer;
    }

    
    /**
     * Prints out a question
     *
     */
    public String toString() 
    {
    	
        String print = _question + "\n";
        for (int i = 0; i < _options.length; i++) 
        {
        	print += _options[i] + "\n";
        }
        
        return print + "\n";
        
    }
    
    
}
