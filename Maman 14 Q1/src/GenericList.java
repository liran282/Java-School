import java.util.ArrayList;

public class GenericList <T>
{
	private GenericElement<T> _head;
	private GenericElement<T> _tail;
	
	
	
	
	/**
     * Constructor - 
     *
     */
	public GenericList()
	{
		_head = null;
		_tail = null;
	}
	
	
	/**
     * Gets the first element in the arrayList
     *
     */
	public GenericElement<T> getHead()
	{
		return _head;
	}
	
	
	/**
     * Gets the last element in the arrayList
     *
     */
	public GenericElement<T> getTail()
	{
		return _tail;
	}
	
	
	/**
     * Creates a new element with a given content and adds it to the linked list
     *
     *@param	content 	the content of the element to be added
     */
	public void addElement(T content)
	{
		if (_head == null) //if the list is empty and we're adding the first element
		{
			GenericElement<T> element = new GenericElement<T>(content);
			_head = element;
			_tail = element;
		}
		
		else //we have at least one element and we would like to add another at the end
		{
			GenericElement<T> element = new GenericElement<T>(content);
			_tail.setNext(element);
			_tail = _tail.getNext();
		}
	}
	
	
	/**
     * Removes the first element off of the linked list and return it's content
     *
     *@return	the content of the first element that was removed
     */
	public GenericElement<T> remove()
	{
		try
		{
			if (_head == null)
			{
				throw new EmptyListException();
			}
			
			else 
			{
				GenericElement<T> temp = _head;
				_head = _head.getNext();
				return temp;
			}
			
		}
		
		catch (EmptyListException e)
		{
			System.out.println("\nERROR: Cannot remove the last element. The Linked-List is empty!");
		}
		
		return null;
	}
	
	
	
	/**
     * Overrides toString 
     *
     *@return	string representation of the linked-list
     */
	public String toString()
	{
		String str = "";
		GenericElement<T> p = _head; 
		
		while (p != null)
		{
			str += p.getContent() + " -> ";
			p = p.getNext();
		}
		
		str += "null";
		return str;
	}
}
