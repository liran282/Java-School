
public class GenericElement <T>
{
	private T _elementContent;
	private GenericElement<T> _nextElement;
	
	
	
	/**
     * Constructor - constructs a element and sets the _nextElement pointer to null
     *
     *@param	element	the content to be added
     */
	public GenericElement(T content)
	{
		_elementContent = content;
		_nextElement = null;
	}
	
	
	/**
     * Constructor - constructs a element and sets _nextElement to the next element received as a parameter
     *
     *@param	content		the content to be added
     *@param	next	the next element to point to
     */
	public GenericElement(T content, GenericElement<T> next )
	{
		_elementContent = content;
		_nextElement = next;
	}
	
	
	/**
     * Sets the element to a specific value
     *
     *@param	content		the content to be added
     */
	public void setCell(T content)
	{
		_elementContent = content;
	}
	
	
	/**
     * Sets the pointer of the next element to a specific value
     *
     *@param	next	the next element to point to
     */
	public void setNext(GenericElement<T> next)
	{
		_nextElement = next;
	}
	
	
	/**
     * Gets the element's content
     *
     */
	public T getContent()
	{
		return _elementContent;
	}
	
	
	/**
     * Gets the pointer's value
     *
     */
	public GenericElement<T> getNext()
	{
		return _nextElement;
	}
	
}
