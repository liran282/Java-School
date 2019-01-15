package secondQuestion;

public class Element 
{
	private double _mekadem;
	private int _power;
	
	/**
     * Element empty contructor, sets class variables to 0
     *
     */
	public Element()
	{
		_mekadem = 0;
		_power = 0;
	}
	
	/**
     * Element constructor. Sets class variables accordingly
     *
     * @param	num		the number itself
     * @param	power	the power of the number
     */
	public Element(double num, int power)
	{
		_mekadem = num;
		_power = power;
	}
	
	/**
     * Copy constructor
     *
     * @param	other	another element to be copied
     */
	public Element(Element other)
	{
		_mekadem = other.getMekadem();
		_power = other.getPower();
	}
	
	/**
     * Mekadem getter
     *
     * @return	_mekadem	the mekadem of the element
     */
	public double getMekadem()
	{
		return _mekadem;
	}
	
	/**
     * Power getter
     *
     * @return	_power	the power of the element
     */
	public int getPower()
	{
		return _power;
	}
	
	/**
     * Oveeride toString 
     *
     * @return	better representation 
     */
	public String toString()
	{
		return (_mekadem + "^" + _power);
	}
	

	
}
