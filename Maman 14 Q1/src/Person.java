
public class Person implements Comparable<Person>
{
	private String _name;
	private String _id;
	private int _yearOfBirth;
	
	
	/**
     * Constructs a person 
     *
     */
	public Person(String name, String id, int yearOfBirth)
	{
		_name = name;
		_id = id;
		_yearOfBirth = yearOfBirth;
	}
	
	
	/**
     * Overrides compareTo 
     *
     *@return	
     */
	public int compareTo(Person person) 
	{
		if (_yearOfBirth < person._yearOfBirth)
			return 1;
		
		else if (_yearOfBirth == person._yearOfBirth)
			return 0;
		
		else
			return -1;
	}
	
	
	/**
     * Overrides toString 
     *
     *@return	string representation of a person
     */
	public String toString()
	{
		return("[Name: "+_name + "; ID: "+_id + "; Year of Birth: "+_yearOfBirth +"]");
	}
}
